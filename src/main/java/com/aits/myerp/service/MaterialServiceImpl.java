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

	@Override
	@Transactional
	public List<MaterialMst> getActiveMaterail() {
		return materialDao.getActiveMaterail();
	}
	
	@Override
	@Transactional
	public boolean addMaterial(MaterialMst materialMst) {
		return materialDao.addMaterial(materialMst);
	}

	@Override
	@Transactional
	public MaterialMst getMaterialById(MaterialMst materialMst) {
		// TODO Auto-generated method stub
		return materialDao.getMaterialById(materialMst);
	}

	@Override
	@Transactional
	public boolean updateMaterial(MaterialMst materialMst) {
		// TODO Auto-generated method stub
		return materialDao.updateMaterial(materialMst);
	}

	@Override
	@Transactional
	public boolean deleteMaterial(MaterialMst materialMst) {
		// TODO Auto-generated method stub
		return materialDao.deleteMaterial(materialMst);
	}

}
