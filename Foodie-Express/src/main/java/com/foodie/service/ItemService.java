package com.foodie.service;

import java.util.List;

import com.foodie.exception.CategoryException;
import com.foodie.exception.ItemException;
import com.foodie.exception.LoginException;
import com.foodie.exception.RestaurantException;
import com.foodie.model.Category;
import com.foodie.model.Items;
import com.foodie.model.Restaurant;

public interface ItemService {
	
	public String addItem(Items items,String key)throws LoginException;
	
	public Items updateItems(Items item,Integer item_Id,String key) throws ItemException,LoginException;
	
	public Items viewItem(Integer item) throws ItemException;
	
	public Items removeItem(Integer item_Id,String key)throws LoginException;
	
	public List<Items> viewAllItemsCategory(Integer category_Id) throws CategoryException ,ItemException;
	
	public List<Items> viewAllItemsRestaurant(Integer restaurant_Id)throws RestaurantException ;
	
	public List<Items> viewAllItemsByName(String itemName) throws ItemException;


}