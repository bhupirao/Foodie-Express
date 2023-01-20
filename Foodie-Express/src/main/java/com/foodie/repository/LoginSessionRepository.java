package com.foodie.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.foodie.model.LoginSession;

public interface LoginSessionRepository extends JpaRepository<LoginSession , Integer>{

	public LoginSession findByUuid(String uniqueId);




}
