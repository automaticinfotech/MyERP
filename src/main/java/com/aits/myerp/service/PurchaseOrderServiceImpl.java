package com.aits.myerp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aits.myerp.dao.PurchaseOrderDAO;
import com.aits.myerp.model.MaterialMst;
import com.aits.myerp.model.PurchaseOrderDetails;
import com.aits.myerp.model.VendorMst;



@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	
	@Autowired
	private PurchaseOrderDAO purchaseOrderDAO;
	
	@Override
	public void savePurchaseOrder(PurchaseOrderDetails pOrderDetails) {
		// TODO Auto-generated method stub
		purchaseOrderDAO.savePurchaseOrder(pOrderDetails);
	}

	@Override
	public List<VendorMst> getAllVenderList() {
		// TODO Auto-generated method stub
		return purchaseOrderDAO.getAllVenderList();
	}

	@Override
	public List<MaterialMst> getAllMaterialList() {
		// TODO Auto-generated method stub
		return purchaseOrderDAO.getAllMaterialList();
	}

	@Override
	public List getAllPurchaseDetails() {
		// TODO Auto-generated method stub
		return purchaseOrderDAO.getAllPurchaseDetails();
	}

	@Override
	public List getSalesOrderDocumentList() {
		// TODO Auto-generated method stub
		return purchaseOrderDAO.getSalesOrderDocumentList();
	}

}
