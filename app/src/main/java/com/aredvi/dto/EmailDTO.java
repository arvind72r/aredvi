package com.aredvi.dto;

import java.io.Serializable;

public class EmailDTO implements Serializable{
	
	private static final long serialVersionUID = 945544144007900153L;
	private int id;
	private String emilID;
	private String type;
	private int userID;
	
	
	public String getEmilID() {
		return emilID;
	}
	public void setEmilID(String emilID) {
		this.emilID = emilID;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
