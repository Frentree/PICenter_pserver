package com.iopts.scheduler;

import static com.iopts.skyun.curl.Curl.curl;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.google.gson.Gson;
import com.iopts.skyun.recon.vo.groupall.profileCo;
import com.skyun.app.util.config.AppConfig;
import com.skyun.app.util.config.IoptsCurl;
import com.skyun.recon.util.database.ibatis.tr.DBInsertTable;
import com.skyun.recon.util.database.ibatis.vo.porfileVo;

//2019년 3월 22일 추가 
//pi_datatypes테이블에 입력함
public class ReconProfileJob implements Runnable {
	private DBInsertTable tr = null;
	private static Logger logger = Logger.getLogger("server");

	public ReconProfileJob() {
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String curlurl = String.format("-k -X GET -u %s:%s https://%s:%s/beta/datatypes/profiles?details=true", AppConfig.getProperty("config.recon.user"),
				AppConfig.getProperty("config.recon.pawwsord"), AppConfig.getProperty("config.recon.ip"), AppConfig.getProperty("config.recon.port"));

		logger.info("curlurl [" + curlurl + "]");

		// HttpResponse response = curl(curlurl);

		String[] array = curlurl.split(" ");

		tr = new DBInsertTable();

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
					profileCo g = gson.fromJson(temp1.get(i).toString(), profileCo.class);
					dbjobs(g);
				}
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

	private void dbjobs(profileCo g) {
		// Agent상태 등록

		porfileVo v = new porfileVo(g);

		if (!(g.getOwner().trim().equals("0"))) {
			tr.setDBInsertTable("insert.setProfile", v);
		}
	}
}
