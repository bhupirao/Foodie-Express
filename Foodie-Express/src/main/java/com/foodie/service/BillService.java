package com.foodie.service;

import java.time.LocalDate;
import java.util.List;

import com.foodie.exception.BillException;
import com.foodie.model.Bill;

public interface BillService {

	public Bill addBill(Integer orderId , String uniqueId) throws BillException;

	public Bill removeBill(Integer BillId) throws BillException;

	public Bill updateBill(Bill bill) throws BillException;

	public Bill viewBill(Integer BillId) throws BillException;

	public List<Bill> viewBills(Integer custId) throws BillException;

	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException;

	public double calculateTotalCost(Integer billId) throws BillException;
}
