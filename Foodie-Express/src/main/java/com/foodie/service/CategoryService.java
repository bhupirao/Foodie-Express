package com.foodie.service;

import java.util.List;

import com.foodie.exception.CategoryException;
import com.foodie.model.Category;

public interface CategoryService {
	
	public String addCategory(Category category);
	
	public List<Category> viewALlCategory() throws CategoryException;

	public Category updateCategory(Category category,Integer id) throws CategoryException;
	
	public Category removeCategory(Integer category_Id) throws CategoryException;
	
}
