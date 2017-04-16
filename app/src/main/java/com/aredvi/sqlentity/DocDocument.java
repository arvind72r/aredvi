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
@Table(name = "doc_document", catalog = "aredvidb")
public class DocDocument implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 4155549145432259235L;
	private int docId;
	private String docName;
	private String docpath;
	private Doctor doctor = new Doctor();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "docId", unique = true, nullable = false)
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	
	@Column(name = "docName")
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	@Column(name = "docpath")
	public String getDocpath() {
		return docpath;
	}
	public void setDocpath(String docpath) {
		this.docpath = docpath;
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
