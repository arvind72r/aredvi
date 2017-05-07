package com.aredvi.dto;

import java.io.Serializable;

public class AddressDTO implements Serializable {
	 static final long serialVersionUID = 2265618344750840030L;
	 int addId;
	 String address;
	 String lat;
	 String lng;
	 int userID;
	 String pinCode;
	
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
	public AddressDTO(int addId, String address, String lat, String lng, int userID, String pinCode) {
		super();
		this.addId = addId;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.userID = userID;
		this.pinCode = pinCode;
	}
	public AddressDTO(){
		
	}
	
}
