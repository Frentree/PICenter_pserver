package com.iopts.skyun.recon.vo.groupall;

import com.google.gson.annotations.SerializedName;

public class errorsCo {
	@SerializedName("critical")
	private int critical;
	
	@SerializedName("erro")
	private int erro;
	
	@SerializedName("notice")
	private int notice;
	
	public int getCritical() {
		return critical;
	}
	public void setCritical(int critical) {
		this.critical = critical;
	}
	public int getErro() {
		return erro;
	}
	public void setErro(int erro) {
		this.erro = erro;
	}
	public int getNotice() {
		return notice;
	}
	public void setNotice(int notice) {
		this.notice = notice;
	}


	

}
