package com.aredvi.dto;

import java.io.Serializable;

public class PhoneDTO implements Serializable {
	private static final long serialVersionUID = -7269735528517666688L;
	private int phoneId;
	private String phoneNumber;
	private int userid;

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

}
