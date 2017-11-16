package com.aits.myerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aits.myerp.dao.UserAuthorizationDao;
import com.aits.myerp.dao.UserMasterDao;
import com.aits.myerp.dto.UserMasterDto;
import com.aits.myerp.model.UserAuthorizationModel;
import com.aits.myerp.model.UserMasterModel;
import com.aits.myerp.service.UserMasterService;

@Service
@Transactional
public class UserMasterServiceImpl implements UserMasterService{
	
	@Autowired
	UserMasterDao userMasterDao; 
	@Autowired
	UserAuthorizationDao userAuthorizationDao;
	
	@Override
	public String createUser(UserMasterDto userMasterDto) {
		UserMasterModel userMasterModel=new UserMasterModel();
		userMasterModel.setLoginid(userMasterDto.getLoginid());
		userMasterModel.setPassword(userMasterDto.getPassword());
		userMasterModel.setEmail(userMasterDto.getEmail());
		userMasterModel.setIsActive(userMasterDto.getIsActive());
		
		List<UserAuthorizationModel> userAuthorizationModelList=new ArrayList<>();
		for(String currentRole : userMasterDto.getRoles()){
			UserAuthorizationModel userAuthorizationModel=new UserAuthorizationModel();
			userAuthorizationModel.setLoginId(userMasterDto.getLoginid());
			userAuthorizationModel.setRole(currentRole);
			userAuthorizationModelList.add(userAuthorizationModel);
		}

		if(userMasterDao.createUser(userMasterModel))
			if(userAuthorizationDao.setAuthorities(userAuthorizationModelList))
				return "User Created";
		return "User Creation Failed";
	}

	@Override
	public List<UserMasterDto> getUserDetailsList() {
		List<UserMasterModel> userMasterModelList = userMasterDao.getUserDetails();
		List<UserMasterDto> userMasterDtoList=new ArrayList<>();
		for(UserMasterModel currentUserMasterModel : userMasterModelList){
			UserMasterDto userMasterDto=new UserMasterDto();
			userMasterDto.setUserid(currentUserMasterModel.getUserid());
			userMasterDto.setLoginid(currentUserMasterModel.getLoginid());
			userMasterDto.setEmail(currentUserMasterModel.getEmail());
			userMasterDto.setIsActive(currentUserMasterModel.getIsActive());
			List<UserAuthorizationModel> userAuthorizationModelList = userAuthorizationDao.getUserAuthorizationDetails(currentUserMasterModel.getLoginid());
			String[] roles=new String[userAuthorizationModelList.size()];
			int index=0;
			for(UserAuthorizationModel currentRole : userAuthorizationModelList){
				roles[index++]=currentRole.getRole();
			}
			userMasterDto.setRoles(roles);
			userMasterDtoList.add(userMasterDto);
		}
		for(UserMasterDto dto:userMasterDtoList){
			System.out.println(dto);
		}
		return userMasterDtoList;
	}

}
