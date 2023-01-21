package com.foodie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.CustomerException;
import com.foodie.exception.RestaurantException;
import com.foodie.model.Address;
import com.foodie.model.Restaurant;
import com.foodie.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
//	Restaurant Repository Access --------------------------->
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	
//	Add Restaurant Implementation ------------------------------>

	@Override
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException {
		
		Restaurant resto = restaurantRepo.save(res);
		
		if(resto != null)
		{
		return resto;
		}else throw new RestaurantException("Restaurant Not Added");
	}
	
//	Update Restaurant details Implementation ------------------------------>

	@Override
	public Restaurant updateRestaurant(Restaurant res) throws RestaurantException {
		Optional<Restaurant> opt = restaurantRepo.findById(res.getRestaurantId());
		
		if(opt.isPresent())
		{
			Restaurant updatedRestaurant = restaurantRepo.save(res);
			return updatedRestaurant;
		}else
			throw new CustomerException("There is no customer register with customer Id " + res.getRestaurantId());
	}
	
//	Remove Restaurant details Implementation ------------------------------>	

	@Override
	public Restaurant removeRestaurant(Integer id) throws RestaurantException {
		Optional<Restaurant> opt = restaurantRepo.findById(id);
		
		if(opt.isEmpty()) throw new RestaurantException("There is no Restaurant By Restaurant Id Number " + id);
		else {
		Restaurant deletedRest = opt.get();
		restaurantRepo.delete(deletedRest);
		return deletedRest;
		}
	}

//	View Restaurant details Implementation ------------------------------>	
	
	@Override
	public Restaurant viewRestaurant(Integer id) throws RestaurantException {
		Optional<Restaurant> opt = restaurantRepo.findById(id);
		
		if(opt.isEmpty()) throw new RestaurantException("There is no Restaurant By Restaurant Id Number " + id);
		else {
		Restaurant restaurant = opt.get();
		return restaurant;
		}
	}
	
//	View Near By Restaurant details Implementation ------------------------------>		

	@Override
	public List<Restaurant> viewNearByRestaurant(Address location) throws RestaurantException {
//		List<Restaurant> list = restaurantRepo.getRestaurantByLocation( location.getArea(), location.getBuildingName(), location.getCity(), location.getCountry(), location.getPincode(), location.getState(), location.getStreetNo());
//		
//		if(list.isEmpty()) throw new RestaurantException("There is no Restaurant");
//		else return list;
		
		return null;
	}
	

	
//	View Restaurant details By Name Implementation ------------------------------>		

	@Override
	public List<Restaurant> viewRestaurantByItemName(String name) throws RestaurantException {
		
		
		
		return null;
	}

}
