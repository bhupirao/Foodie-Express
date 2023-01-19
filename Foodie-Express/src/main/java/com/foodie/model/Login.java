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
@NoArgsConstructor
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
	
	

}
