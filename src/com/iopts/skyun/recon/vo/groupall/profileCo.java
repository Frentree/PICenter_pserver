package com.iopts.skyun.recon.vo.groupall;

import com.google.gson.annotations.SerializedName;

//locations 을 포함한다.

public class profileCo {
	@SerializedName("id")
	private String id;
	
	@SerializedName("label")
	private String label;

	@SerializedName("version")
	private int version;
	
	@SerializedName("owner")
	private String owner;

	@SerializedName("modified")
	private String modified;

	@SerializedName("default")
	private String defaults;

	@SerializedName("disabled")
	private String disabled;

	@SerializedName("global")
	private String global;

	@SerializedName("sealed")
	private String sealed;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getDefaults() {
		return defaults;
	}

	public void setDefaults(String defaults) {
		this.defaults = defaults;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getGlobal() {
		return global;
	}

	public void setGlobal(String global) {
		this.global = global;
	}

	public String getSealed() {
		return sealed;
	}

	public void setSealed(String sealed) {
		this.sealed = sealed;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	

	

}
