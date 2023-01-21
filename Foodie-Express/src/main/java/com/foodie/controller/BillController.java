package com.foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodie.exception.BillException;
import com.foodie.model.Bill;
import com.foodie.service.BillService;

public class BillController {

	
	@Autowired
	public BillService bService;

	@PostMapping("/addBill/{orderId}/{uniqueId}")
	public ResponseEntity<Bill> addBill(@PathVariable("orderId") Integer orderId,
			@PathVariable("uniqueId") String uniqueId) throws BillException
	{

		Bill savedBill = bService.addBill(orderId, uniqueId);

		return new ResponseEntity<Bill>(savedBill, HttpStatus.CREATED);

	}	
	
	
	@DeleteMapping("/dbills/{id}")
	 public ResponseEntity<Bill>  removeBillHandler(@PathVariable("id") @RequestBody Integer BillId) throws BillException{ 
		 
		 Bill deletedbill = bService.removeBill(BillId);
		 return new ResponseEntity<Bill>(deletedbill, HttpStatus.OK);
	 }
	
	
	
	  @GetMapping("/bills/{id}")
	 public ResponseEntity<Bill> viewBillHandler(@PathVariable("id") Integer billId) throws BillException{ 
		 Bill bill = bService.viewBill(billId);
		 return new ResponseEntity<Bill>(bill,HttpStatus.OK);
	 }
	  
	  
		
	 @PutMapping("/bills")
	 public ResponseEntity<Bill>updateBillHandler(@RequestBody Bill  bill) throws BillException{ 
		 Bill updatedbill = bService.updateBill(bill);
		 return new ResponseEntity<Bill>(updatedbill,HttpStatus.ACCEPTED);
	 } 

	 
	 
	  @GetMapping("/billamount")
		 public ResponseEntity<Double> viewTotalAmount(@RequestParam Integer billId) throws BillException{ 
		            Double totalAmount = bService.calculateTotalCost(billId);
			 return new ResponseEntity<Double>(totalAmount,HttpStatus.OK);
		 }
		 
			
}
