package com.example.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payment {
	@Id
	private String paymentId;
	private String paymentType;
	private String paymentStatus;
	private Card card;

	public Payment() {
		super();
	}
	public Payment(String paymentId, String paymentType, String paymentStatus,Card card) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.card=card;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Card getCard() {
		return this.card;
	}
	public void setCard(Card card) {
		this.card=card;
	}
}
