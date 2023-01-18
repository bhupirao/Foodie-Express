package com.foodie.service;

import com.foodie.exception.FoodCartException;
import com.foodie.model.FoodCart;

public interface ICartService {
	
//	public FoodCart addItemToCart(FoodCart cart,Item item)throws FoodCartException;
//	
//	public FoodCart increaseQuantity(FoodCart cart,Item item,Integer quantity)throws FoodCartException;
//	
//	public FoodCart reduceQunatity(FoodCart cart,Item item,Integer quantity)throws FoodCartException;
//	
//	public FoodCart removeItem(FoodCart cart,Item item)throws FoodCartException;
	
	public FoodCart  clearCart(FoodCart cart)throws FoodCartException;

}
