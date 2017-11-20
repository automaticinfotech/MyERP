package com.aits.myerp.dto;



import com.aits.myerp.model.VendorMst;

public class PurchaseOrderHeaderDTO {
	private int documentID;
	private String documentNo;
	private String documentDate;
	private String notes;
	private String refDocNo;
	private String refDocDate;
	private VendorMst vendorMst;
	
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
	public VendorMst getVendorMst() {
		return vendorMst;
	}
	public void setVendorMst(VendorMst vendorMst) {
		this.vendorMst = vendorMst;
	}
	
	

}
