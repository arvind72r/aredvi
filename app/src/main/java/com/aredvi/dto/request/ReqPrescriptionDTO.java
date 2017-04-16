package com.aredvi.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class ReqPrescriptionDTO implements Serializable{

	private static final long serialVersionUID = -703944326879365873L;
	private int prescriptionId;
	private int consultationxid;
	private Set<ReqPrescriptionLineDTO> prescriptionLines = new HashSet<ReqPrescriptionLineDTO>(0);
	private Date expDate;

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
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

	public Set<ReqPrescriptionLineDTO> getPrescriptionLines() {
		return prescriptionLines;
	}

	public void setPrescriptionLines(Set<ReqPrescriptionLineDTO> prescriptionLines) {
		this.prescriptionLines = prescriptionLines;
	}

}


