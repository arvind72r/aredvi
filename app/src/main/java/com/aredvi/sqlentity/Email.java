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
@Table(name = "email", catalog = "aredvidb")
public class Email implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 283165060965171546L;
	private int emID;
	private String emilID;
	private String type;
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emID", unique = true, nullable = false)
	public int getEmID() {
		return emID;
	}
	public void setEmID(int emID) {
		this.emID = emID;
	}
	
	@Column(name = "emilID")
	public String getEmilID() {
		return emilID;
	}
	public void setEmilID(String emilID) {
		this.emilID = emilID;
	}
	
	@Column(name = "type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aredvi_user_xid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
