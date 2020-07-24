package com.iopts.skyun.recon.vo.groupall;

import java.util.List;

import com.google.gson.annotations.SerializedName;

//locations 을 포함한다.

public class schtargetCo {
	@SerializedName("id")
	private String id;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("locations")
	private List<schlocationCo> locations;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<schlocationCo> getLocations() {
		return locations;
	}

	public void setLocations(List<schlocationCo> locations) {
		this.locations = locations;
	}

	
}
