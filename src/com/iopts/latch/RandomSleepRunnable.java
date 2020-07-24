package com.iopts.latch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.skyun.recon.util.database.ibatis.SqlMapInstance;
import com.skyun.recon.util.database.ibatis.vo.groupallVo;

public class RandomSleepRunnable implements Runnable {
	
	private  CountDownLatch lacth;
	
	private static SqlMapClient sqlMap = SqlMapInstance.getSqlMapInstance();
	private int id = 0;
	private static Logger logger = Logger.getLogger("server");
	

	public RandomSleepRunnable(int id,CountDownLatch l) {
		this.id = id;
		this.lacth=l;
		
	}

	@Override
	public void run() {
		try {
			getlist();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
            if (this.lacth == null)
                return;
           this.lacth.countDown();
           
           logger.info("Thread end "+this.id);
		}
					
	}
	
	private void getlist() {
		List<groupallVo> vols = new ArrayList<groupallVo>();
		try {
			vols = sqlMap.openSession().queryForList("query.getgroupall");
		} catch (SQLException e) {
			System.out.println("query.getLogConfig ind fatal error !!!!!!!! \n" + e.getMessage());
		}
		
	}

}
