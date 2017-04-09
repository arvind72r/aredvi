package com.aredvi.sqlentity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address", catalog = "aredvidb")
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2265618344750840030L;
	private int addId;
	private String address;
	private String lat;
	private String lng;
	private User user;
	private String pinCode;
	private Set<Consultation> consultation = new HashSet<Consultation>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addId", unique = true, nullable = false)
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "lat")
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	@Column(name = "lng")
	public String getLng() {
		return lng;
	}
	
	@Column(name = "pinCode")
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aredvi_user_xid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "consultation")
	public Set<Consultation> getConsultation() {
		return consultation;
	}
	public void setConsultation(Set<Consultation> consultation) {
		this.consultation = consultation;
	}
	
}
