package com.iopts.scheduler;

import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.google.gson.Gson;
import com.iopts.skyun.recon.vo.groupall.scheduleCo;
import com.iopts.skyun.recon.vo.groupall.schlocationCo;
import com.iopts.skyun.recon.vo.groupall.schtargetCo;
import com.skyun.app.util.config.AppConfig;
import com.skyun.app.util.config.IoptsCurl;
import com.skyun.recon.util.database.ibatis.tr.DBInsertTable;
import com.skyun.recon.util.database.ibatis.vo.schdelesVo;
import com.skyun.recon.util.database.ibatis.vo.schedule_locationVo;

public class ReconSchedulerJobs implements Runnable {
	private DBInsertTable tr = null;
	private static Logger logger = Logger.getLogger("server");

	public ReconSchedulerJobs() {
	}

	@Override
	public void run() {

		String curlurl = String.format("-k -X GET -u %s:%s 'https://%s:%s/beta/schedules?details=true&completed=true&cancelled=true&stopped=true&failed=true&deactivated=true'",
				AppConfig.getProperty("config.recon.user"), AppConfig.getProperty("config.recon.pawwsord"), AppConfig.getProperty("config.recon.ip"), AppConfig.getProperty("config.recon.port"));

		logger.info("ReconSchedulerJobs curlurl [" + curlurl + "]");

		String[] array = curlurl.split(" ");

		tr = new DBInsertTable();

		String json_string;
		json_string = new IoptsCurl().opt(array).exec(null);

		if (json_string == null || json_string.length() < 1) {
			logger.error("Data Null Check IP or ID: " + curlurl);

		} else {

			JSONArray temp1 = new JSONArray(json_string);

			for (int i = 0; i < temp1.length(); i++) {
				Gson gson = new Gson();
				scheduleCo g = gson.fromJson(temp1.get(i).toString(), scheduleCo.class);
				dbjobs(g);
			}
		}

	}

	private void dbjobs(scheduleCo g) {
		// Agent���� ���
		schdelesVo v = new schdelesVo(g);
		tr.setDBInsertTable("insert.setSchedule", v);
		
		// scanning 상태가 되면 pi_scan_schedule 테이블의 active_status 02로 설정된 값을 01로 변경
		if(v.getSchedule_status().equals("scanning")) {
			tr.setDBInsertTable("update.setSchedule", v);
		}

		// Ÿ�������� �����ϰ�
		if (g.getTargets() != null) {
			for (schtargetCo t : g.getTargets()) {
				// Ÿ�������� �����̼�
				if (t.getLocations() != null) {
					for (schlocationCo sloc : t.getLocations()) {
						schedule_locationVo slocvo = new schedule_locationVo(sloc, g.getId(), t.getId());
						tr.setDBInsertTable("insert.setSchLocation", slocvo);
					}
				}
			}
		}
	}
}
