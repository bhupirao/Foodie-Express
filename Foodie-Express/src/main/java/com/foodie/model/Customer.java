package com.foodie.model;

	

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@NotNull(message = "Customer First Name is Mandatory ")
	private String firstName;
	
	@NotNull(message = "Customer First Name is Mandatory ")
	private String lastName;
	private Integer age;
	private String gender;
	
	@NotNull(message = "Customer First Name is Mandatory ")
	private String mobileNumber;
	
	@Email(message = "Please enter Email in correct format")
	private String email;
	
	@NotNull(message = "Customer First Name is Mandatory ")
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
}
