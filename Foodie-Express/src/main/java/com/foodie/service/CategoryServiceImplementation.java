package com.foodie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.CategoryException;
import com.foodie.model.Category;
import com.foodie.repository.CategoryRepository;
@Service
public class CategoryServiceImplementation implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public String addCategory(Category category) {
		
		categoryRepository.save(category);
		
		return "New Category ADDED ";
	}

	@Override
	public List<Category> viewALlCategory() throws CategoryException {
		
	List<Category> list = categoryRepository.findAll();
	
	if(list.isEmpty()) {
		
		throw new CategoryException("No Category list is EMPTY");
		
	}
	else {
		
		return list;
		
	}
	
	}

}
