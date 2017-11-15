package com.aits.myerp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aits.myerp.dao.PurchaseOrderDAO;
import com.aits.myerp.model.MaterialMst;
import com.aits.myerp.model.PurchaseOrderDetails;
import com.aits.myerp.model.PurchaseOrderHeader;
import com.aits.myerp.model.VendorMst;
import com.aits.myerp.service.PurchaseOrderService;

@Controller
public class PurchaseOrderController {


	//pages
	private final String pagePrefix="POPages/";
	private String allPurchaseOrdersPage="allPurchaseOrders";
	private String newPurchaseOrderPage="newPurchaseOrder";
	
	ArrayList<PurchaseOrderDetails> purchaseOrderDetailsList =new ArrayList<PurchaseOrderDetails>();;
	


	@Autowired
	private PurchaseOrderService purchaseOrderService; 

	@RequestMapping(value="allPurchaseOrders",method=RequestMethod.GET)
	public String allPurchaseOrderPage()
	{

		return pagePrefix+allPurchaseOrdersPage;

	}
	

	@RequestMapping(value="newPurchaseOrder",method=RequestMethod.GET)
	public String newPurchaseOrderPage(Model model)
	{

		
		/*List<VendorMst> venderList=purchaseOrderService.getAllVenderList();*/
		
		List<VendorMst> venderList=purchaseOrderService.getAllVenderList();
		List<MaterialMst> materialList=purchaseOrderService.getAllMaterialList();
			
		model.addAttribute("venderList", venderList);
		model.addAttribute("materialList", materialList);
		
		model.addAttribute("purchaseOrderDetails", new PurchaseOrderDetails());
			
		return pagePrefix+newPurchaseOrderPage;

	}
	
	@RequestMapping(value="insertPurchOrd",method=RequestMethod.POST)
	public String insertPurchaseOrder(@ModelAttribute("purchaseOrderDetails")PurchaseOrderDetails purchaseOrderDetails,Model model)
	{
		
		/*VendorMst vendorMst=new VendorMst();
		
		vendorMst.setVendorId(purchaseOrderDetails.getPurchaseOrderHeader().getVendorMst().getVendorId());
		
		
		
		PurchaseOrderHeader purchaseOrderHeader=new PurchaseOrderHeader();
		purchaseOrderHeader.setDocumentNo(purchaseOrderDetails.getPurchaseOrderHeader().getDocumentNo());
		purchaseOrderHeader.setDocumentDate(purchaseOrderDetails.getPurchaseOrderHeader().getDocumentDate());
		purchaseOrderHeader.setNotes(purchaseOrderDetails.getPurchaseOrderHeader().getNotes());
		purchaseOrderHeader.setRefDocNo(purchaseOrderDetails.getPurchaseOrderHeader().getRefDocNo());
		purchaseOrderHeader.setRefDocDate(purchaseOrderDetails.getPurchaseOrderHeader().getRefDocDate());
		purchaseOrderHeader.setVendorMst(vendorMst);
		
		//purchaseOrderHeader.setVendorMst(vendorMst);(purchaseOrderDetails.getPurchaseOrderHeader().getVendorMst().getVendorId());
		
		
		PurchaseOrderDetails pOrderDetails=new PurchaseOrderDetails();
		pOrderDetails.setExpDeliveryDate(purchaseOrderDetails.getExpDeliveryDate());
		pOrderDetails.setMaterialID(purchaseOrderDetails.getMaterialID());
		pOrderDetails.setNotes(purchaseOrderDetails.getNotes());
        pOrderDetails.setQuantity(purchaseOrderDetails.getQuantity());
        pOrderDetails.setRate(purchaseOrderDetails.getRate());
        
        		
		
		pOrderDetails.setPurchaseOrderHeader(purchaseOrderHeader);
		*/

		
		purchaseOrderDetailsList.add(purchaseOrderDetails);
		
		
		model.addAttribute("purchaseOrderDetailsList", purchaseOrderDetailsList);
		
		
		
		
		
		
		List<VendorMst> venderList=purchaseOrderService.getAllVenderList();
		List<MaterialMst> materialList=purchaseOrderService.getAllMaterialList();
			
		model.addAttribute("venderList", venderList);
		model.addAttribute("materialList", materialList);
		model.addAttribute("purchaseOrderDetails", new PurchaseOrderDetails());
		
		
		
		
		return pagePrefix+newPurchaseOrderPage;

	}
	
	
	
	
	@RequestMapping(value="savePurchOrd",method=RequestMethod.POST)
	public String savePurchaseOrder(@ModelAttribute("purchaseOrderDetails")PurchaseOrderDetails purchaseOrderDetails,Model model)
	{
/*
		System.out.println("Header=="+purchaseOrderDetails.getPurchaseOrderHeader().getDocumentNo());
		
		System.out.println("Details=="+purchaseOrderDetails.getNotes());
		
		
		PurchaseOrderHeader purchaseOrderHeader=new PurchaseOrderHeader();
		purchaseOrderHeader.setDocumentNo(purchaseOrderDetails.getPurchaseOrderHeader().getDocumentNo());
		purchaseOrderHeader.setDocumentDate(purchaseOrderDetails.getPurchaseOrderHeader().getDocumentDate());
		purchaseOrderHeader.setNotes(purchaseOrderDetails.getPurchaseOrderHeader().getNotes());
		purchaseOrderHeader.setRefDocNo(purchaseOrderDetails.getPurchaseOrderHeader().getRefDocNo());
		purchaseOrderHeader.setRefDocDate(purchaseOrderDetails.getPurchaseOrderHeader().getRefDocDate());
		//purchaseOrderHeader.setVendorID(purchaseOrderDetails.getPurchaseOrderHeader().getVendorID());
		
		
		PurchaseOrderDetails pOrderDetails=new PurchaseOrderDetails();
		pOrderDetails.setExpDeliveryDate(purchaseOrderDetails.getExpDeliveryDate());
		pOrderDetails.setMaterialID(purchaseOrderDetails.getMaterialID());
		pOrderDetails.setNotes(purchaseOrderDetails.getNotes());
        pOrderDetails.setQuantity(purchaseOrderDetails.getQuantity());
        pOrderDetails.setRate(purchaseOrderDetails.getRate());
        
        
		
		
		
		
		
		pOrderDetails.setPurchaseOrderHeader(purchaseOrderHeader);
		
		
		
		purchaseOrderService.savePurchaseOrder(pOrderDetails);
		
		
		model.addAttribute("purchaseOrderDetails", new PurchaseOrderDetails());*/
		
		return pagePrefix+allPurchaseOrdersPage;

	}
	
	
	
	

	

}
