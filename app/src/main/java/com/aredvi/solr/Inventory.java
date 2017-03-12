package com.aredvi.solr;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.geo.Point;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
@SolrDocument(solrCoreName = "aredvi")
public class Inventory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2702723316973008802L;
	
	@Field("googleid")
	private String googleId;
	
	@Field("placeid")
	private String placeId;
	
	@Id
	@Field("solarid")
	private String solarId;

	@Field("fname")
	private String fname;
	
	@Field("profile")
	private String profile;
	
	@Field("p_delted")
	private boolean profileDelted;
	
	@Field("varified")
	private boolean varified;
	
	@Field("specialities")
	private String specialities;
	
	@Indexed(name="locp", type="location")
	private String locp;
	
	@Field("address")
	private String address;
	
	@Field("phone")
	private String phone;
	
	@Field("type")
	private String type;
	
	@Field("mobile")
	private String mobile;
	
	@Field("city")
	private String city;

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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLocp() {
		return locp;
	}

	public void setLocp(String locp) {
		this.locp = locp;
	}
	

}
