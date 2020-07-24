package com.skyun.recon.util.database.ibatis.vo;

import com.iopts.skyun.recon.vo.groupall.groupallCo;
import com.skyun.app.util.config.AppConfig;

public class groupallVo {
	private String group_id;
	private String comments;
	private String search_status;
	private String name;
	private String search_time;
	private long matches;
	private long prohibited;
	private long test;
	private long critical;
	private long notice;
	private long error;
	private String regdate;

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
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

	public String getSearch_time() {
		return search_time;
	}

	public void setSearch_time(String search_time) {
		this.search_time = search_time;
	}

	public void setNotice(int notice) {
		this.notice = notice;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public long getMatches() {
		return matches;
	}

	public void setMatches(long matches) {
		this.matches = matches;
	}

	public long getProhibited() {
		return prohibited;
	}

	public void setProhibited(long prohibited) {
		this.prohibited = prohibited;
	}

	public long getTest() {
		return test;
	}

	public void setTest(long test) {
		this.test = test;
	}

	public long getCritical() {
		return critical;
	}

	public void setCritical(long critical) {
		this.critical = critical;
	}

	public long getNotice() {
		return notice;
	}

	public void setNotice(long notice) {
		this.notice = notice;
	}

	public long getError() {
		return error;
	}

	public void setError(long error) {
		this.error = error;
	}

	public void setValue(groupallCo c) {
		this.group_id = c.getId();
		this.comments = c.getComments();
		this.search_status = c.getSearch_status();
		this.name = c.getName();
		this.search_time = c.getSearch_time();
		this.matches = c.getMatches().getMatch();
		this.prohibited = c.getMatches().getProhibited();
		this.test = c.getMatches().getTest();
		this.critical = c.getErrors().getCritical();
		this.notice = c.getErrors().getNotice();
		this.error = c.getErrors().getErro();

	}

}
