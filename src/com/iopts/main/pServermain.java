package com.iopts.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import com.iopts.scheduler.AgentCheckThread;
import com.iopts.scheduler.JobConsumerThread;
import com.iopts.scheduler.ReconProfileJob;
import com.iopts.scheduler.SchedulerThread;
import com.iopts.scheduler.queue.QueueStaticPool;
import com.skyun.app.util.config.AppConfig;
import com.skyun.recon.util.database.ibatis.vo.targetVo;

public class pServermain {
	private static Logger logger = Logger.getLogger("server");
	private static BlockingQueue<targetVo> queue = null;
	
	
	public static void main(String[] args) {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		AppConfig.setPID(getPID() + "");
		wrtiePID(AppConfig.getPID());
		
		logger.info(">> Process ID :" + AppConfig.getPID());
		logger.info(">> Home Dir :" + AppConfig.currentDir);
		logger.info(">> System Version  2019-05-14__________________ ");
		logger.info(">> System Version  2019-08-08 (Mod)__________________ ");
		logger.info(">> System Version  2019-09-18 for Recon 2.0 ");
		logger.info(">> System Version  2019-09-18 for Owner Find,Sujbpath match account info");
		logger.info(">> System Version  2019-09-18 Patch list");
		logger.info(">> 		1> After pi_target Table insert pi_account_info account seek and update pi_find,pi_subpath owner filed.");
		logger.info(">> 		2> Batch Job Email Source file fix .");
		logger.info(">> 		3> path (pi_find/pi_subpath) special char Convert insertable chart .");
		logger.info(">> 		4> when matchobject get limit=1000000 add (request from NHbank)");
		logger.info(">> 		5> setSummery limit option bug fix");
		
		queue = new QueueStaticPool().getJobQueue();
		
	
		for (int i = 0; i < AppConfig.getPropertyInt("config.runthread.count"); i++) {
			new Thread(new JobConsumerThread(queue)).start();
		}

		new Thread(new AgentCheckThread()).start();
		new Thread(new SchedulerThread()).start();
		
	}
	
	public static long getPID() {
		String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
		return Long.parseLong(processName.split("@")[0]);
	}
	
	public static void wrtiePID(String pid) {
		BufferedWriter out=null;
		 try {
		      ////////////////////////////////////////////////////////////////
		      out = new BufferedWriter(new FileWriter(AppConfig.currentDir+"/pid"));

		      out.write(pid); 
		      ////////////////////////////////////////////////////////////////
		    } catch (IOException e) {
		        System.err.println(e); // ������ �ִٸ� �޽��� ���
		        System.exit(1);
		    } finally {
		    	try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	}
}
