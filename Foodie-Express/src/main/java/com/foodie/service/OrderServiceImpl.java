package com.foodie.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.FoodCartException;
import com.foodie.exception.OrderException;
import com.foodie.model.Customer;
import com.foodie.model.FoodCart;
import com.foodie.model.LoginSession;
import com.foodie.model.OrderDetails;
import com.foodie.model.OrderStatus;
import com.foodie.model.Restaurant;
import com.foodie.repository.FoodCartRepository;
import com.foodie.repository.LoginSessionRepository;
import com.foodie.repository.OrderRepository;
import com.foodie.repository.RestaurantRepository;


@Service
public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private LoginSessionRepository loginsession;

	@Autowired
	private FoodCartRepository foodRepo ;

	@Autowired
	private RestaurantRepository restaurantrepo;

	@Override
	public OrderDetails addOrder(Integer cartId, String uniqueId) throws OrderException, FoodCartException {
		
		LoginSession cs = loginsession.findByUuid(uniqueId);
		
		if (cs != null) {
			FoodCart foodCart = foodRepo.findById(cartId).get();
			 
			if (foodCart != null) {
				OrderDetails od = new OrderDetails();
				od.setOrderDate(LocalDateTime.now());
				od.setOrderstatus(OrderStatus.DELIVERED);
				od.setCart(foodCart);
				orderRepo.save(od);
				return od;

			} else {
				throw new FoodCartException("No item found in your cart");
			}
		} else {
			throw new OrderException("customer is not logged in");
		}
		
	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) throws OrderException {
		
		Optional<OrderDetails> opt = orderRepo.findById(order.getOrderId());

		if (opt.isPresent()) {
		      orderRepo.delete(opt.get());

		} else {
			throw new OrderException("No order found by this order " + order.getOrderId() + " id");
		}

		return order;
		
		
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderException {
		
		
		Optional<OrderDetails> opt = orderRepo.findById(order.getOrderId());
		OrderDetails updatedOrder = null;
		if (opt.isPresent()) {
			updatedOrder = orderRepo.save(opt.get());

		} else {
			throw new OrderException("No order found by this order " + order.getOrderId() + " id");
		}

		return updatedOrder;
		

	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) throws OrderException {
		
		Optional<OrderDetails> opt = orderRepo.findById(order.getOrderId());
		OrderDetails exitstingOrder = null;
		if (opt.isPresent()) {
			exitstingOrder = opt.get();

		} else {
			throw new OrderException("No order found by this order " + order.getOrderId() + " id");
		}

		return exitstingOrder;
	}

	@Override
	public List<OrderDetails> viewAllOrders(Restaurant res) throws OrderException {
		
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException {
		
		return null;
	}
	
}
