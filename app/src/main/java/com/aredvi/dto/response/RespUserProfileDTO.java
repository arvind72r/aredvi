package com.aredvi.dto.response;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.aredvi.dto.AddressDTO;
import com.aredvi.dto.AllergyDTO;
import com.aredvi.dto.EmailDTO;
import com.aredvi.dto.PhoneDTO;


public class RespUserProfileDTO implements Serializable{
	
	private static final long serialVersionUID = -1069255568979037352L;

	private int userId;
	
	private String fname;
	
	private String lname;
	
	private Date dob;
	
	private String mobileNumber;
	
	private String email;
	
	private String address;
	
	private String city;
	
	private String gender;
	
	private String type; // reception, User, Doctor
	
	private String photo;
	
	private Set<PhoneDTO> phone = new HashSet<PhoneDTO>(0);
	
	private Set<AddressDTO> addresses = new HashSet<AddressDTO>(0);
	
	private Set<AllergyDTO> allergy = new HashSet<AllergyDTO>(0);
	
	private Set<EmailDTO> emails = new HashSet<EmailDTO>(0);
	
	private int doctorxid ;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public int getDoctorxid() {
		return doctorxid;
	}

	public void setDoctorxid(int doctorxid) {
		this.doctorxid = doctorxid;
	}

	
}

