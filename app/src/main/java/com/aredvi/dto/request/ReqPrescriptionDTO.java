package com.aredvi.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class ReqPrescriptionDTO implements Serializable{

	private static final long serialVersionUID = -703944326879365873L;
	private int prescriptionId;
	private int consultationxid;
	private Set<PrescriptionLine> drug = new HashSet<PrescriptionLine>(0);
	private Date expDate;

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Set<PrescriptionLine> getDrug() {
		return drug;
	}

	public void setDrug(Set<PrescriptionLine> drug) {
		this.drug = drug;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public int getConsultationxid() {
		return consultationxid;
	}

	public void setConsultationxid(int consultationxid) {
		this.consultationxid = consultationxid;
	}

	
}

class PrescriptionLine{

	private int lineId;
	private String drug;
	private String molecule;
	private String schedule;   // Before lunch, After lunch
	private String dose;  // 1-0-1
	private int duration; // No of days
	private Boolean deleted = Boolean.FALSE;
	private int prescriptionxid;
	private int refill;

	public int getLineId() {
		return lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

	public String getDrug() {
		return drug;
	}
	
	public String getMolecule() {
		return molecule;
	}

	public void setMolecule(String molecule) {
		this.molecule = molecule;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getDose() {
		return dose;
	}


	public void setDose(String dose) {
		this.dose = dose;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getRefill() {
		return refill;
	}

	public void setRefill(int refill) {
		this.refill = refill;
	}

	public int getPrescriptionxid() {
		return prescriptionxid;
	}

	public void setPrescriptionxid(int prescriptionxid) {
		this.prescriptionxid = prescriptionxid;
	}

}
