package com.aits.myerp.service;

import java.util.List;

import com.aits.myerp.model.MaterialMst;
import com.aits.myerp.model.VendorMst;

public interface MaterialService {
	
	public List<MaterialMst> getAllMaterail();
	
	public List<MaterialMst> getActiveMaterail();
	
    public boolean addMaterial(MaterialMst materialMst);
	
	public MaterialMst getMaterialById(MaterialMst materialMst);
	
	public boolean updateMaterial(MaterialMst materialMst);
	
	public boolean deleteMaterial(MaterialMst materialMst);

}
