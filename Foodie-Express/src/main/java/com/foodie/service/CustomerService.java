package com.foodie.service;

import java.util.List;

import com.foodie.exception.CustomerException;
import com.foodie.exception.LoginException;
import com.foodie.model.Customer;
import com.foodie.model.Restaurant;


public interface CustomerService {

	public Customer addCustomer(Customer customer,String key) throws CustomerException,LoginException ;
	public Customer updateCustomer(Customer customer,String key) throws CustomerException,LoginException ;
	public Customer removeCustomer(Integer id,String key) throws CustomerException,LoginException;
	public Customer viewCustomer(Integer id) throws CustomerException;
	public List<Customer> viewAllCustomer() throws CustomerException;
}
