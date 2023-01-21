package com.foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.exception.FoodCartException;
import com.foodie.exception.OrderException;
import com.foodie.model.OrderDetails;
import com.foodie.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderservice;
	
	
	
	@PostMapping("/placeorder/{cartId}/{uniqueId}")
	public ResponseEntity<OrderDetails> addOrder(@PathVariable("cartId") Integer cartId,@PathVariable("uniqueId") String uniqueId) throws OrderException, FoodCartException {
		OrderDetails orderDetails = orderservice.addOrder(cartId, uniqueId);

		return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);

	}
	
	
}
