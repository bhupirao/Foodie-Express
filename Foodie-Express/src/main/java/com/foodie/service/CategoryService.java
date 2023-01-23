package com.foodie.service;

import java.util.List;

import com.foodie.exception.CategoryException;
import com.foodie.exception.LoginException;
import com.foodie.model.Category;

public interface CategoryService {
	
	public String addCategory(Category category,String key)throws LoginException;
	
	public List<Category> viewALlCategory() throws CategoryException;

	public Category updateCategory(Category category,Integer id,String key) throws CategoryException,LoginException;
	
	public Category removeCategory(Integer category_Id,String key) throws CategoryException,LoginException;
	
}
