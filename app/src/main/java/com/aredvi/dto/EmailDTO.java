package com.aredvi.dto;

import java.io.Serializable;

public class EmailDTO implements Serializable{
	
	 static final long serialVersionUID = 945544144007900153L;
	 int id;
	 String emilID;
	 String type;
	 int userID;
	
	
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
	public EmailDTO(int id, String emilID, String type, int userID) {
		super();
		this.id = id;
		this.emilID = emilID;
		this.type = type;
		this.userID = userID;
	}
	public EmailDTO(){
		
	}
	
}
