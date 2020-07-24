package com.iopts.skyun.recon.vo.groupall;

import java.util.List;

import com.google.gson.annotations.SerializedName;

//locations 을 포함한다.

public class scheduleCo {
	@SerializedName("id")
	private String id;
	
	@SerializedName("label")
	private String label;
	
	@SerializedName("status")
	private String status;

	@SerializedName("repeat_days")
	private String repeat_days;
	
	@SerializedName("repeat_months")
	private String repeat_months;
	
	
	@SerializedName("profiles")
	private  List<String>  profiles;
	
	@SerializedName("next_scan")
	private String next_scan;
	
	
	@SerializedName("targets")
	private List<schtargetCo>  targets;
	
	@SerializedName("cpu")
	private String cpu;

	@SerializedName("capture")
	private String capture;

	@SerializedName("trace")
	private String trace;


	@SerializedName("pause")
	private List<pauseCo>  pause;


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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getRepeat_days() {
		return repeat_days;
	}


	public void setRepeat_days(String repeat_days) {
		this.repeat_days = repeat_days;
	}


	public String getRepeat_months() {
		return repeat_months;
	}


	public void setRepeat_months(String repeat_months) {
		this.repeat_months = repeat_months;
	}


	public List<String> getProfiles() {
		return profiles;
	}


	public void setProfiles(List<String> profiles) {
		this.profiles = profiles;
	}


	public String getNext_scan() {
		return next_scan;
	}


	public void setNext_scan(String next_scan) {
		this.next_scan = next_scan;
	}


	public List<schtargetCo> getTargets() {
		return targets;
	}


	public void setTargets(List<schtargetCo> targets) {
		this.targets = targets;
	}


	public String getCpu() {
		return cpu;
	}


	public void setCpu(String cpu) {
		this.cpu = cpu;
	}


	public String getCapture() {
		return capture;
	}


	public void setCapture(String capture) {
		this.capture = capture;
	}


	public String getTrace() {
		return trace;
	}


	public void setTrace(String trace) {
		this.trace = trace;
	}


	public List<pauseCo> getPause() {
		return pause;
	}


	public void setPause(List<pauseCo> pause) {
		this.pause = pause;
	}

	
	
}
