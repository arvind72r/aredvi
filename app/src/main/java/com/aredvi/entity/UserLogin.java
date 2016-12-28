package com.aredvi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table("userlogin")
public class UserLogin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4041888763376778084L;

	@PrimaryKeyColumn(name = "id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	
	@PrimaryKeyColumn(name = "user_name",ordinal = 1,type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
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
	
	@Column(value = "roles")
	private List<String> roles;
	
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
	
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public UserLogin(UUID id, String userName, String password, String authId, Date createdOn, Date updatedOn,
			boolean isLock, boolean isVerified, String authProvider, List<String> roles) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.authId = authId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.isLock = isLock;
		this.isVerified = isVerified;
		this.authProvider = authProvider;
		this.roles = roles;
	}
	
	public UserLogin(String userName, String password, String authId, Date createdOn, Date updatedOn, boolean isLock,
			boolean isVerified, String authProvider, List<String> roles) {
		this.id = UUIDs.timeBased();
		this.userName = userName;
		this.password = password;
		this.authId = authId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.isLock = isLock;
		this.isVerified = isVerified;
		this.authProvider = authProvider;
		this.roles = roles;
	}
	public UserLogin(){
		this.id = UUIDs.timeBased();
	}
}
