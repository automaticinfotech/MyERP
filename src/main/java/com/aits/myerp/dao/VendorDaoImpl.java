package com.aits.myerp.dao;

import java.util.List;

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
		return sessionFactory.getCurrentSession().createQuery("from VendorMst").list();
	}

	@Override
	public boolean addVendor(VendorMst vendor) {
		sessionFactory.getCurrentSession().saveOrUpdate(vendor);
		return true;
	}

}
