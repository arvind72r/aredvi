package com.aredvi.dto.response;

import java.io.Serializable;

public class RespAddressDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2265618344750840030L;
	private int addId;
	private String address;
	private String lat;
	private String lng;
	private String pinCode;
	private int userID;
	
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
