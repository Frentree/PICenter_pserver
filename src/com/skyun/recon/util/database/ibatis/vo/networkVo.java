package com.skyun.recon.util.database.ibatis.vo;

import com.iopts.skyun.recon.vo.groupall.networkCo;

public class networkVo {
	private String agent_id;
	private String device;
	private String ip;
	private String mac;
	private String regdate;
	
	public networkVo() {
		
	}
	public networkVo(networkCo n,String aid) {
		agent_id=aid;
		device=n.getDevice();
		ip=n.getIp();
		mac=n.getMac();
	}
	
	public String getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	

}
