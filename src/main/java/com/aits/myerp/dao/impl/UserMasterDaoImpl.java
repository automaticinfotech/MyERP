package com.aits.myerp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aits.myerp.dao.UserMasterDao;
import com.aits.myerp.model.UserMasterModel;

@Repository
public class UserMasterDaoImpl implements UserMasterDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Boolean createUser(UserMasterModel userMasterModel) {
		Session session=sessionFactory.openSession();
		try {
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(userMasterModel);
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
	public List<UserMasterModel> getUserDetails() {
		return sessionFactory.getCurrentSession().createQuery("from UserMasterModel").list();
	}

}
