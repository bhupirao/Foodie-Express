package com.foodie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.model.Items;
import com.foodie.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/saveItem")
	public ResponseEntity<String> saveItemHandler (@RequestBody Items item ) {
		
		String message = itemService.addItem(item);
		
		return new ResponseEntity<>(message,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getItem/{id}")
	public ResponseEntity<Items> getItemHandler(@PathVariable Integer id ) {
		
		Items item = itemService.viewItem(id);
		
		return new ResponseEntity<>(item,HttpStatus.CREATED);
		
	}
	
}
