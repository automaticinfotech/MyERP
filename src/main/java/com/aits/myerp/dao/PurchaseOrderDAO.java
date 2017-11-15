package com.aits.myerp.dao;

import java.util.List;

import com.aits.myerp.model.MaterialMst;
import com.aits.myerp.model.PurchaseOrderDetails;
import com.aits.myerp.model.VendorMst;

public interface PurchaseOrderDAO {
	public void savePurchaseOrder(PurchaseOrderDetails purchaseOrderDetails);
	public List<VendorMst> getAllVenderList();
	public List<MaterialMst> getAllMaterialList();
}
