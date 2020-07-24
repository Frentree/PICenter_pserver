package com.skyun.recon.util.database.ibatis.vo;

import com.iopts.skyun.recon.vo.groupall.agentCo;
import com.skyun.app.util.config.AppConfig;

public class emailVo {
	private String sender;
	private String receiver;
	private String title_arg;
	private String contents;
	
	public  emailVo() {

	}
	
	public  emailVo(agentCo v) {
		sender= AppConfig.getProperty("config.email.senderid");

	}


	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTitle_arg() {
		return title_arg;
	}

	public void setTitle_arg(String title_arg) {
		this.title_arg = title_arg;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	

}
