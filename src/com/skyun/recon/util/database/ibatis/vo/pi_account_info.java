package com.skyun.recon.util.database.ibatis.vo;

public class pi_account_info {
	private String target_id;
	private String svr_host;
	private String account;
	private String user_id;
	
	public  pi_account_info() {

	}
	public String getSvr_host() {
		return svr_host;
	}

	public void setSvr_host(String svr_host) {
		this.svr_host = svr_host;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}

	
	

}
