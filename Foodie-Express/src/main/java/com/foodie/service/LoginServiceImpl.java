package com.foodie.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.exception.LoginException;
import com.foodie.model.Login;
import com.foodie.model.LoginDTO;
import com.foodie.model.LoginSession;
import com.foodie.repository.LoginRepository;
import com.foodie.repository.LoginSessionRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginSessionRepository loginSessionRepository;
	

	@Override
	public String signIn(LoginDTO loginDto) throws LoginException {
		
	  Login existingUser=loginRepository.findByMobileNo(loginDto.getMobileNo());
	  
	  if(existingUser==null){
		  
          throw new LoginException("Please Enter a Valid Mobile No");
      }
	  
	  Optional<LoginSession> vaildUserSessionOpt=loginSessionRepository.findById(existingUser.getUserId());
	  
	  if(vaildUserSessionOpt.isPresent()){
		  
          throw new LoginException("User already Logged in with this number");
      }
      if(existingUser.getPassword().equals(loginDto.getPassword())) {

          String key= RandomString.make(6);



          LoginSession currentUserSession = new LoginSession(existingUser.getUserId(),key, LocalDateTime.now());

          loginSessionRepository.save(currentUserSession);

          return currentUserSession.toString();
      }
      else
          throw new LoginException("Please Enter a valid password");
		
      
	}

	@Override
	public String signOut(Login login, String key) throws LoginException {
		
		 LoginSession validUserSession = loginSessionRepository.findByUuid(key);


	        if(validUserSession == null) {
	        	
	            throw new LoginException("User Not Logged In with this number");

	        }


	        loginSessionRepository.delete(validUserSession);


	        return "Logged Out !";
	        
	}

	@Override
	public Login createUser(Login login) throws LoginException {
		
		Login existingUser=loginRepository.findByMobileNo(login.getMobileNo());
		
		if(existingUser!=null) {
			
			throw new LoginException("User already registered with Mobile No");
		}
		
		return loginRepository.save(login);
	}

	@Override
	public Login updateUser(Login login, String key) throws LoginException {
		
		LoginSession loggedInUser=loginSessionRepository.findByUuid(key);
		
		if(loggedInUser==null) {
			
			throw new LoginException("Please provide a valid key to update a User");
		}
		
		if(login.getUserId()==loggedInUser.getUserId()) {
			
			return loginRepository.save(login);
		}
		
		throw new LoginException("Invalid User Details, please login first");
	}
	
	

}
