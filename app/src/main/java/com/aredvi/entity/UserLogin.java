package com.aredvi.entity;

import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table("userlogin")
public class UserLogin {
	
	@PrimaryKeyColumn(name = "id",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
	private UUID id =UUIDs.timeBased();
	
	@Column(value = "user_name")
	private String userName;
	
	@Column(value = "password")
	private String password;
	
	@Column(value = "auth_id")
	private String authId;
	
	@Column(value = "created_on")
	private Date createdOn;
	
	@Column(value = "updated_on")
	private Date updatedOn;
	
	@Column(value = "is_lock")
	private boolean isLock;
	
	@Column(value = "is_verified")
	private boolean isVerified;
	
	@Column(value = "auth_provider")
	private String authProvider;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
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
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public boolean isLock() {
		return isLock;
	}
	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getAuthProvider() {
		return authProvider;
	}
	public void setAuthProvider(String authProvider) {
		this.authProvider = authProvider;
	}
	
}
