package com.aits.myerp.dao;

import java.util.List;

import com.aits.myerp.model.CustomerMst;

public interface CustomerDao {
	
    public List<CustomerMst> getAllCustomer();
	
	public boolean addCustomer(CustomerMst customerMst);
	
	public CustomerMst getCustomerById(CustomerMst customerMst);
	
	public boolean updateCustomer(CustomerMst customerMst);
	
	public boolean deleteCustomer(CustomerMst customerMst);

}
