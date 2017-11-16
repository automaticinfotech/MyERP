package com.aits.myerp.dao;

import java.util.List;

import com.aits.myerp.model.UserAuthorizationModel;

public interface UserAuthorizationDao {

	public Boolean setAuthorities(List<UserAuthorizationModel> userAuthorizationModelList);
	public List<UserAuthorizationModel> getUserAuthorizationDetails(String LoginId);
	public Integer removeAuthorities(String loginId);
}
