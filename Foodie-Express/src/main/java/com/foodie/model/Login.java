package com.foodie.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	private String userId;
	
	private String userName;
	
	private String password;
	
	
	

}
