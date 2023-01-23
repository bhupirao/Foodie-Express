package com.foodie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.CustomerException;
import com.foodie.exception.FoodCartException;
import com.foodie.exception.ItemException;
import com.foodie.exception.LoginException;
import com.foodie.model.Customer;
import com.foodie.model.FoodCart;
import com.foodie.model.Items;
import com.foodie.model.LoginSession;
import com.foodie.repository.CustomerRepository;
import com.foodie.repository.FoodCartRepository;
import com.foodie.repository.ItemRepository;
import com.foodie.repository.LoginSessionRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private FoodCartRepository foodCartRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired 
	private LoginSessionRepository cSDao;

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
	public FoodCart increaseQuantity(FoodCart cart,Integer itemId, Integer quantity) throws FoodCartException, ItemException {
		

          Optional<FoodCart> foodCart=foodCartRepository.findById(cart.getCartId());
		
		if(foodCart.isPresent()) {
			
			cart=foodCart.get();
			List<Items> itemList = cart.getItemList();
			boolean flag = true;
			for (int i = 0; i < itemList.size(); i++) {
				Items ele = itemList.get(i);
				if (ele.getItemId() == itemId) {
					ele.setQuantity(ele.getQuantity() + quantity);
					flag = false;
				}
			}
			if (flag)
				throw new ItemException("Item not found!");
			else {

				cart.setItemList(itemList);
				foodCartRepository.save(cart);
				return cart;
			}

		}else {
			throw new FoodCartException("Food Cart not found!");
		}
	}

	@Override
	public FoodCart reduceQunatity(FoodCart cart, Integer itemId, Integer quantity) throws FoodCartException, ItemException {
		

         
        Optional<FoodCart> foodCart=foodCartRepository.findById(cart.getCartId());
		
		if(foodCart.isPresent()) {
			cart=foodCart.get();
			List<Items> itemList = cart.getItemList();
			boolean flag = true;
			for (int i = 0; i < itemList.size(); i++) {
				Items ele = itemList.get(i);
				if (ele.getItemId() == itemId) {
					ele.setQuantity(ele.getQuantity() - quantity);
					flag = false;
				}
			}
			if (flag)
				throw new ItemException("Item not found!");
			else {

				cart.setItemList(itemList);
				foodCartRepository.save(cart);
				return cart;
			}

		}else {
			throw new FoodCartException("Food Cart not found!");
		}
	}

	@Override
	public FoodCart removeItem(FoodCart cart, Integer itemId,String key) throws FoodCartException, ItemException, LoginException {
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		
		Optional<FoodCart> opt=foodCartRepository.findById(cart.getCartId());
		if (opt.isPresent()) {
			 cart = opt.get();

			List<Items> itemList = cart.getItemList();

			boolean flag = true;
			Items getItem = null;

			for (int i = 0; i < itemList.size(); i++) {
				Items ele = itemList.get(i);
				if (ele.getItemId() == itemId) {
					flag = false;
					getItem = ele;
				}
			}
			if (flag)
				throw new ItemException("Item not found!");
			else {
				itemList.remove(getItem);
				cart.setItemList(itemList);
				foodCartRepository.save(cart);
				return cart;
			}
		} else {
			throw new FoodCartException("Food Cart not found!");
		}
		}throw new LoginException("Key Invalid please check it");
		
	}

	@Override
	public FoodCart clearCart(FoodCart cart,String key) throws FoodCartException, LoginException {
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		
		Optional<FoodCart> foodCart=foodCartRepository.findById(cart.getCartId());
		
		if(foodCart.isPresent()) {
			
			foodCartRepository.delete(cart);
			return cart;
			 
		}
		throw new FoodCartException("In Food Cart Not  found ");
		}
	
	throw new LoginException("Key Invalid please check it");
	}

}
