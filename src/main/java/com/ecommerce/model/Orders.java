package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private Long userId;
	private Double totalAmount;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(Long id, Long userId, Double totalAmount) {
		super();
		this.id = id;
		this.userId = userId;
		this.totalAmount = totalAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", totalAmount=" + totalAmount + "]";
	}
	
	

}
