package com.foodie.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.foodie.exception.RestaurantException;
import com.foodie.model.Category;
import com.foodie.model.Items;
import com.foodie.repository.ItemRepository;
import com.foodie.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/saveItem")
	public ResponseEntity<String> saveItemHandler(@Valid @RequestBody Items item ) {
		
		String message = itemService.addItem(item);
		
		return new ResponseEntity<>(message,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getItem/{id}")
	public ResponseEntity<Items> getItemHandler(@PathVariable Integer id ) {
		
		Items item = itemService.viewItem(id);
		
		return new ResponseEntity<>(item,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteItem/{id}")
	public ResponseEntity<Items> deleteItemHandler(@PathVariable Integer id ) {
		
		Items item = itemService.removeItem(id);
		
		return new ResponseEntity<>(item,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateItem/{id}")
	public ResponseEntity<Items> updateCategoryHandler(@Valid @RequestBody Items item ,@PathVariable Integer id) {
		
		Items c1 = itemService.updateItems(item,id);
		
		return new ResponseEntity<>(c1,HttpStatus.CREATED);
		
	}
	@GetMapping("/getItembyCategory/{id}")
	public ResponseEntity<List<Items>> getItemByCategoryHandler(@PathVariable Integer id ) {
		
		List<Items> item = itemService.viewAllItemsCategory(id);
		
		return new ResponseEntity<>(item,HttpStatus.OK);
		
	}
	
	@GetMapping("/getItemsbyRestaurants/{id}")
	public ResponseEntity<List<Items>> getItemByRestaurantsHandler(@PathVariable Integer id ) throws RestaurantException {
		
		List<Items> item = itemService.viewAllItemsRestaurant(id);
		
		return new ResponseEntity<>(item,HttpStatus.OK);
		
	}
	@GetMapping("/getItembyName/{itemName}")
	public ResponseEntity<List<Items>> getAllItemByNameHandler(@PathVariable String itemName ) {
		
		List<Items> item = itemService.viewAllItemsByName(itemName);
		
		return new ResponseEntity<>(item,HttpStatus.OK);
		
	}
	
	
	
}
