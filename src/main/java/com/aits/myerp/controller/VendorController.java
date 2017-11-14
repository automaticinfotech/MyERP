package com.aits.myerp.controller;

import java.util.ArrayList;
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

@Controller
public class VendorController implements appConstant 
{
	@Autowired
	private VendorServices vendorService;
	
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
		
		
		String vendorCode = "2017/Vo/";
		model.addObject("vendorCode", vendorCode);
		
		model.addObject("listVendor", listVendor);
		model.setViewName("MasterPages/createUpdateVendor");
		return model;
	}
	
	@RequestMapping(value=INSERT_VENDOR, method = RequestMethod.POST)
	public ModelAndView insertVendor(@ModelAttribute VendorMst vendor) {
		
	
		
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

}
