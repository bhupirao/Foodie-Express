package com.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodie.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	
	
}
