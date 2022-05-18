package com.example.demo.entities;

import java.util.List;

public class Cart {
	private int cartId;
	private Customer customer;
	private List<Mobile> mobile;
	private int quantity;
	private int cost;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cartId, Customer customer, List<Mobile> mobile, int quantity, int cost) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.mobile = mobile;
		this.quantity = quantity;
		this.cost = cost;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

}
