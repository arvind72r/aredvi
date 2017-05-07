package com.aredvi.dto.request;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.aredvi.dto.AddressDTO;
import com.aredvi.dto.AllergyDTO;
import com.aredvi.dto.EmailDTO;
import com.aredvi.dto.PhoneDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReqUserProfileDTO implements Serializable{
	 static final long serialVersionUID = 5395706710399504250L;

	 int id;
	
	 int userLoginId;
	
	 String fname;
	
	 String lname;
	
	 String dob;
	
	 String gender;
	
	 String city;
	
	 String type;
	
	 int parentId;
	
	 List<String> familyPhysician;
	
	 String userName;
	
	 String password;
	
	 String confirmPassword;
	
	 String photo;
	
	 @JsonProperty("phone")
	 Set<PhoneDTO> phone; 
	
	 @JsonProperty("addresses")
	 Set<AddressDTO> addresses;
	
	 @JsonProperty("allergy")
	 Set<AllergyDTO> allergy;
	
	 @JsonProperty("emails")
	 Set<EmailDTO> emails;
	 
	


	public ReqUserProfileDTO(int id, int userLoginId, String fname, String lname, String dob, String gender, String city,
			String type, int parentId, List<String> familyPhysician, String userName, String password,
			String confirmPassword, String photo, Set<PhoneDTO> phone, Set<AddressDTO> addresses,
			Set<AllergyDTO> allergy, Set<EmailDTO> emails) {
		super();
		this.id = id;
		this.userLoginId = userLoginId;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
		this.type = type;
		this.parentId = parentId;
		this.familyPhysician = familyPhysician;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.photo = photo;
		this.phone = new HashSet<PhoneDTO>();
		this.addresses = new HashSet<AddressDTO>();
		this.allergy = new HashSet<AllergyDTO>();
		this.emails = new HashSet<EmailDTO>();
	}

	public ReqUserProfileDTO(){
		
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Set<PhoneDTO> getPhone() {
		return phone;
	}

	public void setPhone(Set<PhoneDTO> phone) {
		this.phone = phone;
	}

	public Set<AddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	public Set<AllergyDTO> getAllergy() {
		return allergy;
	}

	public void setAllergy(Set<AllergyDTO> allergy) {
		this.allergy = allergy;
	}

	public Set<EmailDTO> getEmails() {
		return emails;
	}

	public void setEmails(Set<EmailDTO> emails) {
		this.emails = emails;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
