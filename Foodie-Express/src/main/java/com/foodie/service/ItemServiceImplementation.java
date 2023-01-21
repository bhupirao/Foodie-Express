package com.foodie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.CategoryException;
import com.foodie.exception.ItemException;
import com.foodie.exception.RestaurantException;
import com.foodie.model.Category;
import com.foodie.model.Items;
import com.foodie.model.Restaurant;
import com.foodie.repository.CategoryRepository;
import com.foodie.repository.ItemRepository;
import com.foodie.repository.RestaurantRepository;

@Service
public class ItemServiceImplementation implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
//=========================================================================================================================================
	@Override
	public String addItem(Items items) {
		
		itemRepository.save(items);
		
		return "Item has been SAVED";
	}
//=========================================================================================================================================
	@Override
	public Items updateItems(Items item, Integer item_Id)throws ItemException {
		
		Optional<Items> optional =itemRepository.findById(item_Id);

		if(optional.isPresent()) {

			Items c1 = optional.get();
			
			c1.setCostPerUnit(item.getCostPerUnit());
			c1.setItemName(item.getItemName());
			c1.setQuantity(item.getQuantity());

			itemRepository.save(c1);
		
			return c1;
					

		}else {

			throw new ItemException("No Item with this Id EXIST");

		}
		
	}
//=========================================================================================================================================
	@Override
	public Items viewItem(Integer item_Id) throws ItemException {
		
		Optional<Items> optional = itemRepository.findById(item_Id);

		if(optional.isPresent()) {

			Items item = optional.get();

			return item; 

		}
		else {

			throw new ItemException(" No Item with Item_Id "+item_Id+"EXISTS");

		}

	
	
	}
//=========================================================================================================================================
	@Override

	public Items removeItem(Integer item_id) {
		
		Optional<Items> optional = itemRepository.findById(item_id);
		
		if(optional.isPresent()) {

			Items item = optional.get();
			
			itemRepository.deleteById(item_id);
			
			return item; 

		}
		else {

			throw new ItemException(" No Item with Item_Id "+item_id+"FOUND");

		}
		
	}
//=========================================================================================================================================
	@Override
	public List<Items> viewAllItemsCategory(Integer category_Id) throws CategoryException , ItemException{
//		Optional<Category> ocat=categoryRepository.findById(category_Id);
//		   List<Items> listItem=ocat.get().get;
		Optional<Category> optional=categoryRepository.findById(category_Id);
		
		if(optional.isEmpty()) {
			
			throw new CategoryException("No Category with this Id is found");
		}
		
			 Category category	=	optional.get();
				
				List<Items> items = itemRepository.findAll();
				
				List<Items> itemsList=new ArrayList<>();
				
//				for(int i=0;i<items.size();i++) {
//					
//					
//						
//					itemsList.add(i);
//						
//					}
//					
//				}
				
				for(Items i:items) {
					
					if(i.getCategory().getCategory_id()==category_Id) {
						
						itemsList.add(i);
						
					}
					
				}
				
				if(itemsList.size()==0) {
					
					throw new ItemException("No Item found with this Category_ID");
					
				}
	    
		return itemsList;
	}
//=========================================================================================================================================
	@Override
	public List<Items> viewAllItemsRestaurant(Integer restaurant_Id) throws RestaurantException {
		
		Optional<Restaurant> oRestaurant=restaurantRepository.findById(restaurant_Id);
		
		
	    List<Items> items=oRestaurant.get().getItemList();
	    
	    if(items.isEmpty()) {
	    	
	    	throw new RestaurantException("Item NOT FOUND in this Reataurant");
	    	
	    }

		
		return items;
	}
//=========================================================================================================================================
	public List<Items> viewAllItemsByName(String itemName)throws ItemException{
		
		List<Items> list =	itemRepository.findByItemName(itemName);
		
		if(list.isEmpty()) {
			
			throw new ItemException("No Item with this Item Name is FOUND");
			
		}
		
		return list;
		

	public Items removeItem(Items item) {
		
		return null;
	}
//=========================================================================================================================================
	@Override
	public List<Items> viewAllCategory(Category category) {
		
		return null;
	}
//=========================================================================================================================================
	@Override
	public List<Items> viewAllRestaurant(Category category) {
		
		return null;
	}
//=========================================================================================================================================
	@Override
	public List<Items> viewAllItemsByItems(String Itemslist) {
		
		return null;

	}
	
	
	
	

}
