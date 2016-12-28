package com.aredvi.entity;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table("userrole")
public class UserRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1666409007503892898L;

	@PrimaryKeyColumn(name = "id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	
	@PrimaryKeyColumn(name = "user_id",ordinal = 1,type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	private UUID userId;
	
	@Column(value = "role")
	private String role;
	
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
	
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public UserRole(UUID id, UUID userId, String role) {
		this.id = id;
		this.userId = userId;
		this.role = role;
	}
	
	public UserRole(UUID userId, String role) {
		this.id  = UUIDs.timeBased();
		this.userId = userId;
		this.role = role;
	}
	public UserRole(){
		
	}
	
}
