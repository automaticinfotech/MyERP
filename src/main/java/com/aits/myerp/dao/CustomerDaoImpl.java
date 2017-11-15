package com.aits.myerp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aits.myerp.model.CustomerMst;
import com.aits.myerp.model.VendorMst;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<CustomerMst> getAllCustomer() {
		return sessionFactory.getCurrentSession().createQuery("from CustomerMst where isActive = 'on' ").list();
	}

	@Override
	public boolean addCustomer(CustomerMst customerMst) {
		sessionFactory.getCurrentSession().saveOrUpdate(customerMst);
		return true;
	}

	@Override
	public CustomerMst getCustomerById(CustomerMst customerMst) {
		Session session = sessionFactory.getCurrentSession();
		CustomerMst customer =(CustomerMst)session.get(CustomerMst.class, customerMst.getCustomerId());
		return customer;
	}

	@Override
	public boolean updateCustomer(CustomerMst customerMst) {
		boolean flag= true;
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customerMst);
		return flag;
	}

	@Override
	public boolean deleteCustomer(CustomerMst customerMst) {
		boolean flag = true;
		Session session = sessionFactory.getCurrentSession();
		CustomerMst customer =(CustomerMst)session.get(CustomerMst.class, customerMst.getCustomerId());
		customer.setIsActive("I");
		session.saveOrUpdate(customer);
		return flag;
	}

}
