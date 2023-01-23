package com.foodie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.CategoryException;
import com.foodie.exception.ItemException;
import com.foodie.exception.LoginException;
import com.foodie.model.Category;
import com.foodie.model.Items;
import com.foodie.model.LoginSession;
import com.foodie.repository.CategoryRepository;
import com.foodie.repository.ItemRepository;
import com.foodie.repository.LoginSessionRepository;
@Service
public class CategoryServiceImplementation implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private LoginSessionRepository cSDao;

	@Override
	public String addCategory(Category category,String key) throws LoginException {
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		
		categoryRepository.save(category);
		
		return "New Category ADDED ";
		}throw new LoginException("key invalid please check it");
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

	@Override
	public Category updateCategory(Category category ,Integer id,String key)  throws CategoryException, LoginException {
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		Optional<Category> optional =	categoryRepository.findById(id);

		if(optional.isPresent()) {

			Category c1 = optional.get();

			c1.setCategoryName(category.getCategoryName());

			return categoryRepository.save(c1);

		}else {

			throw new CategoryException("No such Category EXIST");

		}}throw new LoginException("key invalid please check it");
			
	}

	@Override
	public Category removeCategory(Integer category_Id,String key) throws CategoryException, LoginException {
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		
		
		Optional<Category> optional =	categoryRepository.findById(category_Id);
		
		if(optional.isPresent()) {
			
				Category c1 = optional.get();
				
				categoryRepository.delete(c1);
				
				return c1;
			
		}else {
			throw new CategoryException("No such Category EXIST");
		}}throw new LoginException("key invalid please check it");
	}
	
	

}
