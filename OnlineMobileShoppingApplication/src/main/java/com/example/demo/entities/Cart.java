package com.example.demo.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {
	@Id
	private Integer cartId;
	private Customer customer;
	private List<Mobile> mobile;
	private Integer quantity;
	private Integer cost;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Integer cartId, Customer customer, List<Mobile> mobile, Integer quantity, Integer cost) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.mobile = mobile;
		this.quantity = quantity;
		this.cost = cost;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Mobile> getMobile() {
		return mobile;
	}

	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

}
