package com.foodie.service;

import java.util.List;

import com.foodie.exception.CustomerException;
import com.foodie.model.Customer;


public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerException;
	public Customer updateCustomer(Integer customerId) throws CustomerException;
	public Customer removeCustomer(Integer customerId) throws CustomerException;
	public Customer viewCustomer(Integer customerId) throws CustomerException;
	public List<Customer> viewAllCustomer() throws CustomerException;
}
