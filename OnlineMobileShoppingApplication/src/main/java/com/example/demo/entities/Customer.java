package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class Customer {
	@Id
	@Size(min = 3, max = 25, message = "UserId should be min of 3 chars & max of 25 chars.")
	@Pattern(regexp = "[0-9]+", message = "Username should be Numeric, No space allowed.")
	private String customerId;
	@NotBlank(message = "Name can't be Blank.")
	@Pattern(regexp="[A-Za-z]+",message = "customerName should be Alphanumeric only.")
	private String customerName;
	@Email(message = "Please enter valid Email eg: yourname@ipru.com.")
	private String emailId;
	@Pattern(regexp = "\"^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$\"",message = "At least 8 characters,aleast one uppercase, one lowercase, one digit and one special character required in password")
	@JsonIgnore
	private String customerPassword;
	private Long mobileNumber;
	List<Order> orders = new ArrayList<Order>();
	private Cart cart;
	private Address address;
	public Customer() {
		super();
	}	
	public Customer(
			@Size(min = 3, max = 25, message = "UserId should be min of 3 chars & max of 25 chars.") @Pattern(regexp = "[0-9]+", message = "Username should be Numeric, No space allowed.") String customerId,
			@NotBlank(message = "Name can't be Blank.") @Pattern(regexp="[A-Za-z]+",message = "customerName should be Alphanumeric only.")String customerName,
			@Email(message = "Please enter valid Email eg: yourname@ipru.com.") String emailId,
			@Pattern(regexp = "\"\\\"^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$\\\"\"", message = "At least 8 characters,aleast one uppercase, one lowercase, one digit and one special character required in password") String customerPassword,
			Long mobileNumber, List<Order> orders, Cart cart, Address address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.customerPassword = customerPassword;
		this.mobileNumber = mobileNumber;
		this.orders = orders;
		this.cart = cart;
		this.address = address;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}