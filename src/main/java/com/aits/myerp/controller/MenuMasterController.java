package com.aits.myerp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aits.myerp.dto.MenuMasterDto;
import com.aits.myerp.service.MenuMasterService;

@Controller
public class MenuMasterController {
	
	@Autowired
	MenuMasterService menuMasterService;
	
	List<MenuMasterDto> menuMasterDtosList;
	Integer updateIndex;

	/*@RequestMapping(value="/menu", method = RequestMethod.GET)
	public String menuPage(ModelMap modelMap) {
		modelMap.addAttribute("menuMasterDto", new MenuMasterDto());
		modelMap.addAttribute("menuMasterList", menuMasterService.getMenuMasterList());
		return "admin/menu";
	}*/
	
	@RequestMapping(value="/dooperation", method = RequestMethod.GET)
	public String doOperation(@RequestParam("operation") String operation,@ModelAttribute("menuMasterDto") MenuMasterDto menuMasterDto, ModelMap modelMap) {
		if(operation.equals("insert")){
			modelMap.addAttribute("menuMasterDto", new MenuMasterDto());
			menuMasterDtosList.add(menuMasterDto);
		}
		else if(operation.equals("update")){
			MenuMasterDto origionalMenuMasterDto = menuMasterDtosList.get(updateIndex);
			menuMasterDtosList.remove(origionalMenuMasterDto);
			MenuMasterDto updatedMenuMasterDto = new MenuMasterDto();
			updatedMenuMasterDto.setMenuId(origionalMenuMasterDto.getMenuId());
			updatedMenuMasterDto.setMenuName(menuMasterDto.getMenuName());
			updatedMenuMasterDto.setIsActive(menuMasterDto.getIsActive());
			menuMasterDtosList.add(updatedMenuMasterDto);
		}else if (operation.equals("delete")) {
			MenuMasterDto origionalMenuMasterDto = menuMasterDtosList.get(updateIndex);
			menuMasterDtosList.remove(origionalMenuMasterDto);
			modelMap.addAttribute("menuMasterDto", new MenuMasterDto());
		}
			
		modelMap.addAttribute("menuMasterList", menuMasterDtosList);
		return "admin/menu";
	}
	
	@RequestMapping(value="/updateMenu", method = RequestMethod.GET)
	public String updateMenuPage(@RequestParam("index") Integer updateIndex, ModelMap modelMap) {
		MenuMasterDto wantToUpdate = menuMasterDtosList.get(updateIndex);
		this.updateIndex=updateIndex;
		modelMap.addAttribute("menuMasterDto", wantToUpdate);
		modelMap.addAttribute("menuMasterList", menuMasterDtosList);
		return "admin/menu";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createMenuPage(ModelMap modelMap) {
		modelMap.addAttribute("message", menuMasterService.createMenu(menuMasterDtosList));
		menuMasterDtosList=menuMasterService.getMenuMasterList();
		modelMap.addAttribute("menuMasterDto", new MenuMasterDto());
		modelMap.addAttribute("menuMasterList", menuMasterDtosList);
		return "admin/menu";
	}
	
	@RequestMapping(value="/menu", method = RequestMethod.GET)
	public String menuPage(ModelMap modelMap) {
		menuMasterDtosList = menuMasterService.getMenuMasterList();
		modelMap.addAttribute("menuMasterDto", new MenuMasterDto());
		modelMap.addAttribute("menuMasterList", menuMasterDtosList);
		return "admin/menu";
	}
}
