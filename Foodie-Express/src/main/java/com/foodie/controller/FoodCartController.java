package com.foodie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.model.FoodCart;

import com.foodie.model.Items;
import com.foodie.repository.ItemRepository;
import com.foodie.service.CartService;

@RestController
public class FoodCartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemRepository itemRepository;
	
	

	@PostMapping("/addCart/{itemId}")
	public ResponseEntity<FoodCart> addItemInCartHandler(  @RequestBody FoodCart cart,@PathVariable("itemId") Integer itemId) throws FoodCartException, ItemException{
		
		FoodCart cartS=cartService.addItemToCart(cart, itemId);
		
		return new ResponseEntity<FoodCart> (cartS,HttpStatus.CREATED);
		
		
		
		
	}

	

}
