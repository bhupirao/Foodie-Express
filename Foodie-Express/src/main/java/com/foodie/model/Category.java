package com.foodie.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer category_id;
	
	@NotNull(message = "Name is mandatory")
	private String categoryName;
	

	@OneToMany(targetEntity = Items.class, cascade = CascadeType.ALL, mappedBy = "category")
	private List<Items> itemList= new ArrayList<>();


//	public Category() {
//		// TODO Auto-generated constructor stub
//	}
//	
//
//
//	public Category(Integer category_id, String categoryName, List<Items> itemList) {
//		super();
//		this.category_id = category_id;
//		this.categoryName = categoryName;
//		this.itemList = itemList;
//	}
//
//
//
//	public Integer getCategory_id() {
//		return category_id;
//	}
//
//
//	public void setCategory_id(Integer category_id) {
//		this.category_id = category_id;
//	}
//
//
//	public String getCategoryName() {
//		return categoryName;
//	}
//
//
//	public void setCategoryName(String categoryName) {
//		this.categoryName = categoryName;
//	}
//
//
//
//	public List<Items> getItemList() {
//		return itemList;
//	}
//
//
//
//	public void setItemList(List<Items> itemList) {
//		this.itemList = itemList;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Category [category_id=" + category_id + ", categoryName=" + categoryName + ", itemList=" + itemList
//				+ "]";
//	}
//
//
//	



	
	 
	 
	
	
	
	

	
}
