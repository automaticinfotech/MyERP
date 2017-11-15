package com.aits.myerp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MaterialMst") 
public class MaterialMst {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int materialId;

	@Column
	private String materialCode;

	@Column
	private String materialName;

	@Column
	private String materialDesc;

	@Column
	private String UOM;
	
	@Column
	private String isFG;
	
	@Column
	private String isActive;

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	public String getIsFG() {
		return isFG;
	}

	public void setIsFG(String isFG) {
		this.isFG = isFG;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	

	
	
}
