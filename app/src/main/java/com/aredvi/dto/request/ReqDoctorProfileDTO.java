package com.aredvi.dto.request;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.cassandra.mapping.Column;

public class ReqDoctorProfileDTO {
	private UUID id;
	
	private UUID userId;
	
	private UUID userLoginId;
	
	private String fname;
	
	private String lname;
	
	private String mobileNumber;
	
	private String email;
	
	private Date dob;
	
	private String gender;
	
	private String mpLicAuthority;
	
	private String mpLicNo;
	
	private Date mpLicDateOfIssue;
	
	private boolean varified;
	
	private List<String> specialities;
	
	private String profile;
	
	private String calendar;
	
	private String photo;
	
	private Map<String, String> documents;
	
	private List<String> phoneNumber;
	
	private boolean profileDelted;
	
	private String lat;
	
	private String longs;
	
	private String city;
	
	private String address;
	
	private String googleId;
	
	private String placeId;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMpLicAuthority() {
		return mpLicAuthority;
	}

	public void setMpLicAuthority(String mpLicAuthority) {
		this.mpLicAuthority = mpLicAuthority;
	}

	public String getMpLicNo() {
		return mpLicNo;
	}

	public void setMpLicNo(String mpLicNo) {
		this.mpLicNo = mpLicNo;
	}

	public Date getMpLicDateOfIssue() {
		return mpLicDateOfIssue;
	}

	public void setMpLicDateOfIssue(Date mpLicDateOfIssue) {
		this.mpLicDateOfIssue = mpLicDateOfIssue;
	}

	public boolean isVarified() {
		return varified;
	}

	public void setVarified(boolean varified) {
		this.varified = varified;
	}

	public List<String> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<String> specialities) {
		this.specialities = specialities;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Map<String, String> getDocuments() {
		return documents;
	}

	public void setDocuments(Map<String, String> documents) {
		this.documents = documents;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isProfileDelted() {
		return profileDelted;
	}

	public void setProfileDelted(boolean profileDelted) {
		this.profileDelted = profileDelted;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UUID getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(UUID userLoginId) {
		this.userLoginId = userLoginId;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
}
