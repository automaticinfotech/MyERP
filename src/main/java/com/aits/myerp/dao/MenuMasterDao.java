package com.aits.myerp.dao;

import java.util.List;

import com.aits.myerp.model.MenuMasterModel;

public interface MenuMasterDao {

	public Boolean createMenu(List<MenuMasterModel> menuMasterModelList);
	public List<MenuMasterModel> getMenuMasterList();
}
