package com.foodie.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foodie.exception.BillException;
import com.foodie.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

	@Query("select b from Bill b where billDate between :startDate and :endDate")
	public List<Bill> viewBillsByDates(@Param("startDate")LocalDate startDate,@Param("startDate") LocalDate endDate) throws BillException;
}
