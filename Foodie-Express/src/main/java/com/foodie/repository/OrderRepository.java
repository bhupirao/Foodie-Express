package com.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodie.model.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, Integer>{

}
