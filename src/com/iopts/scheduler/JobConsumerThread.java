package com.iopts.scheduler;

import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import com.skyun.recon.util.database.ibatis.tr.DBInsertTable;
import com.skyun.recon.util.database.ibatis.vo.targetVo;

public class JobConsumerThread implements Runnable {
	
	private static BlockingQueue<targetVo> queue = null;
	private static Logger logger = Logger.getLogger("server");

	public JobConsumerThread(BlockingQueue<targetVo> q) {
		this.queue = q;
	}


	@Override
	public void run() {

		while (!Thread.currentThread().isInterrupted()) {
			if (queue.size() != 0) {
				try {
					targetVo info = queue.take();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						logger.error("File check error __________________");
					}
					
					logger.info("Thread Working.............."+info.getTarget_id());
					
					new JobConsumerTask(info);
					
				} catch (InterruptedException e) {
					logger.error("File check error __________________"+e.getLocalizedMessage());
				}
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.error("File check error __________________"+e.getLocalizedMessage());
				}
			}
		}
		
	}

}
