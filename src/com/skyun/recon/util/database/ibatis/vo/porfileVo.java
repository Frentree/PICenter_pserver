package com.skyun.recon.util.database.ibatis.vo;

import com.iopts.skyun.recon.vo.groupall.profileCo;

public class porfileVo {

	private String datatype_id;
	private String datatype_label;
	private int version;
	private String owner;
	private String modified;
	private String defaults;
	private String disabled;
	private String global;
	private String sealed;
	
	public porfileVo(profileCo t) {
		this.datatype_id = t.getId();
		this.datatype_label = t.getLabel();
		this.version=t.getVersion();
		this.owner=t.getOwner();
		this.modified=t.getModified();
		this.defaults=t.getDefaults();
		this.global=t.getGlobal();
		this.sealed=t.getSealed();
		this.disabled=t.getDisabled();
		
	}

	public String getDatatype_id() {
		return datatype_id;
	}

	public void setDatatype_id(String datatype_id) {
		this.datatype_id = datatype_id;
	}

	public String getDatatype_label() {
		return datatype_label;
	}

	public void setDatatype_label(String datatype_label) {
		this.datatype_label = datatype_label;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
	
	

}
