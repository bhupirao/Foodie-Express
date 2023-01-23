package com.foodie.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	private LocalDateTime orderDate;

//	@NonNull
//	@NotBlank
//	@NotEmpty
//	@Size(min = 3, max = 10, message = "Order Status should 3 to 10")
	private OrderStatus orderstatus;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	public FoodCart cart;
	
//	
//	public OrderDetails() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public OrderDetails(LocalDateTime orderDate,
//			@NonNull @NotBlank @NotEmpty @Size(min = 3, max = 10, message = "Order Status should 3 to 10") OrderStatus orderstatus,
//			FoodCart cart) {
//		super();
//		this.orderDate = orderDate;
//		this.orderstatus = orderstatus;
//		this.cart = cart;
//	}
//
//	public Integer getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}
//
//	public LocalDateTime getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(LocalDateTime orderDate) {
//		this.orderDate = orderDate;
//	}
//
//	public OrderStatus getOrderstatus() {
//		return orderstatus;
//	}
//
//	public void setOrderstatus(OrderStatus orderstatus) {
//		this.orderstatus = orderstatus;
//	}
//
//	public FoodCart getCart() {
//		return cart;
//	}
//
//	public void setCart(FoodCart cart) {
//		this.cart = cart;
//	}
//
//	@Override
//	public String toString() {
//		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", orderstatus=" + orderstatus
//				+ ", cart=" + cart + "]";
//	}
//	
	
	
}
