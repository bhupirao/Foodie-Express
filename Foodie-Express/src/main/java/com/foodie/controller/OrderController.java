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
import org.springframework.web.bind.annotation.RestController;

import com.foodie.exception.FoodCartException;
import com.foodie.exception.LoginException;
import com.foodie.exception.OrderException;
import com.foodie.model.OrderDetails;
import com.foodie.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderservice;
	
	
	
	@PostMapping("/placeorder/{cartId}/{uniqueId}")
	public ResponseEntity<OrderDetails> addOrder(@PathVariable("cartId") Integer cartId,@PathVariable("uniqueId") String uniqueId) throws OrderException, FoodCartException, LoginException {
		OrderDetails orderDetails = orderservice.addOrder(cartId, uniqueId);

		return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);

	}
	
	
	@DeleteMapping("/cancelorder/{id}")
	public ResponseEntity<OrderDetails> removeOrder(@PathVariable("id") Integer orderId,@RequestParam String key) throws OrderException, FoodCartException, LoginException {
		OrderDetails orderDetails = orderservice.removeOrder(orderId,key);

		return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);

	}
	
	

	@PutMapping("/updateorder")
	public ResponseEntity<OrderDetails> updateemployee(@RequestBody OrderDetails order,@RequestParam String key) throws OrderException, LoginException{
		
		OrderDetails updateorder = orderservice.updateOrder(order,key);
		
		return new ResponseEntity<OrderDetails>(updateorder , HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/vieworder/{id}")
	public ResponseEntity<OrderDetails> viewOrderById(@PathVariable("id") Integer orderId) throws OrderException, FoodCartException {
		OrderDetails orderDetails = orderservice.viewOrder(orderId);

		return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);

	}
	
	
	
	
}
