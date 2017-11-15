package com.aits.myerp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aits.myerp.dao.CustomerDao;
import com.aits.myerp.dao.VendorDao;
import com.aits.myerp.model.CustomerMst;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<CustomerMst> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	@Override
	@Transactional
	public boolean addCustomer(CustomerMst customerMst) {
		return customerDao.addCustomer(customerMst);
	}

	@Override
	@Transactional
	public CustomerMst getCustomerById(CustomerMst customerMst) {
		return customerDao.getCustomerById(customerMst);
	}

	@Override
	@Transactional
	public boolean updateCustomer(CustomerMst customerMst) {
		return customerDao.updateCustomer(customerMst);
	}

	@Override
	@Transactional
	public boolean deleteCustomer(CustomerMst customerMst) {
		return customerDao.deleteCustomer(customerMst);
	}

}
