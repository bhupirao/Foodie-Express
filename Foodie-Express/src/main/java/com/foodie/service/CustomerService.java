package com.foodie.service;

import java.util.List;

import com.foodie.exception.CustomerException;
import com.foodie.model.Customer;
import com.foodie.model.Restaurant;


public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerException;
	public Customer updateCustomer(Customer customer) throws CustomerException;
	public Customer removeCustomer(Customer customer) throws CustomerException;
	public Customer viewCustomer(Customer customer) throws CustomerException;
	public List<Customer> viewAllCustomer(Restaurant restaurant) throws CustomerException;
}
