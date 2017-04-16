package com.aredvi.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.aredvi.dto.AddressDTO;
import com.aredvi.dto.AllergyDTO;
import com.aredvi.dto.EmailDTO;
import com.aredvi.dto.PhoneDTO;

public class ReqUserProfileDTO implements Serializable{
	private static final long serialVersionUID = 5395706710399504250L;

	private int id;
	
	private int userLoginId;
	
	private String fname;
	
	private String lname;
	
	private Date dob;
	
	private String gender;
	
	private String city;
	
	private String type;
	
	private int parentId;
	
	private List<String> familyPhysician;
	
	private String userName;
	
	private String password;
	
	private String confirmPassword;
	
	private String photo;
	
	private Set<PhoneDTO> phone = new HashSet<PhoneDTO>(0); 
	
	private Set<AddressDTO> addresses = new HashSet<AddressDTO>(0);
	
	private Set<AllergyDTO> allergy = new HashSet<AllergyDTO>(0);
	
	private Set<EmailDTO> emails = new HashSet<EmailDTO>(0);


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
