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
import org.springframework.web.bind.annotation.RestController;

import com.foodie.model.Address;
import com.foodie.model.Restaurant;
import com.foodie.service.RestaurantService;

@RestController
public class RestaurantController {
	
//	Restaurant Service Access --------------------------------->
	
	@Autowired
	private RestaurantService restaurantService;
	
//	Add Restaurant Controller ------------------------------>
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant)
	{
		Restaurant rest = restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<>(rest,HttpStatus.CREATED);
	}
	
//	Updated Restaurant Controller ------------------------------>
	
	@PutMapping("/updateRestaurant")
	public ResponseEntity<Restaurant> updateRestaurantById(@RequestBody Restaurant res)
	{
		Restaurant updatedRestaurant = restaurantService.updateRestaurant(res);
		
		return new ResponseEntity<>(updatedRestaurant, HttpStatus.ACCEPTED);
	}
	
//	Delete Restaurant Controller ------------------------------>
	
	@DeleteMapping("/deleteRestaurantById/{id}")
	public ResponseEntity<Restaurant> deleteRestaurantById(@PathVariable("id") Integer id)
	{
		
		Restaurant deletedRestaurant = restaurantService.removeRestaurant(id);
		
		return new ResponseEntity<>(deletedRestaurant,HttpStatus.ACCEPTED);
		
	}
	
//	 Get Restaurant Controller By Id ------------------------------>
	
	@GetMapping("/getRestaurant/{id}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") Integer id)
	{
		
		Restaurant restaurant = restaurantService.viewRestaurant(id);
		
		return new ResponseEntity<>(restaurant, HttpStatus.ACCEPTED);
		
	}
	
//	 Get Restaurant List By Location Controller By Id ------------------------------>
	
	@GetMapping("/getRestaurantList")
	public ResponseEntity<List<Restaurant>> getRestaurantList(@RequestBody Address location)
	{
		List<Restaurant> restaurantList = restaurantService.viewNearByRestaurant(location);
		
		return new ResponseEntity<>(restaurantList, HttpStatus.OK);
	}
	

}
