package com.foodie.service;

import com.foodie.exception.FoodCartException;
import com.foodie.exception.ItemException;
import com.foodie.model.FoodCart;
import com.foodie.model.Items;

public interface CartService {

	
	public FoodCart addItemToCart(FoodCart cart, Items item)throws FoodCartException, ItemException;
	
	public FoodCart increaseQuantity(FoodCart cart,Items item,Integer quantity)throws FoodCartException, ItemException;
	
	public FoodCart reduceQunatity(FoodCart cart,Items item,Integer quantity)throws FoodCartException, ItemException;
	
	public FoodCart removeItem(FoodCart cart,Items item)throws FoodCartException, ItemException;
	
	public FoodCart  clearCart(FoodCart cart)throws FoodCartException;
}
