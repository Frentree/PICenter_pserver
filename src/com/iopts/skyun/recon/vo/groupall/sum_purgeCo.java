package com.iopts.skyun.recon.vo.groupall;

import com.google.gson.annotations.SerializedName;

public class sum_purgeCo {

	@SerializedName("match")
	private String match;

	public String getMatch() {
		if(match==null) return "0";
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}



}
