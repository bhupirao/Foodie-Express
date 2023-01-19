package com.foodie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.FoodCartException;
import com.foodie.model.FoodCart;
import com.foodie.model.Items;
import com.foodie.repository.FoodCartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private FoodCartRepository foodCartRepository;

	@Override
	public FoodCart addItemToCart(FoodCart cart, Items item) throws FoodCartException {
//		
//		Optional<FoodCart> foodCart=foodCartRepository.findById(cart);
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public FoodCart increaseQuantity(FoodCart cart, Items item, Integer quantity) throws FoodCartException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart reduceQunatity(FoodCart cart, Items item, Integer quantity) throws FoodCartException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart removeItem(FoodCart cart, Items item) throws FoodCartException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart clearCart(FoodCart cart) throws FoodCartException {
		// TODO Auto-generated method stub
		return null;
	}

}
