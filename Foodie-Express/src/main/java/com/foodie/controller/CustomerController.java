package com.foodie.controller;


import org.springframework.beans.factory.annotation.Autowired;

import com.foodie.service.CategoryService;
	
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.exception.CustomerException;
import com.foodie.exception.LoginException;
import com.foodie.model.Customer;
import com.foodie.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customerReg")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer,@RequestParam String key) throws CustomerException, LoginException
	{
		Customer addedCustomer = customerService.addCustomer(customer,key);
		
		return new ResponseEntity<>(addedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomerById")
	public ResponseEntity<Customer> updatedCustomerById(@RequestBody Customer customer,@RequestParam String key) throws CustomerException, LoginException
	{
		
		Customer updatedCustomer = customerService.updateCustomer(customer,key);
		
		return new ResponseEntity<>(updatedCustomer,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deleteCustomerById/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") Integer id,@RequestParam String key) throws CustomerException, LoginException
	{
		
		Customer deletedCustomer = customerService.removeCustomer(id,key);
		
		return new ResponseEntity<>(deletedCustomer,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id)
	{
		
		Customer customer = customerService.viewCustomer(id);
		
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		
		List<Customer> customerList = customerService.viewAllCustomer();
		
		return new ResponseEntity<>(customerList, HttpStatus.ACCEPTED);
		
	}


}
