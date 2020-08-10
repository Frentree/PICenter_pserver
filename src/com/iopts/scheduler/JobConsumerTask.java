package com.iopts.scheduler;

import java.sql.SQLException;
import java.util.List;

import org.apache.http.ParseException;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.google.gson.Gson;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.iopts.skyun.recon.vo.groupall.FindsCo;
import com.iopts.skyun.recon.vo.groupall.remediations;
import com.iopts.skyun.recon.vo.groupall.subpaths;
import com.iopts.skyun.recon.vo.groupall.summaryCo;
import com.skyun.app.util.config.AppConfig;
import com.skyun.app.util.config.IoptsCurl;
import com.skyun.recon.util.database.ibatis.SqlMapInstance;
import com.skyun.recon.util.database.ibatis.tr.DBInsertTable;
import com.skyun.recon.util.database.ibatis.vo.findlVo;
import com.skyun.recon.util.database.ibatis.vo.subpathVo;
import com.skyun.recon.util.database.ibatis.vo.summaryVo;
import com.skyun.recon.util.database.ibatis.vo.targetVo;

public class JobConsumerTask {
	private static Logger logger = Logger.getLogger("server");

	private String gid = "";
	private String tid = "";

	DBInsertTable tr = new DBInsertTable();
	private static SqlMapClient sqlMap = null;

