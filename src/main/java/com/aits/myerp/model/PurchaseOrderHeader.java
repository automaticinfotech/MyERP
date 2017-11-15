package com.aits.myerp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="PurchaseOrderHeader")
public class PurchaseOrderHeader implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5153236220108319292L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "documentID")
	private int documentID;

	@Column(name = "documentNo")
	private String documentNo;

	@Column(name = "documentDate")
	private String documentDate;



	@Column(name = "notes")
	private String notes;

	@Column(name = "refDocNo")
	private String refDocNo;

	@Column(name = "refDocDate")
	private String refDocDate;

	
	@ManyToOne
	@JoinColumn(name = "vendorId")
	private VendorMst vendorMst;
	
	
	public VendorMst getVendorMst() {
		return vendorMst;
	}
	public void setVendorMst(VendorMst vendorMst) {
		this.vendorMst = vendorMst;
	}
	public int getDocumentID() {
		return documentID;
	}
	public void setDocumentID(int documentID) {
		this.documentID = documentID;
	}
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	public String getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getRefDocNo() {
		return refDocNo;
	}
	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}
	public String getRefDocDate() {
		return refDocDate;
	}
	public void setRefDocDate(String refDocDate) {
		this.refDocDate = refDocDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
