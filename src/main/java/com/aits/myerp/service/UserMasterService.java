package com.aits.myerp.service;

import java.util.List;

import com.aits.myerp.dto.UserMasterDto;

public interface UserMasterService {

	public String createUser(UserMasterDto userMasterDto);
	public List<UserMasterDto> getUserDetailsList();
}
