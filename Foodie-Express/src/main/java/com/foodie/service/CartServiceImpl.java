package com.foodie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.CustomerException;
import com.foodie.exception.FoodCartException;
import com.foodie.exception.ItemException;
import com.foodie.model.Customer;
import com.foodie.model.FoodCart;
import com.foodie.model.Items;
import com.foodie.repository.CustomerRepository;
import com.foodie.repository.FoodCartRepository;
import com.foodie.repository.ItemRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private FoodCartRepository foodCartRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public FoodCart addItemToCart(FoodCart cart, Integer itemId) throws FoodCartException, ItemException {
		
		Optional<Customer> opt=customerRepository.findById(cart.getCustomer().getCustomerId());
		
		if(opt.isEmpty()) {
			throw new CustomerException("Customer Id not found");
		}
		
             Optional<Items> itemOpt=itemRepository.findById(itemId);
             
             if(itemOpt.isEmpty()) {
            	 
            	 throw new ItemException("Item Not Found");
            	 
             }
            
             
             List<Items> itemList=cart.getItemList();
             
             boolean flag=true;
     		for(int i=0;i<itemList.size();i++)
     		{
     			Items el=itemList.get(i);
     			if(el.getItemId()==itemId)
     			{
     				el.setQuantity(el.getQuantity()+1);
     				flag=false;
     			}
     		}
     		if(flag)
    		{
    			cart.getItemList().add(itemOpt.get());
    		}
     		
    		cart.setCustomer(opt.get());
    		foodCartRepository.save(cart);		
    		return cart;
             
             
	}

	@Override
	public FoodCart increaseQuantity(FoodCart cart, Items item, Integer quantity) throws FoodCartException, ItemException {
		

Optional<FoodCart> foodCart=foodCartRepository.findById(cart.getCartId());
		
		if(foodCart!=null) {

			Optional<Items> items=itemRepository.findById(item.getItemId());
			
			if(items!=null) {
				
				List<Items> li=new ArrayList<>();
				for(int i=0;i<li.size();i++) {
					if(i==item.getItemId()) {
						item.setQuantity(item.getQuantity()+quantity);
						
						
					}
				}
				li.add(item);
				
				cart.setItemList(li);
	
				return foodCartRepository.save(cart);
				
			}else {
				throw new ItemException("Item Quantity not added");
			}
		}
		
		throw new FoodCartException("Cart Not added");
	}

	@Override
	public FoodCart reduceQunatity(FoodCart cart, Items item, Integer quantity) throws FoodCartException, ItemException {
		

Optional<FoodCart> foodCart=foodCartRepository.findById(cart.getCartId());
		
		if(foodCart!=null) {

			Optional<Items> items=itemRepository.findById(item.getItemId());
			
			if(items!=null) {
				
				List<Items> li=new ArrayList<>();
				for(int i=0;i<li.size();i++) {
					if(i==item.getItemId()) {
						item.setQuantity(item.getQuantity()-quantity);
						
						
					}
				}
				li.add(item);
				
				cart.setItemList(li);
	
				return foodCartRepository.save(cart);
				
			}else {
				throw new ItemException("Item Quantity not remove");
			}
		}
		
		throw new FoodCartException("Cart Not added");
	}

	@Override
	public FoodCart removeItem(FoodCart cart, Items item) throws FoodCartException, ItemException {
		
		Optional<FoodCart> foodCart=foodCartRepository.findById(cart.getCartId());
		
		
		if(foodCart!=null) {

			Optional<Items> items=itemRepository.findById(item.getItemId());
			
			if(items!=null) {
				List<Items> li=new ArrayList<>();
				for(int i=0;i<li.size();i++) {
					if(i==item.getItemId()) {
						itemRepository.delete(item);
						
						
					}
				}
			
				
			
			
				return foodCartRepository.save(cart);
				
				
			}else {
				throw new ItemException("Item Quantity not remove");
			}
		}
		
		throw new FoodCartException("Cart Not added");
	}

	@Override
	public FoodCart clearCart(FoodCart cart) throws FoodCartException {
		
		Optional<FoodCart> foodCart=foodCartRepository.findById(cart.getCartId());
		
		if(foodCart!=null) {
			foodCartRepository.delete(cart);
			return cart;
		}
		throw new FoodCartException("In Food Cart Not Data found ");
		
	}

}
