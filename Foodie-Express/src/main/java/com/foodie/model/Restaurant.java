package com.foodie.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@OneToOne(cascade = CascadeType.ALL)
	private Address address; 
	
	//@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL , mappedBy = "listOfRestaurants")
	private List<Items> itemList = new ArrayList<>();
	
		




}
