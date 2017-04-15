package com.aredvi.dto.response;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.aredvi.dto.AddressDTO;
import com.aredvi.dto.DocDocumentDTO;
import com.aredvi.dto.PhoneDTO;
import com.aredvi.dto.SpecialityDTO;

public class RespDoctorProfileDTO implements Serializable{
	
	private static final long serialVersionUID = 2336185895913938437L;

	private int docID;
	
	private int userID;
	
	private String mpLicAuthority;
	
	private String mpLicNo;
	
	private Date mpLicDateOfIssue;
	
	private boolean varified;
	
	private String profile;
	
	private String calendar;
	
	private String photo;
	
	private boolean profileDelted;

	private Set<DocDocumentDTO> docDocument = new HashSet<DocDocumentDTO>(0);
	
	private Set<SpecialityDTO> speciality = new HashSet<SpecialityDTO>(0);
	
	private Set<PhoneDTO> phone = new HashSet<PhoneDTO>(0);
	
	private Set<AddressDTO> addresses = new HashSet<AddressDTO>(0);
	
	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isProfileDelted() {
		return profileDelted;
	}

	public void setProfileDelted(boolean profileDelted) {
		this.profileDelted = profileDelted;
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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
