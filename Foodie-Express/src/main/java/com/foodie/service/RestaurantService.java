package com.foodie.service;

import java.util.List;

import com.foodie.exception.RestaurantException;
import com.foodie.model.Address;
import com.foodie.model.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException;
	public Restaurant updateRestaurant(Restaurant res) throws RestaurantException;
	public Restaurant removeRestaurant(Integer id) throws RestaurantException;
	public Restaurant viewRestaurant(Integer id) throws RestaurantException;
	
	public List<Restaurant> viewNearByRestaurant(Address location) throws RestaurantException;
	public List<Restaurant> viewRestaurantByItemName(String name) throws RestaurantException;
}
