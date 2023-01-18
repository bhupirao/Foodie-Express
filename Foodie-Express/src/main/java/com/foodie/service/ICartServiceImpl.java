package com.foodie.service;

import org.springframework.stereotype.Service;

import com.foodie.exception.FoodCartException;
import com.foodie.model.FoodCart;

@Service
public class ICartServiceImpl implements ICartService{

	@Override
	public FoodCart clearCart(FoodCart cart) throws FoodCartException {
		// TODO Auto-generated method stub
		return null;
	}

}
