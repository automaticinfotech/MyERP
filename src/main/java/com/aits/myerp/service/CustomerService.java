package com.aits.myerp.service;

import java.util.List;

import com.aits.myerp.model.CustomerMst;

public interface CustomerService {
	
	    public List<CustomerMst> getAllCustomer();
		
		public boolean addCustomer(CustomerMst customerMst);
		
		public CustomerMst getCustomerById(CustomerMst customerMst);
		
		public boolean updateCustomer(CustomerMst customerMst);
		
		public boolean deleteCustomer(CustomerMst customerMst);

}
