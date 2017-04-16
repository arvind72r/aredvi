package com.aredvi.sqlentity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consultation", catalog = "aredvidb")
public class Consultation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9081485680979352920L;
	private int consultationId;
	private String symptoms;
	private String diagnosis;
	private String userNotes;
	private Boolean active = Boolean.TRUE;
	private Prescription prescription = new Prescription();
	private Date consultationDate;
	private Date createdOn;
	private Date updatedOn;
	private User createdBy = new User();; // User , Front desk

	private Address practisLocation = new Address();
	private Doctor doctor = new Doctor();
	private User user = new User();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "consultationId", unique = true, nullable = false)
	public int getConsultationId() {
		return consultationId;
	}

	public void setConsultationId(int consultationId) {
		this.consultationId = consultationId;
	}

	@Column(name = "symptoms")
	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	@Column(name = "diagnosis")
	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Column(name = "userNotes")
	public String getUserNotes() {
		return userNotes;
	}

	public void setUserNotes(String userNotes) {
		this.userNotes = userNotes;
	}

	@Column(name = "active")
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "prescription")
	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_xid")
	public Address getPractisLocation() {
		return practisLocation;
	}

	public void setPractisLocation(Address practisLocation) {
		this.practisLocation = practisLocation;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_xid")
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aredvi_user_xid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "consultationDate")
	public Date getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(Date consultationDate) {
		this.consultationDate = consultationDate;
	}
	@Column(name = "createdOn")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "updatedOn")
	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aredvi_user_xid")
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

}
