package com.aits.myerp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VendorMst")
public class VendorMst {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendorId;

	@Column
	private String vendorCode;

	@Column 
	private String vendorName;

	@Column
	private String vendorAddressline1;

	@Column
	private String vendorAddressline2;
	
	@Column
	private String vendorEmail;
	
	@Column
	private String isAcive;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddressline1() {
		return vendorAddressline1;
	}

	public void setVendorAddressline1(String vendorAddressline1) {
		this.vendorAddressline1 = vendorAddressline1;
	}

	public String getVendorAddressline2() {
		return vendorAddressline2;
	}

	public void setVendorAddressline2(String vendorAddressline2) {
		this.vendorAddressline2 = vendorAddressline2;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getIsAcive() {
		return isAcive;
	}

	public void setIsAcive(String isAcive) {
		this.isAcive = isAcive;
	}
	
	
	
}
