package com.aits.myerp.dao;

import java.util.List;

import org.hibernate.Session;
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
		return sessionFactory.getCurrentSession().createQuery("from MaterialMst ").list();
	}
	
	
	@Override
	public List<MaterialMst> getActiveMaterail() {
		return sessionFactory.getCurrentSession().createQuery("from MaterialMst where isActive = 'on' ").list();
	}

	@Override
	public boolean addMaterial(MaterialMst materialMst) {
		sessionFactory.getCurrentSession().saveOrUpdate(materialMst);
		return true;
	}

	@Override
	public MaterialMst getMaterialById(MaterialMst materialMst) {
		Session session = sessionFactory.getCurrentSession();
		MaterialMst material =(MaterialMst)session.get(MaterialMst.class, materialMst.getMaterialId());
		return material;
	}

	@Override
	public boolean updateMaterial(MaterialMst materialMst) {
		boolean flag= true;
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(materialMst);
		return flag;
	}

	@Override
	public boolean deleteMaterial(MaterialMst materialMst) {
		boolean flag = true;
		Session session = sessionFactory.getCurrentSession();
		MaterialMst material =(MaterialMst)session.get(MaterialMst.class, materialMst.getMaterialId());
		material.setIsActive("I");
		session.saveOrUpdate(material);
		return flag;
	}

}
