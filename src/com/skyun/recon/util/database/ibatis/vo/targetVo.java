package com.skyun.recon.util.database.ibatis.vo;

import com.iopts.skyun.recon.vo.groupall.targetslCo;

public class targetVo {
	private String group_id;
	private String target_id;
	private String comments;
	private String search_status;
	private String search_time;
	private String name;
	private String platform;
	private long critical;
	private long error;
	private long notice;
	private long test;
	private long prohibited;
	private long matchcnt;
	private String regdate;

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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSearch_status() {
		return search_status;
	}

	public void setSearch_status(String search_status) {
		this.search_status = search_status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
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

	public void setValue(targetslCo t, String gid) {

		this.group_id = gid;
		this.target_id = t.getId();
		this.comments = t.getComments();
		this.search_status = t.getSearch_status();
		this.search_time = t.getSearch_time();
		this.name = t.getName();
		this.platform = t.getPlatform();
		this.critical = t.getErrors().getCritical();
		this.error = t.getErrors().getErro();
		this.notice = t.getErrors().getNotice();
		this.test = t.getMatches().getTest();
		this.prohibited = t.getMatches().getProhibited();
		this.matchcnt = t.getMatches().getMatch();
	}

}
