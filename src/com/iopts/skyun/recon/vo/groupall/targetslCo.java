package com.iopts.skyun.recon.vo.groupall;

import java.util.List;

import com.google.gson.annotations.SerializedName;

//locations 을 포함한다.

public class targetslCo {
	@SerializedName("comments")
	private String comments;
	
	@SerializedName("search_status")
	private String search_status;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("locations")
	private List<locationsCo> locations;

	@SerializedName("id")
	private String id;
	
	@SerializedName("matches")
	private matchesCo matches;

	
	@SerializedName("errors")
	private errorsCo errors;


	@SerializedName("platform")
	private String platform;

	@SerializedName("search_time")
	private String search_time;

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

	public List<locationsCo> getLocations() {
		return locations;
	}

	public void setLocations(List<locationsCo> locations) {
		this.locations = locations;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public matchesCo getMatches() {
		return matches;
	}

	public void setMatches(matchesCo matches) {
		this.matches = matches;
	}

	public errorsCo getErrors() {
		return errors;
	}

	public void setErrors(errorsCo errors) {
		this.errors = errors;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getSearch_time() {
		return search_time;
	}

	public void setSearch_time(String search_time) {
		this.search_time = search_time;
	}

	

}
