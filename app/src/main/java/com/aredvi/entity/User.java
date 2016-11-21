package com.aredvi.entity;

import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table("user")
public class User {
	
	@PrimaryKeyColumn(name = "id",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
	private UUID id = UUIDs.timeBased();
	
	@Column(value = "name")
	private String name;
	
	@Column(value = "type")
	private String type;


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
