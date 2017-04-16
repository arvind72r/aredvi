package com.aredvi.sqlentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authority", catalog = "aredvidb")
public class Authority implements Serializable{
	
	private static final long serialVersionUID = -1738383681764697399L;

	private int authId;

	private UserRole userRole = new UserRole();	
	
	private String auth;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authId", unique = true, nullable = false)
	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_xid")
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Column(name = "auth")
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}
	public Authority(){
		
	}

}
