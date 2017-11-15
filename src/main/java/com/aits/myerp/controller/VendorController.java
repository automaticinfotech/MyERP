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
import com.aits.myerp.model.VendorMst;
import com.aits.myerp.service.VendorServices;
import com.aits.myerp.util.CodeGenrator;

@Controller
public class VendorController implements appConstant 
{
	@Autowired
	private VendorServices vendorService; 
	
	@Autowired
	private CodeGenrator codeGenrator;
	
	@RequestMapping(value=LIST_OF_VENDOR, method = RequestMethod.GET)
	public ModelAndView listOfVendor() {
		ModelAndView model = new  ModelAndView();
		List<VendorMst> listVendor = vendorService.getAllVendor();
		model.addObject("listVendor", listVendor);
		model.setViewName("MasterPages/listVendor");
		return model;
	}
	
	@RequestMapping(value=CREATE_VENDOR, method = RequestMethod.GET)
	public ModelAndView createVendor(@ModelAttribute VendorMst vendor) {
		ModelAndView model = new  ModelAndView();
		List<VendorMst> listVendor = new ArrayList<VendorMst>();
		String vendorCode = VENDOR_CODE+codeGenrator.getCurrentYear()+codeGenrator.getRandomNumber(9999, 1111);
		model.addObject("vendorCode", vendorCode);
		model.addObject("listVendor", listVendor);
		model.setViewName("MasterPages/createUpdateVendor");
		return model;
	}
	
	@RequestMapping(value=INSERT_VENDOR, method = RequestMethod.POST)
	public ModelAndView insertVendor(@ModelAttribute VendorMst vendor) {
		
	
		System.out.println("++++++++++++++++++++++++++++"+vendor.getIsAcive());
		ModelAndView model = new  ModelAndView();
		if(vendorService.addVendor(vendor))
		{
			model.addObject("Status", "Added Successfully..!");
		}
		else
		{
			model.addObject("Status", "Something went wrong..!");
		}
		
		List<VendorMst> listVendor = vendorService.getAllVendor();
		model.addObject("listVendor", listVendor);
		model.setViewName("MasterPages/listVendor");
		return model;
	}
	
	@RequestMapping(value=GET_VENDOR_BY_ID, method = RequestMethod.GET)
	public ModelAndView getVendorById(@ModelAttribute VendorMst vendor) {
		ModelAndView model = new  ModelAndView();
		
		List<VendorMst> listVendor = new ArrayList<VendorMst>();
		VendorMst vendorMst= vendorService.getVendorById(vendor);
		listVendor.add(vendorMst);
		model.addObject("listVendor", listVendor);
		model.setViewName("MasterPages/createUpdateVendor");
		return model;
	}
	
	
	@RequestMapping(value=UPDATE_VENDOR, method = RequestMethod.POST)
	public ModelAndView updateVendor(@ModelAttribute VendorMst vendor) {
		
		ModelAndView model = new  ModelAndView();
		if(vendorService.updateVendor(vendor))
		{
			model.addObject("Status", "Updated Successfully..!");
		}
		else
		{
			model.addObject("Status", "Something went wrong..!");
		}
		
		List<VendorMst> listVendor = vendorService.getAllVendor();
		model.addObject("listVendor", listVendor);
		model.setViewName("MasterPages/listVendor");
		return model;
	}
	
	@RequestMapping(value=DELETE_VENDOR, method = RequestMethod.GET)
	public ModelAndView deleteVendor(@ModelAttribute VendorMst vendor) {
		ModelAndView model = new  ModelAndView();
		if(vendorService.deleteVendor(vendor))
		{
			model.addObject("Status", "Deleted Successfully..!");
		}
		else
		{
			model.addObject("Status", "Something went wrong..!");
		}
		
		List<VendorMst> listVendor = vendorService.getAllVendor();
		model.addObject("listVendor", listVendor);
		model.setViewName("MasterPages/listVendor");
		return model;
	}

	
}
