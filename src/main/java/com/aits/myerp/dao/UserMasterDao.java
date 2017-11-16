package com.aits.myerp.dao;

import java.util.List;

import com.aits.myerp.model.UserMasterModel;

public interface UserMasterDao {
	
	public Boolean createUser(UserMasterModel userMasterModel);
	public List<UserMasterModel> getUserDetails();
	public UserMasterModel getUserByLoginId(String loginId);
	public Boolean removeUser(String loginId);
}
