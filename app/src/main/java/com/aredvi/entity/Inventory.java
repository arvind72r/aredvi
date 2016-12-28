package com.aredvi.entity;

import java.io.Serializable;
import java.util.UUID;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;


@Table("inventory")
public class Inventory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2702723316973008802L;
	
	@PrimaryKeyColumn(name = "id",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	
	@Field("solar_id")
	@Column(value = "solar_id")
	private String solarId;

	@Field("full_name")
	@Column(value = "full_name")
	private String fullname;
	
	@Field("profile")
	@Column(value = "profile")
	private String profile;
	
	@Field("profile_delted")
	@Column(value = "profile_delted")
	private boolean profileDelted;
	
	@Field("varified")
	@Column(value = "varified")
	private boolean varified;
	
	@Field("specialities")
	@Column(value = "specialities")
	private String specialities;
	
	@Field("latlog")
	@Column(value = "latlog")
	private String latlog;
	
	@Field("address")
	@Column(value = "address")
	private String address;
	
	@Field("phone")
	@Column(value = "phone")
	private String phone;
	
	@Field("mobile")
	@Column(value = "mobile")
	private String mobile;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public boolean isProfileDelted() {
		return profileDelted;
	}

	public void setProfileDelted(boolean profileDelted) {
		this.profileDelted = profileDelted;
	}

	public boolean isVarified() {
		return varified;
	}

	public void setVarified(boolean varified) {
		this.varified = varified;
	}

	public String getSpecialities() {
		return specialities;
	}

	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

	public String getLatlog() {
		return latlog;
	}

	public void setLatlog(String latlog) {
		this.latlog = latlog;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSolarId() {
		return solarId;
	}

	public void setSolarId(String solarId) {
		this.solarId = solarId;
	}

}
