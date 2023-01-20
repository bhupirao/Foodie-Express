package com.foodie.service;



import com.foodie.exception.LoginException;
import com.foodie.model.Login;
import com.foodie.model.LoginDTO;

public interface LoginService {

	public String signIn(LoginDTO loginDto)throws LoginException;
	
	public  String signOut(Login login,String key)throws LoginException;
	
	public Login  createUser(Login login)throws LoginException;
	
	public Login  updateUser(Login login,String key)throws LoginException;
}
