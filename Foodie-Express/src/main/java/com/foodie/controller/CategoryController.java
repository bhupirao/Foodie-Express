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

import com.foodie.model.Category;
import com.foodie.model.Items;
import com.foodie.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/saveCategory")
	public ResponseEntity<String> saveCategoryHandler(@Valid @RequestBody Category category ) {
		
		String message = categoryService.addCategory(category);
		
		return new ResponseEntity<>(message,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getCategories")
	public ResponseEntity<List<Category>> getAllCategoryHandler() {
		
		List<Category> list = categoryService.viewALlCategory();
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateCategories/{id}")
	public ResponseEntity<Category> updateCategoryHandler(@Valid @RequestBody Category category ,@PathVariable Integer id) {
		
		Category c1 = categoryService.updateCategory(category,id);
		
		return new ResponseEntity<>(c1,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteCategories/{id}")
	public ResponseEntity<Category> deleteCategoryHandler(@Valid @PathVariable Integer id) {
		
		Category c1 = categoryService.removeCategory(id);
		
		return new ResponseEntity<>(c1,HttpStatus.OK);
		
	}
	

}
