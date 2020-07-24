package com.iopts.skyun.recon.vo.groupall;

import com.google.gson.annotations.SerializedName;

public class summaryCo {
	@SerializedName("data_type")
	private String data_type;

	@SerializedName("matches")
	private sum_matchCo match;

	@SerializedName("remediation_status")
	private String remediation_status;

	
	@SerializedName("purge")
	private sum_purgeCo purge;


	public String getData_type() {
		return data_type;
	}


	public void setData_type(String data_type) {
		this.data_type = data_type;
	}


	public sum_matchCo getMatch() {
		return match;
	}


	public void setMatch(sum_matchCo match) {
		this.match = match;
	}


	public String getRemediation_status() {
		return remediation_status;
	}


	public void setRemediation_status(String remediation_status) {
		this.remediation_status = remediation_status;
	}


	public sum_purgeCo getPurge() {
		return purge;
	}


	public void setPurge(sum_purgeCo purge) {
		this.purge = purge;
	}

	
	
	
}
