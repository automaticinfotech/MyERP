package com.aits.myerp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aits.myerp.dao.MenuMasterDao;
import com.aits.myerp.model.MenuMasterModel;

@Repository
public class MenuMasterDaoImpl implements MenuMasterDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Boolean createMenu(List<MenuMasterModel> menuMasterModelList) {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction= session.beginTransaction();
			for(MenuMasterModel currentMenuMasterModel: menuMasterModelList)
				session.saveOrUpdate(currentMenuMasterModel);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}finally {
			session.clear();
			session.close();
		}
	}

	@Override
	public List<MenuMasterModel> getMenuMasterList() {
		return sessionFactory.getCurrentSession().createQuery("from MenuMasterModel").list();
	}
}
