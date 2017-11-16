package com.aits.myerp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aits.myerp.dao.UserAuthorizationDao;
import com.aits.myerp.model.UserAuthorizationModel;

@Repository
public class UserAuthorizationDaoImpl implements UserAuthorizationDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Boolean setAuthorities(List<UserAuthorizationModel> userAuthorizationModelList) {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction= session.beginTransaction();
			for(UserAuthorizationModel currentUserAuthorizationModel: userAuthorizationModelList)
				session.saveOrUpdate(currentUserAuthorizationModel);
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
	public Integer removeAuthorities(String loginId) {
		Session session = sessionFactory.openSession();
		Integer affectedRows = 0;
		try {
			Transaction transaction= session.beginTransaction();
			affectedRows = session.createQuery("delete UserAuthorizationModel where loginId=:loginId").setString("loginId", loginId).executeUpdate();	
			transaction.commit();
			return affectedRows;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return affectedRows;
		}finally {
			session.clear();
			session.close();
		}
	}

	@Override
	public List<UserAuthorizationModel> getUserAuthorizationDetails(String LoginId) {
		return sessionFactory.getCurrentSession().createQuery("from UserAuthorizationModel where loginId=:loginId").setString("loginId", LoginId).list();
	}

}
