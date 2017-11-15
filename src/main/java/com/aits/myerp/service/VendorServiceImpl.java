package com.aits.myerp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aits.myerp.dao.VendorDao;
import com.aits.myerp.model.VendorMst;

@Service
public class VendorServiceImpl implements VendorServices{ 

	@Autowired
	private VendorDao vendorDao;
	
	@Override
	@Transactional
	public List<VendorMst> getAllVendor() {
		return vendorDao.getAllVendor();
	}

	@Override
	@Transactional
	public boolean addVendor(VendorMst vendor) {
		return vendorDao.addVendor(vendor);
	}

	@Override
	@Transactional
	public VendorMst getVendorById(VendorMst vendor) {
		return vendorDao.getVendorById(vendor);
	}

	@Override
	@Transactional
	public boolean updateVendor(VendorMst vendor) {
		return vendorDao.updateVendor(vendor);	}
	
	@Override
	@Transactional
	public boolean deleteVendor(VendorMst vendor) {
		return vendorDao.deleteVendor(vendor);	}

}
