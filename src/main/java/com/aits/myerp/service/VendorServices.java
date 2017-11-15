package com.aits.myerp.service;

import java.util.List;

import com.aits.myerp.model.VendorMst;

public interface VendorServices { 

	public List<VendorMst> getAllVendor();
	
	public boolean addVendor(VendorMst vendor);
	
	public VendorMst getVendorById(VendorMst vendor);
	
	public boolean updateVendor(VendorMst vendor);
	
	public boolean deleteVendor(VendorMst vendor);
}
