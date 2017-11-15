package com.aits.myerp.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aits.myerp.model.MaterialMst;
import com.aits.myerp.model.PurchaseOrderDetails;
import com.aits.myerp.model.VendorMst;


@Repository
@Transactional
public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	
	@Override
	public void savePurchaseOrder(PurchaseOrderDetails pOrderDetails) {
		// TODO Auto-generated method stub
         
		Session session = sessionFactory.openSession();
		
		Integer primaryKey = (Integer) session.save(pOrderDetails);
		
		
          
          
          
       
          
           
	}



	@Override
	public List<VendorMst> getAllVenderList() {
		// TODO Auto-generated method stub
		
		String hql = "FROM VendorMst V WHERE V.isAcive ='on'";
		Session session=sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		List VendorMstList=query.list();
		
		System.out.println(VendorMstList);
		
		return VendorMstList;
	}



	@Override
	public List<MaterialMst> getAllMaterialList() {
		
		
		String hql = "FROM MaterialMst m WHERE m.isActive ='on'";
		Session session=sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		List<MaterialMst> MaterialMstList=query.list();
		
		System.out.println(MaterialMstList);
		
		return MaterialMstList;
	}
	
	
	
}
