package com.foodie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodie.model.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Integer> {
	
	public List<Items> findByItemName(String itemName);
	
	
}
