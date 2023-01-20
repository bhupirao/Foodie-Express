package com.foodie.service;

import java.util.List;

import com.foodie.exception.RestaurantException;
import com.foodie.model.Address;
import com.foodie.model.Restaurant;
import com.foodie.repository.RestaurantRepository;

public class RestaurantServiceImpl implements RestaurantService {
	
	private RestaurantRepository restaurantRepo;

	@Override
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException {
		Restaurant resto = restaurantRepo.save(res);
		
		if(resto != null)
		{
		return resto;
		}else throw new RestaurantException("Restaurant Not Added");
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant removeRestaurant(Restaurant res) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant viewRestaurant(Restaurant res) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewNearByRestaurant(Address location) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemName(String name) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

}
