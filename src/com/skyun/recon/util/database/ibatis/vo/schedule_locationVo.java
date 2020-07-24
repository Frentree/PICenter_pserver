package com.skyun.recon.util.database.ibatis.vo;

import com.iopts.skyun.recon.vo.groupall.schlocationCo;

public class schedule_locationVo {
	
	private String sch_id;
	private String target_id;
	private String location_id;
	private String status;
	private String name;
	private String started;
	private String updated;
	
	public schedule_locationVo() {
		
	}

	public schedule_locationVo(schlocationCo c,String sid,String tid) {
		sch_id=sid;
		target_id=tid;
		location_id=c. getId();
		status=c.getStatus();
		name=c.getName();
		started=c.getStarted();
		updated=c.getUpdated();
	}
	
	public String getSch_id() {
		return sch_id;
	}
	public void setSch_id(String sch_id) {
		this.sch_id = sch_id;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStarted() {
		return started;
	}
	public void setStarted(String started) {
		this.started = started;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}
	
}
