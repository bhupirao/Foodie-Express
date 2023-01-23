package com.foodie.service;

import java.util.List;

import com.foodie.exception.FoodCartException;
import com.foodie.exception.LoginException;
import com.foodie.exception.OrderException;
import com.foodie.model.Customer;
import com.foodie.model.OrderDetails;
import com.foodie.model.Restaurant;

public interface OrderService {

	public OrderDetails addOrder(Integer cartId, String uniqueId) throws OrderException ,FoodCartException,LoginException;

	public OrderDetails removeOrder(Integer orderId,String uniqueId) throws OrderException,LoginException;

	public OrderDetails updateOrder(OrderDetails order,String uniqueId) throws OrderException,LoginException;

	public OrderDetails viewOrder(Integer orderId) throws OrderException;

	public List<OrderDetails> viewAllOrdersbyRestaurant(Restaurant res) throws OrderException;

	public List<OrderDetails> viewAllOrdersbycustomer(Customer customer) throws OrderException;

}
