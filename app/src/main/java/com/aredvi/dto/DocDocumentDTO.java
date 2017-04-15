package com.aredvi.dto;

import java.io.Serializable;

public class DocDocumentDTO implements Serializable{

	private static final long serialVersionUID = 4492544407870610979L;
	private int docId;
	private String docName;
	private String docpath;
	private int doctorxid;
	
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	public String getDocpath() {
		return docpath;
	}
	public void setDocpath(String docpath) {
		this.docpath = docpath;
	}
	public int getDoctorxid() {
		return doctorxid;
	}
	public void setDoctorxid(int doctorxid) {
		this.doctorxid = doctorxid;
	}
	
}
