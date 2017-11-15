package com.aits.myerp.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aits.myerp.constant.appConstant;
import com.aits.myerp.model.CustomerMst;
import com.aits.myerp.model.VendorMst;
import com.aits.myerp.service.CustomerService;
import com.aits.myerp.service.VendorServices;

@Controller
public class CustomerController implements appConstant{
	
	@Autowired
	private CustomerService customerService; 
	
	@RequestMapping(value=LIST_OF_CUSTOMER, method = RequestMethod.GET)
	public ModelAndView listOfVendor() {
		ModelAndView model = new  ModelAndView();
		List<CustomerMst> listCustomerMst = customerService.getAllCustomer();
		model.addObject("listCustomerMst", listCustomerMst);
		model.setViewName("MasterPages/listCustomer");
		return model;
	}
	
	@RequestMapping(value=CREATE_CUSTOMER, method = RequestMethod.GET)
	public ModelAndView createCustomer(@ModelAttribute CustomerMst customerMst) {
		ModelAndView model = new  ModelAndView();
		List<CustomerMst> listCustomerMst = new ArrayList<CustomerMst>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String customerCode = year+"/Cust/";
		model.addObject("customerCode", customerCode);
		model.addObject("listCustomerMst", listCustomerMst);
		model.setViewName("MasterPages/createUpdateCustomer");
		return model;
	}
	
	@RequestMapping(value=INSERT_CUSTOMER, method = RequestMethod.POST)
	public ModelAndView insertCustomer(@ModelAttribute CustomerMst customerMst) {
		
	
		customerMst.setIsActive("A");
		ModelAndView model = new  ModelAndView();
		if(customerService.addCustomer(customerMst))
		{
			model.addObject("Status", "Added Successfully..!");
		}
		else
		{
			model.addObject("Status", "Something went wrong..!");
		}
		
		List<CustomerMst> listCustomerMst = customerService.getAllCustomer();
		model.addObject("listCustomerMst", listCustomerMst);
		model.setViewName("MasterPages/listCustomer");
		return model;
	}
	
	@RequestMapping(value=GET_CUSTOMER_BY_ID, method = RequestMethod.GET)
	public ModelAndView getVendorById(@ModelAttribute CustomerMst customerMst) {
		ModelAndView model = new  ModelAndView();
		
		List<CustomerMst> listCustomerMst = new ArrayList<CustomerMst>();
		CustomerMst customer= customerService.getCustomerById(customerMst);
		listCustomerMst.add(customer);
		model.addObject("listCustomerMst", listCustomerMst);
		model.setViewName("MasterPages/createUpdateCustomer");
		return model;
	}
	
	
	@RequestMapping(value=UPDATE_CUSTOMER, method = RequestMethod.POST)
	public ModelAndView updateVendor(@ModelAttribute CustomerMst customerMst) {
		ModelAndView model = new  ModelAndView();
		if(customerService.updateCustomer(customerMst))
		{
			model.addObject("Status", "Updated Successfully..!");
		}
		else
		{
			model.addObject("Status", "Something went wrong..!");
		}
		
		List<CustomerMst> listCustomerMst = customerService.getAllCustomer();
		model.addObject("listCustomerMst", listCustomerMst);
		model.setViewName("MasterPages/listCustomer");
		return model;
	}
	
	@RequestMapping(value=DELETE_CUSTOMER, method = RequestMethod.GET)
	public ModelAndView deleteVendor(@ModelAttribute CustomerMst customerMst) {
		ModelAndView model = new  ModelAndView();
		if(customerService.deleteCustomer(customerMst))
		{
			model.addObject("Status", "Deleted Successfully..!");
		}
		else
		{
			model.addObject("Status", "Something went wrong..!");
		}
		
		List<CustomerMst> listCustomerMst = customerService.getAllCustomer();
		model.addObject("listCustomerMst", listCustomerMst);
		model.setViewName("MasterPages/listCustomer");
		return model;
	}

}
