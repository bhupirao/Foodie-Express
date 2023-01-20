package com.foodie.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Items> itemList= new ArrayList<>();
	
	
	

}
