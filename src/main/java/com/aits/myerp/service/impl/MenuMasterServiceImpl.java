package com.aits.myerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aits.myerp.dao.MenuMasterDao;
import com.aits.myerp.dto.MenuMasterDto;
import com.aits.myerp.model.MenuMasterModel;
import com.aits.myerp.service.MenuMasterService;

@Transactional
@Service
public class MenuMasterServiceImpl implements MenuMasterService{

	@Autowired
	MenuMasterDao menuMasterDao;
	
	@Override
	public String createMenu(List<MenuMasterDto> menuMasterDtoList) {
		List<MenuMasterModel> menuMasterModelList = new ArrayList<>();
		for(MenuMasterDto currentMenuMasterDto: menuMasterDtoList){
			MenuMasterModel menuMasterModel=new MenuMasterModel();		
			menuMasterModel.setMenuId(currentMenuMasterDto.getMenuId());
			menuMasterModel.setMenuName(currentMenuMasterDto.getMenuName());
			menuMasterModel.setIsActive(currentMenuMasterDto.getIsActive());
			menuMasterModelList.add(menuMasterModel);
		}
		return (menuMasterDao.createMenu(menuMasterModelList) ? "Menu Created" : "Menu Creation Failed");
	}

	@Override
	public List<MenuMasterDto> getMenuMasterList() {
		List<MenuMasterModel> menuMasterModelList = menuMasterDao.getMenuMasterList();
		List<MenuMasterDto> menuMasterDtoList = new ArrayList<>();
		for(MenuMasterModel currentObject  : menuMasterModelList){
			MenuMasterDto menuMasterDto = new MenuMasterDto();
			menuMasterDto.setMenuId(currentObject.getMenuId());
			menuMasterDto.setMenuName(currentObject.getMenuName());
			menuMasterDto.setIsActive(currentObject.getIsActive());
			menuMasterDtoList.add(menuMasterDto);
		}
		return menuMasterDtoList;
	}
}
