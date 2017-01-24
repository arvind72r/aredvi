package com.aredvi.dto.response;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class RespUserProfileDTO {
	private UUID id;
	
	private UUID userLoginId;
	
	private String fname;
	
	private String lname;
	
	private Date dob;
	
	private String city;
	
	private String mobileNumber;
	
	private String email;
	
	private String gender;
	
	private String type;
	
	private List<String> allergies;
	
	private UUID parentId;
	
	private List<String> familyPhysician;
	
	private String address;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(UUID userLoginId) {
		this.userLoginId = userLoginId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public UUID getParentId() {
		return parentId;
	}

	public void setParentId(UUID parentId) {
		this.parentId = parentId;
	}

	public List<String> getFamilyPhysician() {
		return familyPhysician;
	}

	public void setFamilyPhysician(List<String> familyPhysician) {
		this.familyPhysician = familyPhysician;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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
	
}
