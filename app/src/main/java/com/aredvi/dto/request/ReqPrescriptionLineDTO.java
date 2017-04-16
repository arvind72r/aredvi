package com.aredvi.dto.request;

public class ReqPrescriptionLineDTO {
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

