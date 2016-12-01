package com.aredvi.dto.request;

import java.util.UUID;

public class ReqLoginDTO {
	private UUID userLoginId;
	
	private String userName;
	
	private String password;
	
	private String confirmPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public UUID getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(UUID userLoginId) {
		this.userLoginId = userLoginId;
	}
	
}
