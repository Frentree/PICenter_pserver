package com.iopts.skyun.recon.vo.groupall;

import com.google.gson.annotations.SerializedName;

public class locationsCo {
	@SerializedName("path")
	private String path;
	
	@SerializedName("protocol")
	private String protocol;
	
	@SerializedName("search_status")
	private String search_status;
	
	@SerializedName("description")
	private String description;
	
	@SerializedName("id")
	private String id;
	
	@SerializedName("proxy_id")
	private String proxy_id;

	@SerializedName("matches")
	private matchesCo matche;
	@SerializedName("errors")
	private errorsCo error;
	
	@SerializedName("search_time")
	private String search_time;
	@SerializedName("credential_id")
	private String credential_id;
	
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProxy_id() {
		return proxy_id;
	}
	public void setProxy_id(String proxy_id) {
		this.proxy_id = proxy_id;
	}
	public matchesCo getMatche() {
		return matche;
	}
	public void setMatche(matchesCo matche) {
		this.matche = matche;
	}
	public errorsCo getError() {
		return error;
	}
	public void setError(errorsCo error) {
		this.error = error;
	}
	public String getSearch_time() {
		return search_time;
	}
	public void setSearch_time(String search_time) {
		this.search_time = search_time;
	}
	public String getCredential_id() {
		return credential_id;
	}
	public void setCredential_id(String credential_id) {
		this.credential_id = credential_id;
	}

	

}
