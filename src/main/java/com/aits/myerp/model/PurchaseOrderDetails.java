package com.aits.myerp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;



@Entity
@Table(name="PurchaseOrderDetails")
public class PurchaseOrderDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int poDetailsID;



	@Column(name = "quantity")
	private int quantity;

	@Column(name = "expDeliveryDate")
	private String expDeliveryDate;

	@Column(name = "notes")
	private String notes;

	@Column(name = "rate")
	private int rate;


    @ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "documentID")
	private PurchaseOrderHeader purchaseOrderHeader;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "materialId")
	private MaterialMst materialMst;
		
	public MaterialMst getMaterialMst() {
		return materialMst;
	}

	public void setMaterialMst(MaterialMst materialMst) {
		this.materialMst = materialMst;
	}

	public PurchaseOrderHeader getPurchaseOrderHeader() {
		return purchaseOrderHeader;
	}

	public void setPurchaseOrderHeader(PurchaseOrderHeader purchaseOrderHeader) {
		this.purchaseOrderHeader = purchaseOrderHeader;
	}

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

}
