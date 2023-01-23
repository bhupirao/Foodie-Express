package com.foodie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.exception.LoginException;
import com.foodie.exception.RestaurantException;
import com.foodie.model.Restaurant;
import com.foodie.service.RestaurantService;

@RestController
public class RestaurantController {
	
//	Restaurant Service Access --------------------------------->
	
	@Autowired
	private RestaurantService restaurantService;
	
//	Add Restaurant Controller ------------------------------>
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant,@RequestParam String key) throws RestaurantException, LoginException
	{
		Restaurant rest = restaurantService.addRestaurant(restaurant,key);
		return new ResponseEntity<>(rest,HttpStatus.CREATED);
	}
	
//	Updated Restaurant Controller ------------------------------>
	
	@PutMapping("/updateRestaurant")
	public ResponseEntity<Restaurant> updateRestaurantById(@RequestBody Restaurant res,@RequestParam String key) throws RestaurantException, LoginException
	{
		Restaurant updatedRestaurant = restaurantService.updateRestaurant(res,key);
		
		return new ResponseEntity<>(updatedRestaurant, HttpStatus.ACCEPTED);
	}
	
//	Delete Restaurant Controller ------------------------------>
	
	@DeleteMapping("/deleteRestaurantById/{id}")
	public ResponseEntity<Restaurant> deleteRestaurantById(@PathVariable("id") Integer id,@RequestParam String key) throws RestaurantException, LoginException
	{
		
		Restaurant deletedRestaurant = restaurantService.removeRestaurant(id,key);
		
		return new ResponseEntity<>(deletedRestaurant,HttpStatus.ACCEPTED);
		
	}
	
//	 Get Restaurant Controller By Id ------------------------------>
	
	@GetMapping("/getRestaurant/{id}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") Integer id)
	{
		
		Restaurant restaurant = restaurantService.viewRestaurant(id);
		
		return new ResponseEntity<>(restaurant, HttpStatus.ACCEPTED);
		
	}
	
//	 Get Restaurant List Controller  ------------------------------>
	
	
	@GetMapping("/getRestaurantList")
	public ResponseEntity<List<Restaurant>> getRestaurantList()
	{
		List<Restaurant> restaurantList = restaurantService.viewAllRestaurant();
		
		return new ResponseEntity<>(restaurantList, HttpStatus.OK);
	}
	

}
