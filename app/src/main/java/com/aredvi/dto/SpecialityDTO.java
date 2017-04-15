package com.aredvi.dto;

import java.io.Serializable;

public class SpecialityDTO implements Serializable{
	
	private static final long serialVersionUID = -8126219189702443086L;
	private int specId;
	private String special;
	private int doctorxid;
	
	public int getSpecId() {
		return specId;
	}
	public void setSpecId(int specId) {
		this.specId = specId;
	}
	
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public int getDoctorxid() {
		return doctorxid;
	}
	public void setDoctorxid(int doctorxid) {
		this.doctorxid = doctorxid;
	}
	
}
