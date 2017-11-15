package com.aits.myerp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SalesOrderDetails")
public class SalesOrderDetailsModel {

	public SalesOrderDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="soDetailId")
	private int soDetailId;

	@ManyToOne
	@JoinColumn(name="materialId")
	private MaterialMst materialMst;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="rate")
	private Double rate;
	
	@Column(name="exptDeliveryDate")
	private String exptDeliveryDate;
	
	@Column(name="amount")
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name="soDocumentId")
	private SalesOrderHeaderModel salesorderheader;

	public int getSoDetailId() {
		return soDetailId;
	}

	public void setSoDetailId(int soDetailId) {
		this.soDetailId = soDetailId;
	}


	public MaterialMst getMaterialMst() {
		return materialMst;
	}

	public void setMaterialMst(MaterialMst materialMst) {
		this.materialMst = materialMst;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getExptDeliveryDate() {
		return exptDeliveryDate;
	}

	public void setExptDeliveryDate(String exptDeliveryDate) {
		this.exptDeliveryDate = exptDeliveryDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public SalesOrderHeaderModel getSalesorderheader() {
		return salesorderheader;
	}

	public void setSalesorderheader(SalesOrderHeaderModel salesorderheader) {
		this.salesorderheader = salesorderheader;
	}

	@Override
	public String toString() {
		return "SalesOrderDetailsModel [soDetailId=" + soDetailId + ", materialMst=" + materialMst + ", quantity="
				+ quantity + ", rate=" + rate + ", exptDeliveryDate=" + exptDeliveryDate + ", amount=" + amount
				+ ", salesorderheader=" + salesorderheader + "]";
	}

	
	
}
