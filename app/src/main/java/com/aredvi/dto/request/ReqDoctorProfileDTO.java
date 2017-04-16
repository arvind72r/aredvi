package com.aredvi.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.aredvi.dto.AddressDTO;
import com.aredvi.dto.DocDocumentDTO;
import com.aredvi.dto.PhoneDTO;
import com.aredvi.dto.SpecialityDTO;

public class ReqDoctorProfileDTO implements Serializable{
	private static final long serialVersionUID = -8601436166837992795L;

	private int id;
	
	private int userId;
	
	private int userLoginId;
	
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
	
	private String profile;
	
	private String calendar;
	
	private String photo;
	
	private Set<DocDocumentDTO> docDocument = new HashSet<DocDocumentDTO>(0);
	
	private Set<SpecialityDTO> speciality = new HashSet<SpecialityDTO>(0);	
	
	private Set<PhoneDTO> phone = new HashSet<PhoneDTO>(0);
	
	private Set<AddressDTO> addresses = new HashSet<AddressDTO>(0);
	
	private boolean profileDelted;
	
	private String lat;
	
	private String longs;
	
	private String city;
	
	private String address;
	
	private String googleId;
	
	private String placeId;

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

	public Set<DocDocumentDTO> getDocDocument() {
		return docDocument;
	}

	public void setDocDocument(Set<DocDocumentDTO> docDocument) {
		this.docDocument = docDocument;
	}

	public Set<SpecialityDTO> getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Set<SpecialityDTO> speciality) {
		this.speciality = speciality;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
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
	
}
