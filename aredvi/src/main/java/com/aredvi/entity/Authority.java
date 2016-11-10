package com.aredvi.entity;

import java.util.List;

import org.springframework.data.cassandra.mapping.Table;

@Table
public class Authority {
	private String authId;
	
	private String role;
	
	private List<String> authorities;

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

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
	
}
