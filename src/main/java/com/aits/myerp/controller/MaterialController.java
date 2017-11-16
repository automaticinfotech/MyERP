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
import com.aits.myerp.model.MaterialMst;
import com.aits.myerp.model.VendorMst;
import com.aits.myerp.service.MaterialService;
import com.aits.myerp.service.VendorServices;
import com.aits.myerp.util.CodeGenrator;

@Controller
public class MaterialController implements appConstant {
	
	@Autowired
	private MaterialService materialService; 
	
	@Autowired
	private CodeGenrator codeGenrator;
	
	@RequestMapping(value=LIST_OF_MATERIAL, method = RequestMethod.GET)
	public ModelAndView listOfMaterial() {
		ModelAndView model = new  ModelAndView();
		List<MaterialMst> listMaterial = materialService.getActiveMaterail();
		model.addObject("listMaterial", listMaterial);
		model.setViewName("MasterPages/listMaterial");
		return model;
	}
	
	@RequestMapping(value=CREATE_MATERIAL, method = RequestMethod.GET)
	public ModelAndView createMaterial(@ModelAttribute MaterialMst materialMst) {
		ModelAndView model = new  ModelAndView();
		List<MaterialMst> listMaterial = new ArrayList<MaterialMst>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String materialCode = VENDOR_CODE+codeGenrator.getCurrentYear()+codeGenrator.getRandomNumber(9999, 1111);
		model.addObject("materialCode", materialCode);
		model.addObject("listMaterial", listMaterial);
		model.setViewName("MasterPages/createUpdateMaterial");
		return model;
	}
	
	@RequestMapping(value=INSERT_MATERIAL, method = RequestMethod.POST)
	public ModelAndView insertMaterial(@ModelAttribute MaterialMst materialMst) {
		
		System.out.println("UOM++++++++++++++++++++++++++++++"+materialMst.getUOM());
		ModelAndView model = new  ModelAndView();
		if(materialService.addMaterial(materialMst))
		{
			model.addObject("Status", "Added Successfully..!");
		}
		else
		{
			model.addObject("Status", "Something went wrong..!");
		}
		
		List<MaterialMst> listMaterial = materialService.getActiveMaterail();
		model.addObject("listMaterial", listMaterial);
		model.setViewName("MasterPages/listMaterial");
		return model;
	}
	
	@RequestMapping(value=GET_MATERIAL_BY_ID, method = RequestMethod.GET)
	public ModelAndView getMaterialById(@ModelAttribute MaterialMst materialMst) {
		ModelAndView model = new  ModelAndView();
		
		List<MaterialMst> listMaterial = new ArrayList<MaterialMst>();
		MaterialMst material= materialService.getMaterialById(materialMst);
		listMaterial.add(material);
		model.addObject("listMaterial", listMaterial);
		model.setViewName("MasterPages/createUpdateMaterial");
		return model;
	}
	
	
	@RequestMapping(value=UPDATE_MATERIAL, method = RequestMethod.POST)
	public ModelAndView updateMaterial(@ModelAttribute MaterialMst materialMst) {
		ModelAndView model = new  ModelAndView();
		if(materialService.updateMaterial(materialMst))
		{
			model.addObject("Status", "Updated Successfully..!");
		}
		else
		{
			model.addObject("Status", "Something went wrong..!");
		}
		
		List<MaterialMst> listMaterial = materialService.getActiveMaterail();
		model.addObject("listMaterial", listMaterial);
		model.setViewName("MasterPages/listMaterial");
		return model;
	}
	
	
	@RequestMapping(value=DELETE_MATERIAL, method = RequestMethod.GET)
	public ModelAndView deleteMaterial(@ModelAttribute MaterialMst materialMst) {
		ModelAndView model = new  ModelAndView();
		if(materialService.deleteMaterial(materialMst))
		{
			model.addObject("Status", "Deleted Successfully..!");
		}
		else
		{
			model.addObject("Status", "Something went wrong..!");
		}
		
		List<MaterialMst> listMaterial = materialService.getActiveMaterail();
		model.addObject("listMaterial", listMaterial);
		model.setViewName("MasterPages/listMaterial");
		return model;
	}
	
	

}
