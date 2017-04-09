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

@Entity
@Table(name = "prescription", catalog = "aredvidb")
public class Prescription implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4077884311916482626L;
	private int prescriptionId;
	private Consultation consultation;
	private Set<PrescriptionLine> drug = new HashSet<PrescriptionLine>(0);
	private Date createdOn;
	private Date updatedOn;
	private Date expDate; // expiry date

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prescriptionId", unique = true, nullable = false)
	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consultation_xid")
	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prescription")
	public Set<PrescriptionLine> getDrug() {
		return drug;
	}

	public void setDrug(Set<PrescriptionLine> drug) {
		this.drug = drug;
	}

	@Column(name = "expDate")
	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	
}
