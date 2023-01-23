package com.foodie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.CustomerException;
import com.foodie.exception.LoginException;
import com.foodie.exception.RestaurantException;
import com.foodie.model.Address;
import com.foodie.model.LoginSession;
import com.foodie.model.Restaurant;
import com.foodie.repository.LoginSessionRepository;
import com.foodie.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
//	Restaurant Repository Access --------------------------->
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@Autowired
	private LoginSessionRepository cSDao;
	
//	Add Restaurant Implementation ------------------------------>

	@Override
	public Restaurant addRestaurant(Restaurant res,String key) throws RestaurantException, LoginException {
		
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		
		Restaurant resto = restaurantRepo.save(res);
		
		if(resto != null)
		{
		return resto;
		}else throw new RestaurantException("Restaurant Not Added");
		}throw new LoginException("Key wrong please check");
	}
	
//	Update Restaurant details Implementation ------------------------------>

	@Override
	public Restaurant updateRestaurant(Restaurant res,String key) throws RestaurantException, LoginException {
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		Optional<Restaurant> opt = restaurantRepo.findById(res.getRestaurantId());
		
		if(opt.isPresent())
		{
			Restaurant updatedRestaurant = restaurantRepo.save(res);
			return updatedRestaurant;
		}else
			throw new CustomerException("There is no customer register with customer Id " + res.getRestaurantId());
		}throw new LoginException("Key wrong please check");
	}
	
//	Remove Restaurant details Implementation ------------------------------>	

	@Override
	public Restaurant removeRestaurant(Integer id,String key) throws RestaurantException, LoginException {
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		Optional<Restaurant> opt = restaurantRepo.findById(id);
		
		if(opt.isEmpty()) throw new RestaurantException("There is no Restaurant By Restaurant Id Number " + id);
		else {
		Restaurant deletedRest = opt.get();
		restaurantRepo.delete(deletedRest);
		return deletedRest;
		}
		}throw new LoginException("Key wrong please check");
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
	public List<Restaurant> viewAllRestaurant() throws RestaurantException {
		
		List<Restaurant> restaurantList = restaurantRepo.findAll();
		
		return restaurantList;
	}
	

}
