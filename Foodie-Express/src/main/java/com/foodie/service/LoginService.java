package com.foodie.service;



import com.foodie.exception.LoginException;
import com.foodie.model.Login;
import com.foodie.model.LoginDTO;

public interface LoginService {

	public Login signIn(LoginDTO loginDto)throws LoginException;
	
	public  Login signOut(Login login,String key)throws LoginException;
	
	public String  createUser(Login login)throws LoginException;
	
	public String  updateUser(Login login,String key)throws LoginException;
}
