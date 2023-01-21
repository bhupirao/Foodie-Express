package com.foodie.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer itemId;
		
		@NotNull
		@Size(min = 3, max = 10, message = "Item Name  should 3 to 20")
		private String itemName;
		
		@NotNull
		@Size(min=1,message = "Quantity should not be zero.")
		private Integer quantity;

		@NotNull
		private Integer costPerUnit;
		
		@OneToOne(cascade = CascadeType.ALL)
		@Size(min = 3, max = 10, message = "Category name should 3 to 20")
		private Category category;
		
		
		@JsonIgnore
		@ManyToMany(cascade = CascadeType.ALL)
		private List<Restaurant> listOfRestaurants = new ArrayList<>();
		


}
