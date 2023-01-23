package com.foodie.service;

import java.util.List;

import com.foodie.exception.LoginException;
import com.foodie.exception.RestaurantException;
import com.foodie.model.Address;
import com.foodie.model.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant res,String key) throws RestaurantException,LoginException;
	public Restaurant updateRestaurant(Restaurant res,String key) throws RestaurantException,LoginException;
	public Restaurant removeRestaurant(Integer id,String key) throws RestaurantException,LoginException;
	public Restaurant viewRestaurant(Integer id) throws RestaurantException;
	
	public List<Restaurant> viewAllRestaurant() throws RestaurantException;
}
