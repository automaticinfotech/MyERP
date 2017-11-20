package com.aits.myerp.dto;



import com.aits.myerp.model.MaterialMst;
import com.aits.myerp.model.PurchaseOrderHeader;

public class PurchaseOrderDetailsDTO {

	
	
	private int poDetailsID;
	private int quantity;
	private String expDeliveryDate;
	private String notes;
	private int rate;
	private PurchaseOrderHeader purchaseOrderHeader;
	public int getPoDetailsID() {
		return poDetailsID;
	}
	public void setPoDetailsID(int poDetailsID) {
		this.poDetailsID = poDetailsID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getExpDeliveryDate() {
		return expDeliveryDate;
	}
	public void setExpDeliveryDate(String expDeliveryDate) {
		this.expDeliveryDate = expDeliveryDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public PurchaseOrderHeader getPurchaseOrderHeader() {
		return purchaseOrderHeader;
	}
	public void setPurchaseOrderHeader(PurchaseOrderHeader purchaseOrderHeader) {
		this.purchaseOrderHeader = purchaseOrderHeader;
	}
	public MaterialMst getMaterialMst() {
		return materialMst;
	}
	public void setMaterialMst(MaterialMst materialMst) {
		this.materialMst = materialMst;
	}
	private MaterialMst materialMst;
}
