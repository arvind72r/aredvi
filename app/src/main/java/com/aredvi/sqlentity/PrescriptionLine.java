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
import javax.persistence.Table;

@Entity
@Table(name = "prescriptionLine", catalog = "aredvidb")
public class PrescriptionLine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8009121735902769285L;
	private int lineId;
	private String drug;
	private String molecule;
	private String schedule;   // Before lunch, After lunch
	private String dose;  // 1-0-1
	private int duration; // No of days
	private Date createdOn;
	private Date updatedOn;
	private Boolean deleted = Boolean.FALSE;
	private Prescription prescription;
	private int refill;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lineId", unique = true, nullable = false)
	public int getLineId() {
		return lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

	@Column(name = "drug")
	public String getDrug() {
		return drug;
	}
	
	@Column(name = "molecule")
	public String getMolecule() {
		return molecule;
	}

	public void setMolecule(String molecule) {
		this.molecule = molecule;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	@Column(name = "schedule")
	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	@Column(name = "dose")
	public String getDose() {
		return dose;
	}


	public void setDose(String dose) {
		this.dose = dose;
	}

	@Column(name = "duration")
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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

	@Column(name = "deleted")
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prescription_xid")
	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	@Column(name = "refill")
	public int getRefill() {
		return refill;
	}

	public void setRefill(int refill) {
		this.refill = refill;
	}
}
