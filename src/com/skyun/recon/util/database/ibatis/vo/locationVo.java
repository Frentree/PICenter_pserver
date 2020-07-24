package com.skyun.recon.util.database.ibatis.vo;

import com.iopts.skyun.recon.vo.groupall.locationsCo;
import com.skyun.app.util.config.AppConfig;

public class locationVo {
	private String 	group_id;
	private String 	target_id;
	private String 	location_id;
	private String 	proxy_id;
	private String 	credential_id;
	private String 	search_time;
	private String 	path;
	private String 	protocol;
	private String 	search_status;
	private String 	description;
	private long 	test;
	private long 	prohibited;
	private long 	matchcnt;	
	private long 	critical;
	private long 	error;
	private long 	notice;
	private String 	regdate;

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getProxy_id() {
		return proxy_id;
	}

	public void setProxy_id(String proxy_id) {
		this.proxy_id = proxy_id;
	}

	public String getCredential_id() {
		return credential_id;
	}

	public void setCredential_id(String credential_id) {
		this.credential_id = credential_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getSearch_status() {
		return search_status;
	}

	public void setSearch_status(String search_status) {
		this.search_status = search_status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public long getMatchcnt() {
		return matchcnt;
	}

	public void setMatchcnt(long matchcnt) {
		this.matchcnt = matchcnt;
	}

	public long getCritical() {
		return critical;
	}

	public void setCritical(long critical) {
		this.critical = critical;
	}

	public long getError() {
		return error;
	}

	public void setError(long error) {
		this.error = error;
	}

	public long getNotice() {
		return notice;
	}

	public void setNotice(long notice) {
		this.notice = notice;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getSearch_time() {
		return search_time;
	}

	public void setSearch_time(String search_time) {
		this.search_time = search_time;
	}

	public void setValue(locationsCo l,String gid,String tid) {
		
		this.group_id=gid;
		this.target_id=tid;
		this.location_id=l.getId();
		this.proxy_id=l.getProxy_id();
		this.credential_id=l.getCredential_id();
		this.search_time=l.getSearch_time();
		this.path=l.getPath();
		this.protocol=l.getProtocol();
		this.search_status=l.getSearch_status();
		this.description=l.getDescription();
		this.test=l.getMatche().getTest();
		this.prohibited=l.getMatche().getProhibited();
		this.matchcnt=l.getMatche().getMatch();	
		this.critical=l.getError().getCritical();
		this.error=l.getError().getErro();
		this.notice=l.getError().getNotice();		
		
	}
	
	
}
