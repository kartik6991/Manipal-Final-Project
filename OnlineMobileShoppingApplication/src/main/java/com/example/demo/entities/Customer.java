package com.example.demo.entities;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
	@Id
	@Size(min=3,max=25,message ="UserId should be min of 3 chars & max of 25 chars.")
	@Pattern(regexp = "[0-9]+",message = "Username should be Numeric, No space allowed." )
	private Integer customerId;
	@NotBlank(message = "Name can't be Blank.")
	private String customerName;
	@Email(message = "Please enter valid Email eg: yourname@ipru.com.")
	private String emailId;
	@Pattern(regexp = "[a-zA-Z0-9]{8,}",message = "At least 8 characters,only uppercase lowercase and digits allowed.")
	private String customerPassword;
	private Long mobileNumber;
	List<Order> orders;
	private Address address;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, String customerName, String customerPassword, Long mobileNumber, String emailId,
			List<Order> orders, Address address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.orders = orders;
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
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
}
