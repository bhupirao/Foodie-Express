package com.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodie.model.FoodCart;

@Repository
public interface ICartRepository extends JpaRepository<FoodCart, Integer> {
	
	
	
	

}
