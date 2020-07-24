package com.iopts.skyun.recon.vo.groupall;

import com.google.gson.annotations.SerializedName;

public class networkCo {
	@SerializedName("ip")
	private String ip;
	
	@SerializedName("device")
	private String device;
	
	@SerializedName("mac")
	private String mac;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	
		

}
