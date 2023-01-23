package com.foodie.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.BillException;
import com.foodie.exception.LoginException;
import com.foodie.model.Bill;

import com.foodie.model.Customer;
import com.foodie.model.Items;
import com.foodie.model.LoginSession;
import com.foodie.model.OrderDetails;
import com.foodie.repository.BillRepository;
import com.foodie.repository.CustomerRepository;
import com.foodie.repository.LoginSessionRepository;
import com.foodie.repository.OrderRepository;

import com.foodie.repository.BillRepository;


@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	public BillRepository bDao;

	@Autowired
	public LoginSessionRepository cSDao;

	@Autowired
	public OrderRepository oDao;

	@Autowired
	public CustomerRepository cDao;

	
	@Autowired
	private BillRepository billRepository;
	
	@Override

	public Bill addBill(Integer orderId , String uniqueId) throws BillException, LoginException {
		
		LoginSession cs = cSDao.findByUuid(uniqueId);
		if (cs != null) {
			Optional<OrderDetails> opt = oDao.findById(orderId);
			Optional<Customer> optC = cDao.findById(cs.getUserId());
			if (opt.isPresent() && optC.isPresent()) {
				OrderDetails orderDetails = opt.get();
				Customer customerDetails = optC.get();
				
				
				Bill bill = new Bill();
				
				bill.setBillDate(orderDetails.getOrderDate());
				

				List<Items> listItems = orderDetails.getCart().getItemList();
				double totalCost = 0;
				Integer totalItem = 0;
				for (Items i : listItems) {
					totalCost += i.getQuantity() * i.getCostPerUnit();
					totalItem += i.getQuantity();
				}
				bill.setTotalCost(totalCost);
				bill.setTotalitems(totalItem);
				bill.setOrder(orderDetails);

				bDao.save(bill);
				return bill;
			} else {
				throw new BillException("Wrong order Id , please pass correct Order Id");
			}

		} else {
			throw new LoginException("Customer is not logged in");
		}

	}

	

		

	@Override
	public Bill removeBill(Integer BillId,String uniqueId) throws BillException, LoginException {
		LoginSession cs = cSDao.findByUuid(uniqueId);
		if (cs != null) {
	
		Optional<Bill> opt = bDao.findById(BillId);

		if (opt.isPresent()) {
			
			bDao.delete(opt.get());
			
			return opt.get();

		} else {
			throw new BillException("No bill found by ");
		}
		}throw new LoginException("Customer is not logged in");
	

	}

	@Override
	public Bill updateBill(Bill bill,String uniqueId) throws BillException, LoginException {
		LoginSession cs = cSDao.findByUuid(uniqueId);
		if (cs != null) {
		
		Optional<Bill> opt = bDao.findById(bill.getBillid());
		Bill uBill = null;
		if (opt.isPresent()) {
			uBill = bDao.save(opt.get());

		} else {
			throw new BillException("No bill found by " + bill.getBillid() + " id");
		}

		return uBill;
	}
		throw new LoginException("Customer is not logged in");
	

	}
	
	

	@Override
	public Bill viewBill(Integer BillId) throws BillException {
		
		Optional<Bill> opt = bDao.findById(BillId);
		 if(opt.isPresent()) { 
			 Bill existingBill = opt.get();
			
			 return existingBill;
			 
		 }else { 
			 throw new BillException("Bill does not exist with billId: "+ BillId);
		 }
	}

	@Override
	public List<Bill> viewBills(Integer custId) throws BillException {
		
		return null;
	}

	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException {
	
		List<Bill> bills = bDao.viewBillsByDates(startDate,endDate);
		 if(bills.isEmpty()) { 
			 throw new BillException("Bills not found between date: "+ startDate +""+ endDate);
		 }
		return bills;
	}

	@Override
	public double calculateTotalCost(Integer billId) throws BillException {
		
		Optional<Bill> opt = bDao.findById(billId);
		 if(opt.isPresent()) { 
			 Bill existingBill = opt.get();
			 Double totalamount = existingBill.getTotalCost();
			 return totalamount;
			 
		 }else { 
			 throw new BillException("invalid bill details.");
		 }
	}

	
	
}
