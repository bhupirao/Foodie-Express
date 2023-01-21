package com.foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.model.FoodCart;
import com.foodie.service.CartService;

@RestController
public class FoodCartController {
	
	@Autowired
	private CartService cartService;
	
	
	

}
