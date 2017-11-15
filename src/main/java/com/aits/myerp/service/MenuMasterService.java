package com.aits.myerp.service;

import java.util.List;

import com.aits.myerp.dto.MenuMasterDto;

public interface MenuMasterService {

	public String createMenu(List<MenuMasterDto> menuMasterDtoList);
	public List<MenuMasterDto> getMenuMasterList();
}
