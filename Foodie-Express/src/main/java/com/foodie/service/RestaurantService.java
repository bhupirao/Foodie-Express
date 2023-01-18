package com.foodie.service;

import java.util.List;

import com.foodie.exception.RestaurantException;
import com.foodie.model.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException;
	public Restaurant updateRestaurant(Integer restaurantId) throws RestaurantException;
	public Restaurant removeRestaurant(Integer restaurantId) throws RestaurantException;
	public Restaurant viewRestaurant(Integer restaurantId) throws RestaurantException;
	public List<Restaurant> viewNearByRestaurant(String location) throws RestaurantException;
	public List<Restaurant> viewRestaurantByItemName(String name) throws RestaurantException;
}
