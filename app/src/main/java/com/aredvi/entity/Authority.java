package com.aredvi.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table("authority")
public class Authority {
	
	@PrimaryKeyColumn(name = "id",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
	private UUID id = UUIDs.timeBased();
	
	@Column(value = "role")
	private String role;
	
	@Column(value = "authorities")
	private List<String> authorities;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
