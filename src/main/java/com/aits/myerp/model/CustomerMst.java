package com.aits.myerp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerMst")
public class CustomerMst {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@Column
	private String customerCode;

	@Column
	private String customerName;

	@Column
	private String customerAddressline1;

	@Column
	private String customerAddressline2;
	
	@Column
	private String customerEmail; 
	
	@Column
	private String isAcive;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddressline1() {
		return customerAddressline1;
	}

	public void setCustomerAddressline1(String customerAddressline1) {
		this.customerAddressline1 = customerAddressline1;
	}

	public String getCustomerAddressline2() {
		return customerAddressline2;
	}

	public void setCustomerAddressline2(String customerAddressline2) {
		this.customerAddressline2 = customerAddressline2;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getIsAcive() {
		return isAcive;
	}

	public void setIsAcive(String isAcive) {
		this.isAcive = isAcive;
	}
	
	

}
