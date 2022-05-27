package com.example.demo.entities;

public class LoginDTO {
	String emailId;
	String password;
	Long mobileNumber;
	String customerName;
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginDTO(String emailId, String password, Long mobileNumber, String customerName) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
