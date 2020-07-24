package com.skyun.recon.util.database.ibatis.vo;

import com.iopts.skyun.recon.vo.groupall.summaryCo;

public class summaryVo {
	private String group_id = "";
	private String target_id = "";
	private String object_id = "";
	private String data_type = "";
	private String match_count = "";
	private String remediation_status = "";
	private String purge_count = "";

	public summaryVo() {

	}

	public summaryVo(String gid,String tid,String oid,String dt,summaryCo s) {
		group_id = gid;
		target_id = tid;
		object_id = oid;
		data_type=s.getData_type();
		match_count = s.getMatch().getMatch();
		remediation_status =s.getRemediation_status();
		
		if(s.getPurge()!=null) {
			purge_count = s.getPurge().getMatch();
		}else {
			purge_count ="0";
		}
	}

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

	public String getObject_id() {
		return object_id;
	}

	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public String getMatch_count() {
		return match_count;
	}

	public void setMatch_count(String match_count) {
		this.match_count = match_count;
	}

	public String getRemediation_status() {
		return remediation_status;
	}

	public void setRemediation_status(String remediation_status) {
		this.remediation_status = remediation_status;
	}

	public String getPurge_count() {
		return purge_count;
	}

	public void setPurge_count(String purge_count) {
		this.purge_count = purge_count;
	}

	
	
}
