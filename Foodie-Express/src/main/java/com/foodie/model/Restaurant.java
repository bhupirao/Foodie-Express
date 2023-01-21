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
//@NoArgsConstructor
//@AllArgsConstructor
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId;
	
//	@NotNull(message = "Restaurant Name is Mandatory ")
	private String restaurantName;
		
//	@NotNull(message = "Manager Name is Mandatory ")
	private String managerName;
	
//	@NotNull(message = "Contact Number is Mandatory ")
	private String contactNumber;
	
//	@NotNull(message = "Restaurant Address is Mandatory ")

	@OneToOne(cascade = CascadeType.ALL)
	private Address address; 
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL , mappedBy = "listOfRestaurants")
	private List<Items> itemList = new ArrayList<>();

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Restaurant(Integer restaurantId, String restaurantName, String managerName, String contactNumber,
			Address address, List<Items> itemList) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.itemList = itemList;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}


	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", managerName="
				+ managerName + ", contactNumber=" + contactNumber + ", address=" + address + ", itemList=" + itemList
				+ "]";
	}
		
}
