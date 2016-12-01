package com.aredvi.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table("user")
public class User {
	
	@PrimaryKeyColumn(name = "id",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	
	@Column(value = "user_login_id")
	private UUID userLoginId;
	
	@Column(value = "parent_id")
	private UUID parentId;
	
	@Column(value = "f_name")
	private String fname;
	
	@Column(value = "l_name")
	private String lname;
	
	@Column(value = "dob")
	private Date dob;
	
	@Column(value = "mobile_number")
	private String mobileNumber;
	
	@Column(value = "email")
	private String email;
	
	@Column(value = "city")
	private String city;
	
	@Column(value = "gender")
	private String gender;
	
	@Column(value = "type")
	private String type;
	
	@Column(value = "allergies")
	private List<String> allergies;
	
	@Column(value = "family_physician")
	private List<String> familyPhysician;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
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
	
	public UUID getParentId() {
		return parentId;
	}

	public void setParentId(UUID parentId) {
		this.parentId = parentId;
	}

	public User(UUID id, UUID userLoginId, String fname, String lname, Date dob,String city, String mobileNumber, String email, String gender,
			String type, List<String> allergies, List<String> familyPhysician, UUID parentId) {
		this.id = id;
		this.userLoginId = userLoginId;
		this.fname = fname;
		this.lname = lname;
		this.city =city;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.gender = gender;
		this.type = type;
		this.allergies = allergies;
		this.familyPhysician = familyPhysician;
		this.parentId = parentId;
	}

	public User(UUID userLoginId, String fname, String lname,Date dob,String city, String mobileNumber, String email, String gender, String type,
			List<String> allergies, List<String> familyPhysician, UUID parentId) {
		this.id = UUIDs.timeBased();
		this.userLoginId = userLoginId;
		this.fname = fname;
		this.lname = lname;
		this.city =city;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.gender = gender;
		this.type = type;
		this.allergies = allergies;
		this.familyPhysician = familyPhysician;
		this.parentId = parentId;
	}

	public User(){
		this.id = UUIDs.timeBased();
	}
}
