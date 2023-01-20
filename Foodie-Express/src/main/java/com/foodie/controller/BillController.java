package com.foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
}
