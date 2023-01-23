package com.foodie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.BillException;
import com.foodie.exception.CustomerException;
import com.foodie.exception.LoginException;
import com.foodie.model.Customer;
import com.foodie.model.LoginSession;
import com.foodie.repository.CustomerRepository;
import com.foodie.repository.LoginSessionRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private LoginSessionRepository cSDao;

	
	@Override
	public Customer addCustomer(Customer customer,String key) throws CustomerException, LoginException {
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		
		Customer cust = customerRepo.save(customer);
		
		if(cust != null)
		{
		return cust;
		}else throw new CustomerException("Customer Not Added");
		
		}throw new LoginException("Key wrong please check");
	}

	@Override
	public Customer updateCustomer(Customer customer,String key) throws CustomerException, LoginException {
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		
		Optional<Customer> opt = customerRepo.findById(customer.getCustomerId());
		
		if(opt.isPresent())
		{
			Customer updatedCustomer = customerRepo.save(customer);
			return updatedCustomer;
		}else
			throw new CustomerException("There is no customer register with customer Id " + customer.getCustomerId());
		}
		throw new LoginException("Key wrong please check");
		
	}

	@Override
	public Customer removeCustomer(Integer id,String key) throws CustomerException, LoginException {
		LoginSession cs = cSDao.findByUuid(key);
		if (cs != null) {
		
		
		Optional<Customer> opt = customerRepo.findById(id);
		
		if(opt.isEmpty()) throw new CustomerException("There is no Customer By Customer Id Number " + id);
		else {
		Customer deletedCust = opt.get();
		customerRepo.delete(deletedCust);
		return deletedCust;
		}
		}throw new LoginException("Key wrong please check");
		
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
