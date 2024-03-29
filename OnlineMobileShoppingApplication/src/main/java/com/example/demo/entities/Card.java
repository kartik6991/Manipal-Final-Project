package com.example.demo.entities;

import java.time.LocalDate;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class Card{
	@Id
	@Size(max = 12, message = "Rating Id should be max of 12 chars.")
	@Pattern(regexp = "[0-9]+", message = "Rating Id should be Numeric, No space allowed.")
	private String cardNumber;
	private LocalDate validDateFrom;
	private LocalDate validDatethrough;
	@JsonIgnore
	private Integer cvv;
	
	public Card() {
		super();
	}
	public Card(String cardNumber, LocalDate validDateFrom, LocalDate validDatethrough,Integer cvv) {
		super();
		this.cardNumber = cardNumber;
		this.validDateFrom = validDateFrom;
		this.validDatethrough = validDatethrough;
		this.cvv=cvv;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getValidDateFrom() {
		return validDateFrom;
	}
	public void setValidDateFrom(LocalDate validDateFrom) {
		this.validDateFrom = validDateFrom;
	}
	public LocalDate getValidDatethrough() {
		return validDatethrough;
	}
	public void setValidDatethrough(LocalDate validDatethrough) {
		this.validDatethrough = validDatethrough;
	}
	public Integer getCvv() {
		return this.cvv;
	}
	public void setCvv(Integer cvv) {
		this.cvv=cvv;
	}
}
