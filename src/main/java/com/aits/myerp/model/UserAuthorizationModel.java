package com.aits.myerp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAuthorizationModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer authorizationId;
	@Column
	private String loginId;
	@Column
	private String role;
	
	public Integer getAuthorizationId() {
		return authorizationId;
	}
	public void setAuthorizationId(Integer authorizationId) {
		this.authorizationId = authorizationId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
