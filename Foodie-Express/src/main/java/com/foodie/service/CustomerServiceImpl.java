package com.foodie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.CustomerException;
import com.foodie.model.Customer;
import com.foodie.model.Restaurant;
import com.foodie.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;

	
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		
		
		Customer cust = customerRepo.save(customer);
		
		if(cust != null)
		{
		return cust;
		}else throw new CustomerException("Customer Not Added");
		
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = customerRepo.findById(customer.getCustomerId());
		
		if(opt.isPresent())
		{
			Customer updatedCustomer = customerRepo.save(customer);
			return updatedCustomer;
		}else
			throw new CustomerException("There is no customer register with customer Id " + customer.getCustomerId());
		
		
	}

	@Override
	public Customer removeCustomer(Integer id) throws CustomerException {
		
		Optional<Customer> opt = customerRepo.findById(id);
		
		if(opt.isEmpty()) throw new CustomerException("There is no Customer By Customer Id Number " + id);
		else {
		Customer deletedCust = opt.get();
		customerRepo.delete(deletedCust);
		return deletedCust;
		}
		
	}

	@Override
	public Customer viewCustomer(Integer id) throws CustomerException {
		Optional<Customer> opt = customerRepo.findById(id);
		
		if(opt.isEmpty()) throw new CustomerException("There is no Customer By Customer Id Number " + id);
		else {
		Customer customer = opt.get();
		return customer;
		}
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		List<Customer> customerList = customerRepo.findAll();
		return customerList;
	}

}
