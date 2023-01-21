package com.foodie.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
//	
//	@NotNull(message = "Name is mandatory")
	private String categoryName;
	

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="category" )
	private List<Items> catItems= new ArrayList<>();

	
	public Category() {
		// TODO Auto-generated constructor stub
	}
     public Category(String categoryName) {
	super();
	this.categoryName = categoryName;
}
public Integer getCategory_id() {
	return category_id;
}
public void setCategory_id(Integer category_id) {
	this.category_id = category_id;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
@Override
public String toString() {
	return "Category [category_id=" + category_id + ", categoryName=" + categoryName + "]";
}
	
	
	
	

	
}
