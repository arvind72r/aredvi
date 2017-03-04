package com.aredvi.entity;

import java.io.Serializable;
import java.util.UUID;

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
	
	@Column(value = "google_id")
	private String googleId;
	
	@Column(value = "place_id")
	private String placeId;
	
	@Column(value = "solar_id")
	private String solarId;

	@Column(value = "full_name")
	private String fullname;
	
	@Column(value = "profile")
	private String profile;
	
	@Column(value = "profile_delted")
	private boolean profileDelted;
	
	@Column(value = "varified")
	private boolean varified;
	
	@Column(value = "specialities")
	private String specialities;
	
	@Column(value = "lat")
	private String lat;
	
	@Column(value = "longs")
	private String longs;
	
	@Column(value = "address")
	private String address;
	
	@Column(value = "phone")
	private String phone;
	
	@Column(value = "type")
	private String type;
	
	@Column(value = "mobile")
	private String mobile;
	
	
	@Column(value = "city")
	private String city;

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

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongs() {
		return longs;
	}

	public void setLongs(String longs) {
		this.longs = longs;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
