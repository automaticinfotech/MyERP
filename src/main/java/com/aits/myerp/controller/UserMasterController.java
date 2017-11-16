package com.aits.myerp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aits.myerp.dto.UserMasterDto;
import com.aits.myerp.service.MenuMasterService;
import com.aits.myerp.service.UserMasterService;

@Controller
public class UserMasterController {
	
	@Autowired
	MenuMasterService menuMasterService;
	@Autowired
	UserMasterService userMasterService; 

	@RequestMapping(value="/user", method = RequestMethod.GET)
	public String userPage(ModelMap modelMap) {
		modelMap.addAttribute("userMasterDto", new UserMasterDto());
		modelMap.addAttribute("userMasterList", userMasterService.getUserDetailsList());
		return "admin/User";
	}
	
	@RequestMapping(value="/createUser", method = RequestMethod.GET)
	public String createUserPage(@ModelAttribute("userMasterDto") UserMasterDto userMasterDto ,ModelMap modelMap) {
		modelMap.addAttribute("userMasterDto", new UserMasterDto());
		modelMap.addAttribute("menuMasterList", menuMasterService.getMenuMasterList());
		return "admin/createUser";
	}
	
	@RequestMapping(value="/createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("userMasterDto") UserMasterDto userMasterDto ,ModelMap modelMap) {
		System.out.println("userid: "+userMasterDto.getUserid());
		modelMap.addAttribute("message", userMasterService.createUser(userMasterDto));
		modelMap.addAttribute("userMasterDto", new UserMasterDto());
		modelMap.addAttribute("menuMasterList", menuMasterService.getMenuMasterList());
		return "admin/createUser";
	}
	
	@RequestMapping(value="/updateUser", method = RequestMethod.GET)
	public String updateUserPage(@RequestParam("loginId") String updateLoginId,ModelMap modelMap) {
		modelMap.addAttribute("userMasterDto", userMasterService.getUserByLoginId(updateLoginId));
		modelMap.addAttribute("menuMasterList", menuMasterService.getMenuMasterList());
		return "admin/createUser";
	}
	
	@RequestMapping(value="/deleteUser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("loginId") String updateLoginId,ModelMap modelMap) {
		modelMap.addAttribute("message", userMasterService.deleteUserByLoginId(updateLoginId));
		modelMap.addAttribute("userMasterDto", new UserMasterDto());
		modelMap.addAttribute("userMasterList", userMasterService.getUserDetailsList());
		return "admin/User";
	}
}
