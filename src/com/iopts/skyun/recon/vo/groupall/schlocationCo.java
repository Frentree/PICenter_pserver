package com.iopts.skyun.recon.vo.groupall;

import com.google.gson.annotations.SerializedName;

//locations 을 포함한다.
public class schlocationCo {
	@SerializedName("id")
	private String id;
	
	@SerializedName("status")
	private String status;


	@SerializedName("name")
	private String name;

	@SerializedName("started")
	private String started;

	@SerializedName("updated")
	private String updated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	
	
}
