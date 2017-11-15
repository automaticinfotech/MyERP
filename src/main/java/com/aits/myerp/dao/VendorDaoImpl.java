package com.aits.myerp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aits.myerp.model.VendorMst;

@Repository
public class VendorDaoImpl implements VendorDao{ 

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<VendorMst> getAllVendor() {
		return sessionFactory.getCurrentSession().createQuery("from VendorMst where isAcive = 'A' ").list();
	}

	@Override
	public boolean addVendor(VendorMst vendor) {
		sessionFactory.getCurrentSession().saveOrUpdate(vendor);
		return true;
	}

	@Override
	public VendorMst getVendorById(VendorMst vendor) {
		
		Session session = sessionFactory.getCurrentSession();
		VendorMst vendorMst =(VendorMst)session.get(VendorMst.class, vendor.getVendorId());
		return vendorMst;
		
	}

	@Override
	public boolean updateVendor(VendorMst vendor) {
		boolean flag= true;
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(vendor);
		return flag;
	}

	@Override
	public boolean deleteVendor(VendorMst vendor) {
		
		boolean flag = true;
		Session session = sessionFactory.getCurrentSession();
		VendorMst vendorMst =(VendorMst)session.get(VendorMst.class, vendor.getVendorId());
		vendorMst.setIsAcive("I");
		session.saveOrUpdate(vendorMst);
		return flag;
	}

}
