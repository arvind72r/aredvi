package com.aredvi.sqlentity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "doctor", catalog = "aredvidb")
public class Doctor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9143686145646852309L;

	private int docID;
	
	private String mpLicAuthority;
	
	private String mpLicNo;
	
	private Date mpLicDateOfIssue;
	
	private boolean varified;
	
	private String profile;
	
	private String calendar;
	
	private String photo;
	
	private boolean profileDelted;

	private Set<DocDocument> docDocument = new HashSet<DocDocument>(0);
	
	private Set<Speciality> speciality = new HashSet<Speciality>(0);
	
	private Set<Consultation> consultation = new HashSet<Consultation>(0);
	
	private User user = new User();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "docID", unique = true, nullable = false)
	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

	@Column(name = "mpLicAuthority")
	public String getMpLicAuthority() {
		return mpLicAuthority;
	}

	public void setMpLicAuthority(String mpLicAuthority) {
		this.mpLicAuthority = mpLicAuthority;
	}

	@Column(name = "mpLicNo")
	public String getMpLicNo() {
		return mpLicNo;
	}

	public void setMpLicNo(String mpLicNo) {
		this.mpLicNo = mpLicNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mpLicDateOfIssue")
	public Date getMpLicDateOfIssue() {
		return mpLicDateOfIssue;
	}

	public void setMpLicDateOfIssue(Date mpLicDateOfIssue) {
		this.mpLicDateOfIssue = mpLicDateOfIssue;
	}

	@Column(name = "varified")
	public boolean isVarified() {
		return varified;
	}

	public void setVarified(boolean varified) {
		this.varified = varified;
	}

	@Column(name = "profile")
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Column(name = "calendar")
	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	@Column(name = "photo")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "profileDelted")
	public boolean isProfileDelted() {
		return profileDelted;
	}

	public void setProfileDelted(boolean profileDelted) {
		this.profileDelted = profileDelted;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	public Set<DocDocument> getDocDocument() {
		return docDocument;
	}

	public void setDocDocument(Set<DocDocument> docDocument) {
		this.docDocument = docDocument;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	public Set<Speciality> getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Set<Speciality> speciality) {
		this.speciality = speciality;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aredvi_user_xid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	public Set<Consultation> getConsultation() {
		return consultation;
	}

	public void setConsultation(Set<Consultation> consultation) {
		this.consultation = consultation;
	}
}
