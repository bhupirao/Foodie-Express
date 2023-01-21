package com.foodie.service;

import java.util.List;

import com.foodie.exception.FoodCartException;
import com.foodie.exception.OrderException;
import com.foodie.model.Customer;
import com.foodie.model.OrderDetails;
import com.foodie.model.Restaurant;

public interface OrderService {

	public OrderDetails addOrder(Integer cartId, String uniqueId) throws OrderException ,FoodCartException;

	public OrderDetails removeOrder(Integer orderId) throws OrderException;

	public OrderDetails updateOrder(OrderDetails order) throws OrderException;

	public OrderDetails viewOrder(Integer orderId) throws OrderException;

	public List<OrderDetails> viewAllOrdersbyRestaurant(Restaurant res) throws OrderException;

	public List<OrderDetails> viewAllOrdersbycustomer(Customer customer) throws OrderException;

}
