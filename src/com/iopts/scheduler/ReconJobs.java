package com.iopts.scheduler;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.http.ParseException;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.google.gson.Gson;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.iopts.scheduler.queue.QueueStaticPool;
import com.iopts.skyun.recon.vo.groupall.groupallCo;
import com.iopts.skyun.recon.vo.groupall.locationsCo;
import com.iopts.skyun.recon.vo.groupall.targetslCo;
import com.skyun.app.util.config.AppConfig;
import com.skyun.app.util.config.IoptsCurl;
import com.skyun.recon.util.database.ibatis.SqlMapInstance;
import com.skyun.recon.util.database.ibatis.tr.DBInsertTable;
import com.skyun.recon.util.database.ibatis.vo.exceptionVo;
import com.skyun.recon.util.database.ibatis.vo.groupallVo;
import com.skyun.recon.util.database.ibatis.vo.locationVo;
import com.skyun.recon.util.database.ibatis.vo.pi_account_info;
import com.skyun.recon.util.database.ibatis.vo.targetVo;

public class ReconJobs implements Runnable {
	private DBInsertTable tr = null;
	private static Logger logger = Logger.getLogger("server");
	private static BlockingQueue<targetVo> queue = null;
	private static SqlMapClient sqlMap = null;

	public ReconJobs() {
		this.sqlMap = SqlMapInstance.getSqlMapInstance();
		tr = new DBInsertTable();
		this.queue = new QueueStaticPool().getJobQueue();

		sethashException();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String curlurl = String.format("-k -X GET -u %s:%s https://%s:%s/beta/groups/all?limit=3000", AppConfig.getProperty("config.recon.user"), AppConfig.getProperty("config.recon.pawwsord"),
				AppConfig.getProperty("config.recon.ip"), AppConfig.getProperty("config.recon.port"));

		logger.info("curlurl [" + curlurl + "]");

		String[] array = curlurl.split(" ");
		// HttpResponse response = curl(curlurl);

		String json_string;
		try {
			// json_string = EntityUtils.toString(response.getEntity());

			json_string = new IoptsCurl().opt(array).exec(null);

			if (json_string == null || json_string.length() < 1) {
				logger.error("Data Null Check IP or ID: " + curlurl);
			} else {

				JSONArray temp1 = new JSONArray(json_string);

				for (int i = 0; i < temp1.length(); i++) {
					Gson gson = new Gson();
					groupallCo g = gson.fromJson(temp1.get(i).toString(), groupallCo.class);
					groupall(g);
				}
			}
		} catch (

		ParseException e1) {
			e1.printStackTrace();
		}

		// getgroupall();
		getOwnerlist();

	}

	private String getDate(String s) {

		Timestamp timestamp = new Timestamp(Long.parseLong(s) * 1000);
		Date date = new Date(timestamp.getTime());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
		return simpleDateFormat.format(timestamp);

	}

	private void groupall(groupallCo g) {
		groupallVo v = new groupallVo();
		v.setValue(g);

		tr.setDBInsertTable("insert.setGroupAll", v);

		//

		if (g == null || g.getTargets() == null) {
			logger.info("Groupall Data is null ____");
			return;
		}

		if (g.getTargets().size() > 0) {
			for (targetslCo tco : g.getTargets()) {
				targetVo tvo = new targetVo();
				tvo.setValue(tco, v.getGroup_id());

				// if (isThrerTarget(tvo) != true) {
				tr.setDBInsertTable("insert.setTarget", tvo);
				// }
			}
		}

		if (g.getTargets().size() > 0) {

			for (targetslCo tco : g.getTargets()) {
				targetVo tvo = new targetVo();
				tvo.setValue(tco, v.getGroup_id());

				if (tco.getLocations().size() > 0) {
					for (locationsCo lco : tco.getLocations()) {
						locationVo lvo = new locationVo();
						lvo.setValue(lco, v.getGroup_id(), tvo.getTarget_id());

						String key = v.getGroup_id() + tvo.getTarget_id() + lvo.getLocation_id();

						if (QueueStaticPool.getException_hash().get(key) == null) {
							tr.setDBInsertTable("insert.setLocation", lvo);
							try {
								this.queue.put(tvo);
							} catch (InterruptedException e) {
								logger.info("Target queue is full " + e.getLocalizedMessage());
							}
						} else {
							logger.info("Excpetion Define key :" + key);
						}
					}
				}
			}
		}
	}

	private void getgroupall() {
		List<groupallVo> vols = new ArrayList<groupallVo>();
		try {
			vols = tr.getSqlclient().openSession().queryForList("query.getgroupall");
		} catch (SQLException e) {
			logger.error("query.getLogConfig ind fatal error !!!!!!!! \n" + e.getMessage());
		}
	}

	private boolean isThrerTarget(targetVo v) {
		boolean ret = false;

		List<groupallVo> vols = new ArrayList<groupallVo>();

		try {
			vols = tr.getSqlclient().openSession().queryForList("query.isThereTarget", v);
			if (vols != null && vols.size() > 0) {
				ret = true;
			}
		} catch (SQLException e) {
			logger.error("query.isThrerTarget ind fatal error !!!!!!!! \n" + e.getMessage());
		}

		return ret;
	}

	private void sethashException() {
		List<exceptionVo> vols = new ArrayList<exceptionVo>();

		HashMap<String, String> ehash = new HashMap<>();

		try {
			vols = tr.getSqlclient().openSession().queryForList("query.getExceptionList");
		} catch (SQLException e) {
			logger.error("query.getExceptionList ind fatal error !!!!!!!! \n" + e.getMessage());
		}

		for (exceptionVo v : vols) {
			ehash.put(v.getKeyid(), v.getValue());
		}

		QueueStaticPool.setException_hash(ehash);
	}
	
	private static void getOwnerlist() {		
		List<pi_account_info> vols = new ArrayList<pi_account_info>();
		try {
			vols = sqlMap.openSession().queryForList("query.getpiAccountInfo");
		} catch (SQLException e) {
			System.out.println("query.getpiAccountInfo ind fatal error !!!!!!!! \n" + e.getMessage());
		}
		
		AppConfig.account.clear();
		
		if(vols.size() > 0) {
			for(pi_account_info v:vols) {
				AppConfig.account.put(v.getTarget_id()+"_"+v.getAccount(),v.getUser_id());	
			}
		}
		
		logger.info("account ______________ list:"+AppConfig.account.size());

	}

}
