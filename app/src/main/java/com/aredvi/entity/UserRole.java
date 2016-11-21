package com.aredvi.entity;

import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table("userrole")
public class UserRole {
	
	@PrimaryKeyColumn(name = "id",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
	private UUID id = UUIDs.timeBased();
	
	@Column(value = "user_id")
	private String userId;
	
	@Column(value = "role")
	private String role;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
}
