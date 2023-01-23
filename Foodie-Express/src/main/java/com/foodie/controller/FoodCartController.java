package com.foodie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.foodie.exception.FoodCartException;
import com.foodie.exception.ItemException;
import com.foodie.exception.LoginException;
import com.foodie.model.FoodCart;
import com.foodie.service.CartService;

@RestController
public class FoodCartController {
	
	@Autowired
	private CartService cartService;
	

	@PostMapping("/addCart/{itemId}")
	public ResponseEntity<FoodCart> addItemInCartHandler(  @RequestBody FoodCart cart,@PathVariable("itemId") Integer itemId) throws FoodCartException, ItemException{
		
		FoodCart cartS=cartService.addItemToCart(cart, itemId);
		
		return new ResponseEntity<FoodCart> (cartS,HttpStatus.CREATED);
		
		
	}
	@PutMapping("/increaseQuantity")
	public ResponseEntity<FoodCart> increaseQuantityHandler(@RequestBody  FoodCart cart,@RequestParam Integer itemId,@RequestParam Integer quantity)throws ItemException, FoodCartException {
		
		FoodCart foodCart = cartService.increaseQuantity(cart, itemId, quantity);
		
		return new ResponseEntity<FoodCart>(foodCart, HttpStatus.OK);
	}

	@PutMapping("/reduceQuantity")
	public ResponseEntity<FoodCart> reduceQuantityHandler(@RequestBody  FoodCart cart,@RequestParam Integer itemId,@RequestParam Integer quantity)throws ItemException, FoodCartException {
		
		FoodCart foodCart = cartService.increaseQuantity(cart, itemId, quantity);
		
		return new ResponseEntity<FoodCart>(foodCart, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteIitem")
	public ResponseEntity<FoodCart> removeItemHandler(@RequestBody FoodCart cart,@RequestParam Integer itemId,@RequestParam String key)throws ItemException, FoodCartException, LoginException {
		
		FoodCart removeItem = cartService.removeItem(cart, itemId,key);
		
		return new ResponseEntity<FoodCart>(removeItem, HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteCart")
	public ResponseEntity<FoodCart> clearCartHandler(@RequestBody FoodCart cart, @RequestParam String key) throws FoodCartException, LoginException {
		
		FoodCart clearCart =cartService.clearCart(cart,key);
		
		return new ResponseEntity<FoodCart>(clearCart, HttpStatus.OK);
	}

}
