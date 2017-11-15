package com.aits.myerp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UserMasterModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userid;
	@Column
	private String loginid;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private Boolean isActive;
	@Column
	private Boolean isAdminstrator;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsAdminstrator() {
		return isAdminstrator;
	}
	public void setIsAdminstrator(Boolean isAdminstrator) {
		this.isAdminstrator = isAdminstrator;
	}
}
