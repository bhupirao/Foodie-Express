package com.foodie.service;

import com.foodie.exception.FoodCartException;
import com.foodie.model.FoodCart;
import com.foodie.model.Items;

public interface CartService {

	
	public FoodCart addItemToCart(FoodCart cart,Items item)throws FoodCartException;
	
	public FoodCart increaseQuantity(FoodCart cart,Items item,Integer quantity)throws FoodCartException;
	
	public FoodCart reduceQunatity(FoodCart cart,Items item,Integer quantity)throws FoodCartException;
	
	public FoodCart removeItem(FoodCart cart,Items item)throws FoodCartException;
	
	public FoodCart  clearCart(FoodCart cart)throws FoodCartException;
}
