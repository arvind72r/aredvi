package com.aredvi.sqlentity;

import java.io.Serializable;
import java.util.List;

public class Authority implements Serializable{
	
	private static final long serialVersionUID = -1738383681764697399L;

	
	private String role;
	
	private List<String> authorities;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public Authority(){
		
	}
}
