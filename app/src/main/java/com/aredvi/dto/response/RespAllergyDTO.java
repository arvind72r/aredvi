package com.aredvi.dto.response;

import java.io.Serializable;

public class RespAllergyDTO implements Serializable {
	private static final long serialVersionUID = -3796807256919106296L;
	private int id;
	private String allergyType;
	private boolean isPresent;
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
