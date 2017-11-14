package com.aits.myerp.dao;

import java.util.List;
import com.aits.myerp.model.VendorMst;

public interface VendorDao {

	public List<VendorMst> getAllVendor();
	
	public boolean addVendor(VendorMst vendor);
}
