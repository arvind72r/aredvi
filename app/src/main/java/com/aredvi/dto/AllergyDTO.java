package com.aredvi.dto;

import java.io.Serializable;

public class AllergyDTO implements Serializable {
	 static final long serialVersionUID = -3796807256919106296L;
	 int id;
	 String allergyType;
	 boolean isPresent;
	 int userxid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAllergyType() {
		return allergyType;
	}

	public void setAllergyType(String allergyType) {
		this.allergyType = allergyType;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	public int getUserxid() {
		return userxid;
	}

	public void setUserxid(int userxid) {
		this.userxid = userxid;
	}

	public AllergyDTO(int id, String allergyType, boolean isPresent, int userxid) {
		super();
		this.id = id;
		this.allergyType = allergyType;
		this.isPresent = isPresent;
		this.userxid = userxid;
	}

	public AllergyDTO(){
		
	}
}
