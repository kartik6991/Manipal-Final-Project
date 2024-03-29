
package com.example.demo.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	@Id
	private String orderId;
	private LocalDate orderDate;
	private LocalDate dispatchDate;
	private Double totalCost;
	private String status;
	private Payment payment;

	public Order() {
		super();
	}

	public Order(String orderId, LocalDate orderDate, LocalDate dispatchDate,Double totalCost, Payment payment,String status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.dispatchDate = dispatchDate;
		this.totalCost = totalCost;
		this.payment=payment;
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
