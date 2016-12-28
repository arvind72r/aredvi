package com.aredvi.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table("authority")
public class Authority implements Serializable{
	
	private static final long serialVersionUID = -1738383681764697399L;

	@PrimaryKeyColumn(name = "id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	
	@PrimaryKeyColumn(name = "role",ordinal = 1,type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
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

	public Authority(UUID id, String role, List<String> authorities) {
		this.id = id;
		this.role = role;
		this.authorities = authorities;
	}
	
	public Authority(String role, List<String> authorities) {
		this.id = UUIDs.timeBased();
		this.role = role;
		this.authorities = authorities;
	}

	public Authority(){
		
	}
}
