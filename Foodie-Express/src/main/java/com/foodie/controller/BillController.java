package com.foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.foodie.exception.BillException;
import com.foodie.exception.LoginException;
import com.foodie.model.Bill;
import com.foodie.service.BillService;

@RestController
public class BillController {

	
	@Autowired
	public BillService bService;

	@PostMapping("/addBill/{orderId}/{uniqueId}")
	public ResponseEntity<Bill> addBill(@PathVariable("orderId") Integer orderId,
			@PathVariable("uniqueId") String uniqueId) throws BillException, LoginException
	{

		Bill savedBill = bService.addBill(orderId, uniqueId);

		return new ResponseEntity<Bill>(savedBill, HttpStatus.CREATED);

	}	
	
	
	@DeleteMapping("/dbills/{id}")
	 public ResponseEntity<Bill>  removeBillHandler(@PathVariable("id") Integer BillId,@RequestParam String key) throws BillException, LoginException{ 
		 
		 Bill deletedbill = bService.removeBill(BillId,key);
		 return new ResponseEntity<Bill>(deletedbill, HttpStatus.OK);
	 }
	
	
	
	  @GetMapping("/bills/{id}")
	 public ResponseEntity<Bill> viewBillHandler(@PathVariable("id") Integer billId) throws BillException{ 
		 Bill bill = bService.viewBill(billId);
		 return new ResponseEntity<Bill>(bill,HttpStatus.OK);
	 }
	  
	  
		
	 @PutMapping("/bills")
	 public ResponseEntity<Bill>updateBillHandler(@RequestBody Bill  bill,@RequestParam String key) throws BillException, LoginException{ 
		 Bill updatedbill = bService.updateBill(bill,key);
		 return new ResponseEntity<Bill>(updatedbill,HttpStatus.ACCEPTED);
	 } 

	 
	 
	  @GetMapping("/billamount")
		 public ResponseEntity<Double> viewTotalAmount(@RequestParam Integer billId) throws BillException{ 
		            Double totalAmount = bService.calculateTotalCost(billId);
			 return new ResponseEntity<Double>(totalAmount,HttpStatus.OK);
		 }
		 
			
}
