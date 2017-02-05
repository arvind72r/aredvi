package com.aredvi.dto.response;

public class RespMapDTO {
	private String ardeviRef;
	private String googleRef;
	private String lat;
	private String lng;
	private String name;
	private String type;
	private boolean registered;
	public String getArdeviRef() {
		return ardeviRef;
	}
	public void setArdeviRef(String ardeviRef) {
		this.ardeviRef = ardeviRef;
	}
	public String getGoogleRef() {
		return googleRef;
	}
	public void setGoogleRef(String googleRef) {
		this.googleRef = googleRef;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	
}
