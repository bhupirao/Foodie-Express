package com.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodie.model.LoginSession;

@Repository
public interface LoginSessionRepository extends JpaRepository<LoginSession, Integer>{
	
	public LoginSession findByUuid(String uuid);



}
