package com.foodie.service;

import java.util.List;

import com.foodie.exception.ItemException;
import com.foodie.model.Category;
import com.foodie.model.Items;

public interface ItemService {
	
	public String addItem(Items items);
	
	public Items updateItems(Items items);
	
	public Items viewItem(Integer item) throws ItemException;
	
	public Items removeItem(Items item);
	
	public List<Items> viewAllCategory(Category category);
	
	public List<Items> viewAllRestaurant(Category category);
	
	public List<Items> viewAllItemsByItems(String Itemslist);


}