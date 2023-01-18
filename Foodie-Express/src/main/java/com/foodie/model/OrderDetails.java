package com.foodie.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	private LocalDateTime orderDate;

//	@NonNull
//	@NotBlank
//	@NotEmpty
//	@Size(min = 3, max = 10, message = "Order Status should 3 to 10")
//	private String orderStatus;

//	@OneToOne(cascade = CascadeType.ALL)
//	public FoodCart cart;
	
}
