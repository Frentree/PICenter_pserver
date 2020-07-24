package com.skyun.recon.util.database.ibatis.vo;

import com.iopts.skyun.recon.vo.groupall.agentCo;

public class agentVo {
	private String agent_id;
	private String agent_name;
	private String agent_type;
	private String agent_version;
	private String agent_platform;
	private String agent_platform_compatibility;
	private boolean agent_verified;
	private boolean agent_connected;
	private boolean agent_proxy;
	private String agent_user;
	private String agent_cpu;
	private String agent_cores;
	private String agent_boot;
	private String agent_ram;
	private String agent_started;
	private String agent_connected_ip;
	
	public  agentVo() {

	}

	public  agentVo(agentCo ins) {
		agent_id=ins.getId();
		agent_name=ins.getName();
		agent_type=ins.getType();
		agent_version=ins.getVersion();
		agent_platform=ins.getPlatform();
		agent_platform_compatibility=ins.getPlatform_compatibility();
		agent_verified=Boolean.parseBoolean(ins.getVerified());
		agent_connected=Boolean.parseBoolean(ins.getConnected());
		agent_proxy=Boolean.parseBoolean(ins.getProxy());
		agent_user=ins.getUser();
		agent_cpu=ins.getCpu();
		agent_cores=ins.getCores();
		agent_boot=ins.getBoot();
		agent_ram=ins.getRam();
		agent_started=ins.getStarted();
		agent_connected_ip=ins.getConnected_ip();

	}


	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

	public String getAgent_type() {
		return agent_type;
	}

	public void setAgent_type(String agent_type) {
		this.agent_type = agent_type;
	}

	public String getAgent_version() {
		return agent_version;
	}

	public void setAgent_version(String agent_version) {
		this.agent_version = agent_version;
	}

	public String getAgent_platform() {
		return agent_platform;
	}

	public void setAgent_platform(String agent_platform) {
		this.agent_platform = agent_platform;
	}

	public String getAgent_platform_compatibility() {
		return agent_platform_compatibility;
	}

	public void setAgent_platform_compatibility(String agent_platform_compatibility) {
		this.agent_platform_compatibility = agent_platform_compatibility;
	}

	public boolean isAgent_verified() {
		return agent_verified;
	}

	public void setAgent_verified(boolean agent_verified) {
		this.agent_verified = agent_verified;
	}

	public boolean isAgent_connected() {
		return agent_connected;
	}

	public void setAgent_connected(boolean agent_connected) {
		this.agent_connected = agent_connected;
	}

	public boolean isAgent_proxy() {
		return agent_proxy;
	}

	public void setAgent_proxy(boolean agent_proxy) {
		this.agent_proxy = agent_proxy;
	}

	public String getAgent_user() {
		return agent_user;
	}

	public void setAgent_user(String agent_user) {
		this.agent_user = agent_user;
	}

	public String getAgent_cpu() {
		return agent_cpu;
	}

	public void setAgent_cpu(String agent_cpu) {
		this.agent_cpu = agent_cpu;
	}

	public String getAgent_cores() {
		return agent_cores;
	}

	public void setAgent_cores(String agent_cores) {
		this.agent_cores = agent_cores;
	}

	public String getAgent_boot() {
		return agent_boot;
	}

	public void setAgent_boot(String agent_boot) {
		this.agent_boot = agent_boot;
	}

	public String getAgent_ram() {
		return agent_ram;
	}

	public void setAgent_ram(String agent_ram) {
		this.agent_ram = agent_ram;
	}


	public String getAgent_started() {
		return agent_started;
	}

	public void setAgent_started(String agent_started) {
		this.agent_started = agent_started;
	}

	public String getAgent_connected_ip() {
		return agent_connected_ip;
	}

	public void setAgent_connected_ip(String agent_connected_ip) {
		this.agent_connected_ip = agent_connected_ip;
	}

	
	

}
