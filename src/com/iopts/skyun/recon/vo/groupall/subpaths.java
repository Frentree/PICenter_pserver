package com.iopts.skyun.recon.vo.groupall;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class subpaths {
	@SerializedName("owner")
	private String owner;
	
	@SerializedName("path")
	private String path;
	
	@SerializedName("id")
	private String id;
	
	@SerializedName("subpaths")
	private List<subpaths> subs;

	@SerializedName("summary")
	private List<summaryCo> summary;
	
	@SerializedName("last_remediation_event")
	private remediations rems;
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<subpaths> getSubs() {
		return subs;
	}

	public void setSubs(List<subpaths> subs) {
		this.subs = subs;
	}

	public List<summaryCo> getSummary() {
		return summary;
	}

	public void setSummary(List<summaryCo> summary) {
		this.summary = summary;
	}

	public remediations getRems() {
		return rems;
	}

	public void setRems(remediations rems) {
		this.rems = rems;
	}
	
}
