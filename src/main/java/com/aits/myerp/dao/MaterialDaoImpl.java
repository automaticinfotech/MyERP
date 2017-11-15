package com.aits.myerp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aits.myerp.model.MaterialMst;
import com.aits.myerp.model.VendorMst;

@Repository
public class MaterialDaoImpl implements MaterialDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MaterialMst> getAllMaterail() {
		return sessionFactory.getCurrentSession().createQuery("from MaterialMst where isAcive = 'A' ").list();
	}

}
