package com.aits.myerp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aits.myerp.dao.MaterialDao;
import com.aits.myerp.model.MaterialMst;

@Service
public class MaterialServiceImpl implements MaterialService{
	
	@Autowired
	private MaterialDao materialDao;

	@Override
	@Transactional
	public List<MaterialMst> getAllMaterail() {
		return materialDao.getAllMaterail();
	}

}
