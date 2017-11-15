package com.aits.myerp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class UserAuthorizationModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer autorizationId;
	@OneToOne
	private UserMasterModel userMasterModel;
	@OneToOne
	private MenuMasterModel menuMasterModel;
	@Column
	private Boolean isCreate;
	@Column
	private Boolean isSelect;
	@Column
	private Boolean isUpdate;
	@Column
	private Boolean isDelete;
	
	public Integer getAutorizationId() {
		return autorizationId;
	}
	public void setAutorizationId(Integer autorizationId) {
		this.autorizationId = autorizationId;
	}
	public UserMasterModel getUserMasterModel() {
		return userMasterModel;
	}
	public void setUserMasterModel(UserMasterModel userMasterModel) {
		this.userMasterModel = userMasterModel;
	}
	public MenuMasterModel getMenuMasterModel() {
		return menuMasterModel;
	}
	public void setMenuMasterModel(MenuMasterModel menuMasterModel) {
		this.menuMasterModel = menuMasterModel;
	}
	public Boolean getIsCreate() {
		return isCreate;
	}
	public void setIsCreate(Boolean isCreate) {
		this.isCreate = isCreate;
	}
	public Boolean getIsSelect() {
		return isSelect;
	}
	public void setIsSelect(Boolean isSelect) {
		this.isSelect = isSelect;
	}
	public Boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
}
