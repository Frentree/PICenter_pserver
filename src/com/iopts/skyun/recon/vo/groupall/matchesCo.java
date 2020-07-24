package com.iopts.skyun.recon.vo.groupall;

import com.google.gson.annotations.SerializedName;

public class matchesCo {
	@SerializedName("test")
	private long test;
	@SerializedName("prohibited")
	private long prohibited;
	@SerializedName("match")
	private long match;
	
	public long getTest() {
		return test;
	}
	public void setTest(long test) {
		this.test = test;
	}
	public long getProhibited() {
		return prohibited;
	}
	public void setProhibited(long prohibited) {
		this.prohibited = prohibited;
	}
	public long getMatch() {
		return match;
	}
	public void setMatch(long match) {
		this.match = match;
	}

	



}
