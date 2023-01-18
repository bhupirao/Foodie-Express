package com.foodie.service;

import com.foodie.exception.LoginException;
import com.foodie.model.Login;

public interface LoginService {
	
	public Login signIn(Login login)throws LoginException;
	
	public  Login signOut(Login login)throws LoginException;
	
	

}
