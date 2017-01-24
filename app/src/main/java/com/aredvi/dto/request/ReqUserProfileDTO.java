package com.aredvi.dto.request;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ReqUserProfileDTO {
	private UUID id;
	
	private UUID userLoginId;
	
	private String fname;
	
	private String lname;
	
	private Date dob;
	
	private String mobileNumber;
	
	private String email;
	
	private String gender;
	
	private String city;
	
	private String type;
	
	private List<String> allergies;
	
	private UUID parentId;
	
	private List<String> familyPhysician;
	
	private String userName;
	
	private String password;
	
	private String confirmPassword;
	
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
