package com.aits.myerp.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aits.myerp.constant.PurchaseOrderAppConstant;
import com.aits.myerp.model.MaterialMst;
import com.aits.myerp.model.PurchaseOrderDetails;
import com.aits.myerp.model.PurchaseOrderHeader;
import com.aits.myerp.model.VendorMst;
import com.aits.myerp.service.PurchaseOrderService;

@Controller
public class PurchaseOrderController implements PurchaseOrderAppConstant {

	//pages
	
	ArrayList<PurchaseOrderDetails> purchaseOrderDetailsList =new ArrayList<PurchaseOrderDetails>();

	@Autowired
	private PurchaseOrderService purchaseOrderService; 

	@RequestMapping(value=ALL_PURCHASE_ORDERS,method=RequestMethod.GET)
	public String allPurchaseOrderPage(Model model)
	{
		List purchaseDetailsList=purchaseOrderService.getAllPurchaseDetails();
		model.addAttribute("purchaseDetailsList", purchaseDetailsList);
		return pagePrefix+allPurchaseOrdersPage;
	}
	@RequestMapping(value=NEW_PURCHASE_ORDERS,method=RequestMethod.GET)
	public String newPurchaseOrderPage(Model model)
	{
		List<VendorMst> venderList=purchaseOrderService.getAllVenderList();
		List<MaterialMst> materialList=purchaseOrderService.getAllMaterialList();
		List salesOrderDocumentList=purchaseOrderService.getSalesOrderDocumentList();
		model.addAttribute("venderList", venderList);
		model.addAttribute("materialList", materialList);
		model.addAttribute("salesOrderDocumentNoList", salesOrderDocumentList);
		
		PurchaseOrderDetails purchaseOrderDetails=new PurchaseOrderDetails();
		
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String todayDate=String.valueOf(dtf.format(localDate));
		
	
		
		
		model.addAttribute("purchaseOrderDetails", purchaseOrderDetails);
		return pagePrefix+newPurchaseOrderPage;

	}
	@RequestMapping(value=INSERT_PURCHASE_ORDERS,method=RequestMethod.POST)
	public String insertPurchaseOrder(@ModelAttribute("purchaseOrderDetails")PurchaseOrderDetails purchaseOrderDetails,Model model)
	{
		VendorMst vendorMst=new VendorMst();
		vendorMst.setVendorId(purchaseOrderDetails.getPurchaseOrderHeader().getVendorMst().getVendorId());
		PurchaseOrderHeader purchaseOrderHeader=new PurchaseOrderHeader();
		//String documentNo="PR/"+"2017/"+purchaseOrderDetails.getPurchaseOrderHeader().getDocumentNo();
		Random rand = new Random();
		int  n = rand.nextInt(10) + 1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String todayDate=String.valueOf(dtf.format(localDate));
		String documentNo=String.valueOf(n);
		String documentNumber="PR/"+todayDate+documentNo;
		
		purchaseOrderHeader.setDocumentNo(documentNumber);	
		purchaseOrderHeader.setDocumentDate(todayDate);
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
		List<VendorMst> venderList=purchaseOrderService.getAllVenderList();
		List<MaterialMst> materialList=purchaseOrderService.getAllMaterialList();
		List salesOrderDocumentList=purchaseOrderService.getSalesOrderDocumentList();
		model.addAttribute("venderList", venderList);
		model.addAttribute("materialList", materialList);
		model.addAttribute("salesOrderDocumentNoList", salesOrderDocumentList);
		model.addAttribute("purchaseOrderDetails", purchaseOrderDetails);
		model.addAttribute("purchaseOrderDetailsList",purchaseOrderDetailsList);
		model.addAttribute("successMessage","Inserted successfully the purchase order...");
		
		return pagePrefix+newPurchaseOrderPage;
	}
	@RequestMapping(value=SAVE_PURCHASE_ORDERS,method=RequestMethod.GET)
	public String savePurchaseOrder(Model model)
	{
		purchaseOrderDetailsList.clear();
		List purchaseDetailsList=purchaseOrderService.getAllPurchaseDetails();
		model.addAttribute("purchaseDetailsList", purchaseDetailsList);
		model.addAttribute("successMessage","Purchase Order saved successfully.....");
		return pagePrefix+allPurchaseOrdersPage;
	}
	@RequestMapping(value=DELETE_PURCHASE_ORDERS,method=RequestMethod.GET)
	public String deletePurchaseOrder(@PathVariable int poOrderNumber,Model model)
	{
		purchaseOrderService.removePurchaseOrder(poOrderNumber);
		List purchaseDetailsList=purchaseOrderService.getAllPurchaseDetails();
		model.addAttribute("purchaseDetailsList", purchaseDetailsList);
		model.addAttribute("successMessage1","Purchase Order saved successfully.....");
		return pagePrefix+allPurchaseOrdersPage;

	}

}
