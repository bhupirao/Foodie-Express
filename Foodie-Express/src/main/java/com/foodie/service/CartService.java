package com.foodie.service;

import com.foodie.exception.FoodCartException;
import com.foodie.exception.ItemException;
import com.foodie.model.FoodCart;
import com.foodie.model.Items;

public interface CartService {

	

	public FoodCart addItemToCart(FoodCart cart,Integer itemId)throws FoodCartException, ItemException;
	
	public FoodCart increaseQuantity(FoodCart cart,Integer itemId,Integer quantity)throws FoodCartException, ItemException;
	
	public FoodCart reduceQunatity(FoodCart cart,Integer itemId,Integer quantity)throws FoodCartException, ItemException;
	
	public FoodCart removeItem(FoodCart cart,Integer itemId)throws FoodCartException, ItemException;
	
	public FoodCart  clearCart(FoodCart cart)throws FoodCartException;
}
