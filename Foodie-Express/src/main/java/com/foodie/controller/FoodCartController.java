package com.foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.exception.FoodCartException;
import com.foodie.exception.ItemException;
import com.foodie.model.FoodCart;
import com.foodie.model.Items;
import com.foodie.service.CartService;

@RestController
public class FoodCartController {
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/addCart")
	public ResponseEntity<FoodCart> addItemInCartHandler(@RequestBody FoodCart cart,@RequestBody Items item) throws FoodCartException, ItemException{
		
		FoodCart cartS=cartService.addItemToCart(cart, item);
		
		return new ResponseEntity<FoodCart> (cartS,HttpStatus.CREATED);
		
		
		
		
	}
	

}
