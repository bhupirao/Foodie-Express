package com.foodie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.ItemException;
import com.foodie.model.Category;
import com.foodie.model.Items;
import com.foodie.repository.ItemRepository;

@Service
public class ItemServiceImplementation implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	
//=========================================================================================================================================
	@Override
	public String addItem(Items items) {
		
		itemRepository.save(items);
		
		return "Item has been SAVED";
	}
//=========================================================================================================================================
	@Override
	public Items updateItems(Items items) {
		// TODO Auto-generated method stub
		return null;
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
