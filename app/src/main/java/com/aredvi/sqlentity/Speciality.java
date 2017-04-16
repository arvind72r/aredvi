package com.aredvi.sqlentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "speciality", catalog = "aredvidb")
public class Speciality implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3364946166646964476L;
	private int specId;
	private String special;
	private Doctor doctor = new Doctor();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "specId", unique = true, nullable = false)
	public int getSpecId() {
		return specId;
	}
	public void setSpecId(int specId) {
		this.specId = specId;
	}
	
	@Column(name = "special")
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_xid")
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
}
