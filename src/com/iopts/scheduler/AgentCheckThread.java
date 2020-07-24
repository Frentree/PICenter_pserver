package com.iopts.scheduler;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.google.gson.Gson;
import com.iopts.skyun.recon.vo.groupall.agentCo;
import com.iopts.skyun.recon.vo.groupall.networkCo;
import com.skyun.app.util.config.AppConfig;
import com.skyun.app.util.config.IoptsCurl;
import com.skyun.recon.util.database.ibatis.tr.DBInsertTable;
import com.skyun.recon.util.database.ibatis.vo.agentVo;
import com.skyun.recon.util.database.ibatis.vo.networkVo;

public class AgentCheckThread implements Runnable {
	private static Logger logger = Logger.getLogger("server");
	private DBInsertTable tr = null;

	public AgentCheckThread() {

	}

	@Override
	public void run() {
		String curlurl = String.format("-k -X GET -u %s:%s https://%s:%s/beta/agents?limit=3000", AppConfig.getProperty("config.recon.user"), AppConfig.getProperty("config.recon.pawwsord"),
				AppConfig.getProperty("config.recon.ip"), AppConfig.getProperty("config.recon.port"));

		logger.info("Agent Check curlurl [" + curlurl + "]");

		String[] array = curlurl.split(" ");

		int delay = AppConfig.getPropertyInt("config.agentstatus.delay");

		while (true) {

			this.tr = new DBInsertTable();
			logger.info("Agent Check__________________________:" + curlurl);

			String json_string = new IoptsCurl().opt(array).exec(null);

			if (json_string == null || json_string.length() < 1) {
				logger.error("Data Null Check IP or ID: " + curlurl);
			} else {

				JSONArray temp1 = new JSONArray(json_string);

				// Agent ���¸� DB�� �����Ѵ�.
				for (int i = 0; i < temp1.length(); i++) {
					Gson gson = new Gson();
					agentCo a = gson.fromJson(temp1.get(i).toString(), agentCo.class);
					dbJobs(a);
				}

				try {
					Thread.sleep((delay * 60 * 1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/*
				 * try { HttpResponse response = curl(curlurl);
				 * 
				 * String json_string;
				 * 
				 * json_string = EntityUtils.toString(response.getEntity()); JSONArray temp1 =
				 * new JSONArray(json_string);
				 * 
				 * for (int i = 0; i < temp1.length(); i++) { Gson gson = new Gson(); agentCo a
				 * = gson.fromJson(temp1.get(i).toString(), agentCo.class); dbJobs(a); }
				 * 
				 * Thread.sleep((delay * 60 * 1000)); //Thread.sleep((delay * 2 * 1000));
				 * 
				 * } catch (ParseException e1) {
				 * logger.info("ParseException  error______________________________________"); }
				 * catch (IOException e1) {
				 * logger.info("IOException  error______________________________________"); }
				 * catch (InterruptedException e) { logger.
				 * info("InterruptedException  error______________________________________"); }
				 */
			}

		}
	}

	private void dbJobs(agentCo a) {

		// Agent���� ���
		agentVo av = new agentVo(a);
		if (av.isAgent_connected() == true) {
			tr.setDBInsertTable("insert.setAgentStatus1", av);
		} else {
			tr.setDBInsertTable("insert.setAgentStatus2", av);
		}

		// ��Ʈ��ũ ���� ���
		if (a.getNets() != null) {
			for (networkCo nc : a.getNets()) {
				networkVo nv = new networkVo(nc, a.getId());
				tr.setDBInsertTable("insert.setNetInfo", nv);
			}
		}
	}

}
