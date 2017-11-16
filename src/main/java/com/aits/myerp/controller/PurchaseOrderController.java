package com.aits.myerp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	public String allPurchaseOrderPage(Model model)
	{



		List purchaseDetailsList=purchaseOrderService.getAllPurchaseDetails();

		model.addAttribute("purchaseDetailsList", purchaseDetailsList);
		return pagePrefix+allPurchaseOrdersPage;

	}


	@RequestMapping(value="newPurchaseOrder",method=RequestMethod.GET)
	public String newPurchaseOrderPage(Model model)
	{


		/*List<VendorMst> venderList=purchaseOrderService.getAllVenderList();*/

		List<VendorMst> venderList=purchaseOrderService.getAllVenderList();
		List<MaterialMst> materialList=purchaseOrderService.getAllMaterialList();
		List salesOrderDocumentList=purchaseOrderService.getSalesOrderDocumentList();

		model.addAttribute("venderList", venderList);
		model.addAttribute("materialList", materialList);
		model.addAttribute("salesOrderDocumentNoList", salesOrderDocumentList);

		model.addAttribute("purchaseOrderDetails", new PurchaseOrderDetails());

		return pagePrefix+newPurchaseOrderPage;

	}

	@RequestMapping(value="insertPurchOrd",method=RequestMethod.POST)
	public String insertPurchaseOrder(@ModelAttribute("purchaseOrderDetails")PurchaseOrderDetails purchaseOrderDetails,Model model,HttpSession session)
	{

		VendorMst vendorMst=new VendorMst();
		vendorMst.setVendorId(purchaseOrderDetails.getPurchaseOrderHeader().getVendorMst().getVendorId());



		PurchaseOrderHeader purchaseOrderHeader=new PurchaseOrderHeader();


		String documentNo="PR/"+"2017/"+purchaseOrderDetails.getPurchaseOrderHeader().getDocumentNo();


		purchaseOrderHeader.setDocumentNo(documentNo);
		purchaseOrderHeader.setDocumentDate(purchaseOrderDetails.getPurchaseOrderHeader().getDocumentDate());
		purchaseOrderHeader.setNotes(purchaseOrderDetails.getPurchaseOrderHeader().getNotes());
		purchaseOrderHeader.setRefDocNo(purchaseOrderDetails.getPurchaseOrderHeader().getRefDocNo());
		purchaseOrderHeader.setRefDocDate(purchaseOrderDetails.getPurchaseOrderHeader().getRefDocDate());
		purchaseOrderHeader.setVendorMst(vendorMst);


		MaterialMst materialMst=new MaterialMst();
		materialMst.setMaterialId(purchaseOrderDetails.getMaterialMst().getMaterialId());


		PurchaseOrderDetails pOrderDetails=new PurchaseOrderDetails();
		pOrderDetails.setExpDeliveryDate(purchaseOrderDetails.getExpDeliveryDate());
		pOrderDetails.setMaterialMst(materialMst);
		pOrderDetails.setNotes(purchaseOrderDetails.getNotes());
		pOrderDetails.setQuantity(purchaseOrderDetails.getQuantity());
		pOrderDetails.setRate(purchaseOrderDetails.getRate());


		pOrderDetails.setPurchaseOrderHeader(purchaseOrderHeader);

		
		purchaseOrderService.savePurchaseOrder(pOrderDetails);

		purchaseOrderDetailsList.add(purchaseOrderDetails);
		
		session.setAttribute("purchaseOrderDetailsList", purchaseOrderDetailsList);
		
		List<VendorMst> venderList=purchaseOrderService.getAllVenderList();
		List<MaterialMst> materialList=purchaseOrderService.getAllMaterialList();
		List salesOrderDocumentList=purchaseOrderService.getSalesOrderDocumentList();

		model.addAttribute("venderList", venderList);
		model.addAttribute("materialList", materialList);
		model.addAttribute("salesOrderDocumentNoList", salesOrderDocumentList);
		model.addAttribute("purchaseOrderDetails", purchaseOrderDetails);
		model.addAttribute("successMessage","Inserted successfully the purchase order...");
		
		
		return pagePrefix+newPurchaseOrderPage;

	}




	@RequestMapping(value="savePurchOrd",method=RequestMethod.GET)
	public String savePurchaseOrder(Model model)
	{
		

		List purchaseDetailsList=purchaseOrderService.getAllPurchaseDetails();

		model.addAttribute("purchaseDetailsList", purchaseDetailsList);
		model.addAttribute("successMessage","Purchase Order saved successfully.....");
		
		return pagePrefix+allPurchaseOrdersPage;

	}
	
	@RequestMapping(value="deletePurchaseOrder",method=RequestMethod.GET)
	public String deletePurchaseOrder(Model model)
	{
		
		
		
		
		
		
		
		
		
		
		List purchaseDetailsList=purchaseOrderService.getAllPurchaseDetails();

		model.addAttribute("purchaseDetailsList", purchaseDetailsList);
		model.addAttribute("successMessage1","Purchase Order saved successfully.....");
		
		return pagePrefix+allPurchaseOrdersPage;

	}
	
	
	
	
	







}
