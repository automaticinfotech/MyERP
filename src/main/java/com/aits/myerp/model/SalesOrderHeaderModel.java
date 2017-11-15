package com.aits.myerp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SalesOrderHeader")
public class SalesOrderHeaderModel implements Serializable {

	public SalesOrderHeaderModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="soDocumentId")
	private int soDocumentId;
	
	@Column(name="sodocumentNumber")
	private String sodocumentNumber;
	
	@Column(name="sodocumentDate")
	private String sodocumentDate;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private CustomerMst customerMst;
	
	@Column(name="notes")	
	private String notes;
	
	@Column(name="refDocumentNumber")
	private String refDocumentNumber;
	
	@Column(name="refDocumentDate")
	private String refDocumentDate;

	public int getSoDocumentId() {
		return soDocumentId;
	}

	public void setSoDocumentId(int soDocumentId) {
		this.soDocumentId = soDocumentId;
	}

	public String getSodocumentNumber() {
		return sodocumentNumber;
	}

	public void setSodocumentNumber(String sodocumentNumber) {
		this.sodocumentNumber = sodocumentNumber;
	}

	public String getSodocumentDate() {
		return sodocumentDate;
	}

	public void setSodocumentDate(String sodocumentDate) {
		this.sodocumentDate = sodocumentDate;
	}

	public CustomerMst getCustomerMst() {
		return customerMst;
	}

	public void setCustomerMst(CustomerMst customerMst) {
		this.customerMst = customerMst;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getRefDocumentNumber() {
		return refDocumentNumber;
	}

	public void setRefDocumentNumber(String refDocumentNumber) {
		this.refDocumentNumber = refDocumentNumber;
	}

	public String getRefDocumentDate() {
		return refDocumentDate;
	}

	public void setRefDocumentDate(String refDocumentDate) {
		this.refDocumentDate = refDocumentDate;
	}

	@Override
	public String toString() {
		return "SalesOrderHeaderModel [soDocumentId=" + soDocumentId + ", sodocumentNumber=" + sodocumentNumber
				+ ", sodocumentDate=" + sodocumentDate + ", customerMst=" + customerMst + ", notes=" + notes
				+ ", refDocumentNumber=" + refDocumentNumber + ", refDocumentDate=" + refDocumentDate + "]";
	}

			
}
