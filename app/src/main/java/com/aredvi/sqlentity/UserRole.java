package com.aredvi.sqlentity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_role", catalog = "aredvidb")
public class UserRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1666409007503892898L;
	
	private int roleId;
	
	private String role;
	
	UserLogin userLogin = new UserLogin();
	
	private Set<Authority> authority = new HashSet<Authority>(0);
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roleId", unique = true, nullable = false)
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_login_xid")
	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userRole")
	public Set<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}
	
}
