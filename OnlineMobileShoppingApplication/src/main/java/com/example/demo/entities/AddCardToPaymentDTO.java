package com.example.demo.entities;

public class AddCardToPaymentDTO {
	String paymentId;
	String cardNumber;
	public AddCardToPaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddCardToPaymentDTO(String paymentId, String cardNumber) {
		super();
		this.paymentId = paymentId;
		this.cardNumber = cardNumber;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
