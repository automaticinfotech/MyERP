package com.aits.myerp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aits.myerp.constant.appConstant;
import com.aits.myerp.model.MaterialMst;
import com.aits.myerp.model.VendorMst;
import com.aits.myerp.service.MaterialService;
import com.aits.myerp.service.VendorServices;

@Controller
public class MaterialController implements appConstant {
	
	@Autowired
	private MaterialService materialService; 
	
	@RequestMapping(value=LIST_OF_MATERIAL, method = RequestMethod.GET)
	public ModelAndView listOfMaterial() {
		ModelAndView model = new  ModelAndView();
		List<MaterialMst> listMaterial = materialService.getAllMaterail();
		model.addObject("listMaterial", listMaterial);
		model.setViewName("MasterPages/listMaterial");
		return model;
	}

}
