package com.example.demo.entities;

public class AddtoCartDTO {
	private String customerId;
	private String mobileId;
	public AddtoCartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddtoCartDTO(String customerId, String mobileId) {
		super();
		this.customerId = customerId;
		this.mobileId = mobileId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getMobileId() {
		return mobileId;
	}
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
}
