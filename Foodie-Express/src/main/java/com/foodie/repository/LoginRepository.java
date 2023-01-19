package com.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodie.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
	 public Login findByMobileNo(String mobileNo);
	 
}
