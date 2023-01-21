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
//@NoArgsConstructor
//@AllArgsConstructor
public class Items {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer itemId;
//		
//		@NotNull
//		@Size(min = 3, max = 10, message = "Item Name  should 3 to 20")
		private String itemName;
		
//		@NotNull
//		@Size(min=1,message = "Quantity should not be zero.")
		private Integer quantity;

//		@NotNull
		private Integer costPerUnit;
		
		@OneToOne(cascade = CascadeType.ALL)
//		@Size(min = 3, max = 10, message = "Category name should 3 to 20")
		private Category category;
		
		@JsonIgnore
		@ManyToMany(cascade = CascadeType.ALL)
		private List<Restaurant> listOfRestaurants = new ArrayList<>();
		
		
		
		public Items() {
			// TODO Auto-generated constructor stub
		}



//		public Items(@NotNull @Size(min = 3, max = 10, message = "Item Name  should 3 to 20") String itemName,
//				@NotNull @Size(min = 1, message = "Quantity should not be zero.") Integer quantity,
//				@NotNull Integer costPerUnit,
//				@Size(min = 3, max = 10, message = "Category name should 3 to 20") Category category,
//				List<Restaurant> listOfRestaurants) {
//			super();
//			this.itemName = itemName;
//			this.quantity = quantity;
//			this.costPerUnit = costPerUnit;
//			this.category = category;
//			this.listOfRestaurants = listOfRestaurants;
//		}

		


		public Integer getItemId() {
			return itemId;
		}



		public Items( String itemName,  Integer quantity,  Integer costPerUnit, Category category,
		List<Restaurant> listOfRestaurants) {
	super();
	this.itemName = itemName;
	this.quantity = quantity;
	this.costPerUnit = costPerUnit;
	this.category = category;
	this.listOfRestaurants = listOfRestaurants;
}



		public void setItemId(Integer itemId) {
			this.itemId = itemId;
		}



		public String getItemName() {
			return itemName;
		}



		public void setItemName(String itemName) {
			this.itemName = itemName;
		}



		public Integer getQuantity() {
			return quantity;
		}



		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}



		public Integer getCostPerUnit() {
			return costPerUnit;
		}



		public void setCostPerUnit(Integer costPerUnit) {
			this.costPerUnit = costPerUnit;
		}



		public Category getCategory() {
			return category;
		}



		public void setCategory(Category category) {
			this.category = category;
		}



		public List<Restaurant> getListOfRestaurants() {
			return listOfRestaurants;
		}



		public void setListOfRestaurants(List<Restaurant> listOfRestaurants) {
			this.listOfRestaurants = listOfRestaurants;
		}



		@Override
		public String toString() {
			return "Items [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", costPerUnit="
					+ costPerUnit + ", category=" + category + ", listOfRestaurants=" + listOfRestaurants + "]";
		}
		
		
		
		
		
		
		


}
