package com.example.demo.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerDTO {
	@NotBlank(message = "Name can't be Blank.")
	@Pattern(regexp="[A-Za-z]+",message = "customerName should be Alphanumeric only.")
	private String customerName;
	@Email(message = "Please enter valid Email eg: yourname@ipru.com.")
	private String emailId;
	@Pattern(regexp = "\"^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$\"",message = "At least 8 characters,aleast one uppercase, one lowercase, one digit and one special character required in password")
	private String customerPassword;
	private Long mobileNumber;
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(
			@NotBlank(message = "Name can't be Blank.") @Pattern(regexp = "[A-Za-z]+", message = "customerName should be Alphanumeric only.") String customerName,
			@Email(message = "Please enter valid Email eg: yourname@ipru.com.") String emailId,
			@Pattern(regexp = "\"^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$\"", message = "At least 8 characters,aleast one uppercase, one lowercase, one digit and one special character required in password") String customerPassword,
			Long mobileNumber) {
		super();
		this.customerName = customerName;
		this.emailId = emailId;
		this.customerPassword = customerPassword;
		this.mobileNumber = mobileNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
}
