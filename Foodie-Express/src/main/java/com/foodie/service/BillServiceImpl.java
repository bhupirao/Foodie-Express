package com.foodie.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.foodie.exception.BillException;
import com.foodie.model.Bill;

@Service
public class BillServiceImpl implements BillService{

	@Override
	public Bill addBill(Integer orderId) throws BillException {
		
		
		
		return null;
	}

	@Override
	public Bill removeBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill viewBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> viewBills(Integer custId) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateTotalCost(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
