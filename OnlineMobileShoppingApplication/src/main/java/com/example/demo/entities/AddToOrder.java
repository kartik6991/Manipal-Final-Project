package com.example.demo.entities;

public class AddToOrder {
	private String customerId;
	private String orderId;
	public AddToOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddToOrder(String customerId, String orderId) {
		super();
		this.customerId = customerId;
		this.orderId=orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
}