	public JobConsumerTask(targetVo info) {

		this.sqlMap = SqlMapInstance.getSqlMapInstance();

		this.gid = info.getGroup_id();
		this.tid = info.getTarget_id();

		String user = AppConfig.getProperty("config.recon.user");
		String pass = AppConfig.getProperty("config.recon.pawwsord");
		String ip = AppConfig.getProperty("config.recon.ip");
		String port = AppConfig.getProperty("config.recon.port");


		//String curlurl = String.format("-k -X GET -u %s:%s https://%s:%s/beta/targets/%s/matchobjects?limit=1000000?details=true", user, pass, ip, port, info.getTarget_id());
		String curlurl = String.format("-k -X GET -u %s:%s https://%s:%s/beta/targets/%s/matchobjects?details=true&limit=10000", user, pass, ip, port, info.getTarget_id());
		logger.info("curlurl [" + curlurl + "]");

		// HttpResponse response = curl(curlurl);

		String[] array = curlurl.split(" ");

		String jsonjunmun = "";

		String json_string;
		try {
			// json_string = EntityUtils.toString(response.getEntity());

			json_string = new IoptsCurl().opt(array).exec(null);

			if (json_string == null || json_string.length() < 1) {
				logger.error("Data Null Check IP or ID: " + curlurl);
			} else {

				JSONArray temp1 = new JSONArray(json_string);

				logger.info(info.getName() + " Find Files : " + temp1.length());

				// this.sqlMap.startTransaction();
				// this.sqlMap.startBatch();

				for (int i = 0; i < temp1.length(); i++) {
					Gson gson = new Gson();
					jsonjunmun = temp1.get(i).toString();
					FindsCo f = gson.fromJson(jsonjunmun, FindsCo.class);

					findlVo fvo = new findlVo();

					if (f != null) {
						String path = "";
						fvo.setGroup_id(gid);
						fvo.setTarget_id(tid);
						fvo.setAccount(f.getOwner());
						fvo.setOwner(AppConfig.account.get(tid + "_" + f.getOwner()));
						fvo.setPath(f.getPath());
						fvo.setFid(f.getId());
						
						//fvo.setHash_id((gid + tid + fvo.getPath()).hashCode() + "");
						fvo.setHash_id((tid + fvo.getPath()).hashCode() + "");
						

						if (AppConfig.account.get(tid + "_" + f.getOwner()) != null) {
							logger.debug("Find Path Owner :" + tid + f.getOwner() + "---> " + AppConfig.account.get(tid + "_" + f.getOwner()));
						}
						
						// KB
						if(f.getRems() != null) {
							String remedition = getRemediations(f.getRems());
							fvo.setRemediation_status(remedition);
						}

						try {
							this.sqlMap.openSession().insert("insert.setFind", fvo);
						} catch (SQLException e) {
							String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
							fvo.setPath(f.getPath().replaceAll(match, "?"));
							logger.error("Error setFind SQLException  Target_ID:" + tid);
							logger.error("Error setFind SQLException  Path :" + fvo.getPath());

							DbInsertSetFind(fvo);
						}

						try {
							setSummary(fvo.getHash_id(), "T", f.getSummary());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							logger.error("Error setSummary SQLException  Target_ID:" + tid);
							logger.error("Error setSummary SQLException " + e.getLocalizedMessage());

						}
						

						if (f.getSubs() != null) {
							try {
								RecursiveCall(f.getSubs(), fvo.getHash_id());
								// KB
								//RecursiveCall(f.getSubs(), fvo.getHash_id(), fvo.getHash_id());
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								logger.error("Error RecursiveCall SQLException  Target_ID:" + tid);
								logger.error("Error RecursiveCall SQLException  " + e.getLocalizedMessage());
							}
						}
					}
				}
			}

			// this.sqlMap.executeBatch();
			// this.sqlMap.commitTransaction();

		} catch (ParseException e1) {
			logger.error("ParseException 1" + e1.getLocalizedMessage());
		}  finally {
			/*
			 * try { this.sqlMap.endTransaction(); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}
	}
	
	private void DbInsertSetFind(findlVo f) {
		String path = f.getPath();
		
		try {
			this.sqlMap.openSession().insert("insert.setFind", f);
		} catch (SQLException e) {
			logger.error("Error setFind SQLException  Target_ID:" + tid);
			logger.error("Error setFind SQLException  Path :" + path);
			logger.error("Error setFind SQLException " + e.getLocalizedMessage());

		}
	}
	
	private String getRemediations(remediations remedi) {
		String remidation = remedi.getRemediation_status();
		
		return remidation;
	}

	private void RecursiveCall(List<subpaths> subs, String pid) throws SQLException {
		int i = 0;
		for (subpaths s : subs) {
			subpathVo fvo = new subpathVo();

			fvo.setGroup_id(gid);
			fvo.setTarget_id(tid);
			fvo.setParent_id(pid);
			fvo.setAccount(s.getOwner());
			fvo.setOwner(AppConfig.account.get(tid + "_" + s.getOwner()));

			String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
			fvo.setPath(s.getPath().replaceAll(match, " "));

			fvo.setInfo_id(s.getId());
			fvo.setNode_id((gid + tid + pid + fvo.getPath()).hashCode() + "");
			// this.sqlMap.insert("insert.setSubpath", fvo);
			
			
			// KB 
			if(s.getRems() != null) {
				String remedition = getRemediations(s.getRems());
				fvo.setRemediation_status(remedition);
				if(i == 0)
					this.sqlMap.openSession().update("update.setFind", fvo);
			}
			i++;
			this.sqlMap.openSession().insert("insert.setSubpath", fvo);

			setSummary(fvo.getNode_id(), "S", s.getSummary());
			
			if (s.getSubs() != null) {
				RecursiveCall(s.getSubs(), fvo.getNode_id());
			}
		}
	}
	// KB Bank remediation
	/*private void RecursiveCall(List<subpaths> subs, String pid, String hashID) throws SQLException {
		int i = 0;
		for (subpaths s : subs) {
			subpathVo fvo = new subpathVo();
			
			fvo.setGroup_id(gid);
			fvo.setTarget_id(tid);
			fvo.setParent_id(pid);
			fvo.setAccount(s.getOwner());
			fvo.setOwner(AppConfig.account.get(tid + "_" + s.getOwner()));
			
			String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
			fvo.setPath(s.getPath().replaceAll(match, " "));
			
			fvo.setInfo_id(s.getId());
			fvo.setNode_id((gid + tid + pid + fvo.getPath()).hashCode() + "");
			// this.sqlMap.insert("insert.setSubpath", fvo);
			
			
			// KB 
			if(s.getRems() != null) {
				subpathVo fvo2 = new subpathVo();
				String remedition = getRemediations(s.getRems());
				fvo2.setParent_id(hashID);
				fvo2.setRemediation_status(remedition);
				if(i == 0)
					this.sqlMap.openSession().update("update.setFind", fvo2);
			}
			i++;
			this.sqlMap.openSession().insert("insert.setSubpath", fvo);
			
			setSummary(fvo.getNode_id(), "S", s.getSummary());
			
			if (s.getSubs() != null) {
				RecursiveCall(s.getSubs(), fvo.getNode_id(), hashID);
			}
		}
	}*/

	private void setSummary(String nid, String dtype, List<summaryCo> lst) throws SQLException {
		
		if (lst != null) {
			for (summaryCo c : lst) {
				summaryVo vo = new summaryVo(gid, tid, nid, dtype, c);
				this.sqlMap.openSession().insert("insert.setSummary", vo);
			}
		}
	}

	private void getServerInfo() {

	}

}
