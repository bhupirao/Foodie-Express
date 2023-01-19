package com.foodie.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId;
	
	@NotNull(message = "Restaurant Name is Mandatory ")
	private String restaurantName;
		
	@NotNull(message = "Manager Name is Mandatory ")
	private String managerName;
	
	@NotNull(message = "Contact Number is Mandatory ")
	private String contactNumber;
	
	@NotNull(message = "Restaurant Address is Mandatory ")
	@Embedded
	private Address address; 
	
//	@ManyToMany
//	private List<Item> itemList = new ArrayList<>();
	
		
}
