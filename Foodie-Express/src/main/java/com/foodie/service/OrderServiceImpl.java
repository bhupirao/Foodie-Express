package com.foodie.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.FoodCartException;
import com.foodie.exception.LoginException;
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
	private LoginSessionRepository cSDao;

	@Autowired
	private FoodCartRepository foodRepo ;

	@Autowired
	private RestaurantRepository restaurantrepo;

	@Override
	public OrderDetails addOrder(Integer cartId, String uniqueId) throws OrderException, FoodCartException, LoginException {
		
		LoginSession cs = cSDao.findByUuid(uniqueId);
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
		}throw new LoginException("Invalid key please check it");
		
		
	}

	@Override
	public OrderDetails removeOrder(Integer orderId,String uniqueId ) throws OrderException {
		
		Optional<OrderDetails> opt = orderRepo.findById(orderId);

		if (opt.isPresent()) {
		      orderRepo.deleteById(orderId);;
		      return opt.get();
		} else {
			throw new OrderException("No order found by this order ");
		}

		
		
		
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order,String key) throws OrderException, LoginException {
		
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		Optional<OrderDetails> opt = orderRepo.findById(order.getOrderId());
		OrderDetails updatedOrder = null;
		if (opt.isPresent()) {
			updatedOrder = orderRepo.save(opt.get());

		} else {
			throw new OrderException("No order found by this order " + order.getOrderId() + " id");
		}

		return updatedOrder;
		}
		throw new LoginException("Invalid key please check it");
		

	}

	@Override
	public OrderDetails viewOrder(Integer orderId) throws OrderException {
		
		Optional<OrderDetails> opt = orderRepo.findById(orderId);
		OrderDetails exitstingOrder = null;
		if (opt.isPresent()) {
			exitstingOrder = opt.get();

		} else {
			throw new OrderException("No order found by this order " + orderId + " id");
		}

		return exitstingOrder;
	}

	@Override
	public List<OrderDetails> viewAllOrdersbyRestaurant(Restaurant res) throws OrderException {
		
          return null;
	}

	@Override
	public List<OrderDetails> viewAllOrdersbycustomer(Customer customer) throws OrderException {
		
		return null;
	}
	
}
