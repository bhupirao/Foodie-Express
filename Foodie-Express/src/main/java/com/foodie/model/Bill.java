package com.foodie.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billid;

	private LocalDateTime time;

	private Integer totalitems;

	private Double totalCost;

    @OneToOne(cascade = CascadeType.ALL)
	private OrderDetails order;

    
    public Bill() {
		
	}
	public Bill(LocalDateTime time, Integer totalitems, Double totalCost, OrderDetails order) {
		super();
		this.time = time;
		this.totalitems = totalitems;
		this.totalCost = totalCost;
		this.order = order;
	}

	public Integer getBillid() {
		return billid;
	}

	public void setBillid(Integer billid) {
		this.billid = billid;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Integer getTotalitems() {
		return totalitems;
	}

	public void setTotalitems(Integer totalitems) {
		this.totalitems = totalitems;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Bill [billid=" + billid + ", time=" + time + ", totalitems=" + totalitems + ", totalCost=" + totalCost
				+ ", order=" + order + "]";
	}
    
    
    
    
}
