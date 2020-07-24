package com.iopts.scheduler;

import org.apache.log4j.Logger;

public class SchedulerThread implements Runnable{
	private static Logger logger = Logger.getLogger("server");
	private static CronTriggerSchedulerInstance instance=null;
	
	
	public SchedulerThread() {
		this.instance=CronTriggerSchedulerInstance.getSchdInstance();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			this.instance.SchedulerRun();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
