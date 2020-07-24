package com.iopts.scheduler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.iopts.shell.ShellExecute;
import com.iopts.shell.ShellExecuteVo;
import com.skyun.app.util.config.AppConfig;
import com.skyun.recon.util.database.ibatis.SqlMapInstance;
import com.skyun.recon.util.database.ibatis.vo.pi_account_info;

public class DayTaskJobThread implements Job {
	private static Logger logger = Logger.getLogger("server");
	private static SqlMapClient sqlMap = null;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		this.sqlMap = SqlMapInstance.getSqlMapInstance();
		
		logger.info(arg0.getJobDetail().getKey().getName().toString());
		
		if(arg0.getJobDetail().getKey().getName().toString().contains("reconjobs")) {
			logger.info("reconjobs _________________________");
			new Thread(new ReconJobs()).start();	
		}else if(arg0.getJobDetail().getKey().getName().toString().contains("schedulerjob_day")) {
			logger.info("schedulerjob_day update _________________________");
			new Thread(new ReconSchedulerJobs()).start();	
		}else if(arg0.getJobDetail().getKey().getName().toString().contains("profilejobsjob_day")) {
			logger.info("profilejobs_day update_________________________");
			new Thread(new ReconProfileJob()).start();	
		}else if(arg0.getJobDetail().getKey().getName().toString().contains("shellbatch")) {
			logger.info("shellbatch call _________________________");
			
			ShellExecuteVo obj=new  ShellExecuteVo();
			obj.setAccount("root");
			obj.setShellid(UUID.randomUUID().toString());
			obj.setShell(new StringBuffer(AppConfig.getProperty("config.recon.schedule.runshell")));
			obj.setTimeout(30*1000);
			
			ShellExecuteVo retobj = (ShellExecuteVo) new ShellExecute((ShellExecuteVo) obj).getObject();
			
			logger.info("Executed exitcvoe:"+retobj.getExitcode());
		}
		
	}
	

}
