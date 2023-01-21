package com.foodie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Login {
	
	
	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer userId;
	@NotNull(message="Name should not be empty")
    private String userName;
	@NotNull(message="Mobile should not be empty")
    private String mobileNo;
	@NotNull(message="Password should not be empty")
	@Size(min=8,max=15,message = "Password should be between 8 and 15")
    private String password;
	@Email(message="Email should be Valid Format")
	@NotNull(message="Email should not be empty")
    private String email;
	
	
	public Login() {
		
	}
	public Login(@NotNull(message = "Name should not be empty") String userName,
			@NotNull(message = "Mobile should not be empty") String mobileNo,
			@NotNull(message = "Password should not be empty") @Size(min = 8, max = 15, message = "Password should be between 8 and 15") String password,
			@Email(message = "Email should be Valid Format") @NotNull(message = "Email should not be empty") String email) {
		super();
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.password = password;
		this.email = email;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", userName=" + userName + ", mobileNo=" + mobileNo + ", password="
				+ password + ", email=" + email + "]";
	}
	
	
	
	
	
	

}
