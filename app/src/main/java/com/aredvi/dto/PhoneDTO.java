package com.aredvi.dto;

import java.io.Serializable;


public class PhoneDTO implements Serializable {
	 static final long serialVersionUID = -7269735528517666688L;
	 int phoneId;
	 String phoneNumber;
	 int userid;

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public PhoneDTO(int phoneId, String phoneNumber, int userid) {
		super();
		this.phoneId = phoneId;
		this.phoneNumber = phoneNumber;
		this.userid = userid;
	}
	public PhoneDTO(){
		
	}
	
}
