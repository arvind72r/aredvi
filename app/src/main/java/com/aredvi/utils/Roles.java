package com.aredvi.utils;

public enum Roles {
	
	ROLE_USER("ROLE_USER"),
	ROLE_DOC("ROLE_DOC"),
	ROLE_CHEM("ROLE_CHEM"),
	ROLE_ADMIN("ROLE_ADMIN");
	
	private String role;
	
	private Roles(String pRole){
		role=pRole;
	}
	
	public String getRole() {
		return role;
	}
}
