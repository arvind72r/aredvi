package com.aredvi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table("doctor")
public class Doctor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9143686145646852309L;

	@PrimaryKeyColumn(name = "id",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	
	@Field
	@Column(value = "f_name")
	private String fname;
	
	@Column(value = "l_name")
	private String lname;
	
	@Column(value = "mobile_number")
	private String mobileNumber;
	
	@Column(value = "email")
	private String email;
	
	@Column(value = "dob")
	private Date dob;
	
	@Column(value = "gender")
	private String gender;
	
	@Column(value = "mp_lic_authority")
	private String mpLicAuthority;
	
	@Column(value = "mp_lic_no")
	private String mpLicNo;
	
	@Column(value = "mp_lic_date_of_issue")
	private Date mpLicDateOfIssue;
	
	@Column(value = "varified")
	private boolean varified;
	
	@Column(value = "specialities")
	private List<String> specialities;
	
	@Column(value = "profile")
	private String profile;
	
	@Column(value = "calendar")
	private String calendar;
	
	@Column(value = "photo")
	private String photo;
	
	@Column(value = "documents")
	private Map<String, String> documents;
	
	@Column(value = "profile_delted")
	private boolean profileDelted;
	
	@Column(value = "phone")
	private List<String> phoneNumber;
	
	@Column(value = "lat")
	private String lat;
	
	@Column(value = "longs")
	private String longs;
	
	@Column(value = "address")
	private String address;
	
	@Column(value = "city")
	private String city;
	
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

	public Map<String, String> getDocuments() {
		return documents;
	}

	public void setDocuments(Map<String, String> documents) {
		this.documents = documents;
	}

	public boolean isProfileDelted() {
		return profileDelted;
	}

	public void setProfileDelted(boolean profileDelted) {
		this.profileDelted = profileDelted;
	}
	
	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Doctor(UUID id, String fname, String lname, String mobileNumber, String email, Date dob, String gender,
			String mpLicAuthority, String mpLicNo, Date mpLicDateOfIssue, boolean varified, List<String> specialities,
			String profile, String calendar, String photo,String address, Map<String, String> documents, boolean profileDelted, List<String>  phoneNumber,
			String lat, String longs, String city) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.mpLicAuthority = mpLicAuthority;
		this.mpLicNo = mpLicNo;
		this.mpLicDateOfIssue = mpLicDateOfIssue;
		this.varified = varified;
		this.specialities = specialities;
		this.profile = profile;
		this.calendar = calendar;
		this.photo = photo;
		this.documents = documents;
		this.profileDelted = profileDelted;
		this.phoneNumber = phoneNumber;
		this.lat = lat;
		this.longs = longs;
		this.city =city; 
		this.address = address;
	}

	public Doctor(String fname, String lname, String mobileNumber, String email, Date dob, String gender,
			String mpLicAuthority, String mpLicNo, Date mpLicDateOfIssue, boolean varified, List<String> specialities,
			String profile, String calendar, String photo, Map<String, String> documents, boolean profileDelted, List<String>  phoneNumber,
			String lat, String longs, String city,String address) {
		this.fname = fname;
		this.lname = lname;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.mpLicAuthority = mpLicAuthority;
		this.mpLicNo = mpLicNo;
		this.mpLicDateOfIssue = mpLicDateOfIssue;
		this.varified = varified;
		this.specialities = specialities;
		this.profile = profile;
		this.calendar = calendar;
		this.photo = photo;
		this.documents = documents;
		this.profileDelted = profileDelted;
		this.phoneNumber = phoneNumber;
		this.lat = lat;
		this.longs = longs;
		this.city =city; 
		this.address = address;
	}
	public Doctor(){
		
	}
}
