package com.iopts.skyun.recon.vo.groupall;

import com.google.gson.annotations.SerializedName;

public class remediations {
	@SerializedName("job_id")
	private String job_id;

	@SerializedName("sign_off")
	private String sign_off;

	@SerializedName("remediation_status")
	private String remediation_status;

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getSign_off() {
		return sign_off;
	}

	public void setSign_off(String sign_off) {
		this.sign_off = sign_off;
	}

	public String getRemediation_status() {
		return remediation_status;
	}

	public void setRemediation_status(String remediation_status) {
		this.remediation_status = remediation_status;
	}

}
