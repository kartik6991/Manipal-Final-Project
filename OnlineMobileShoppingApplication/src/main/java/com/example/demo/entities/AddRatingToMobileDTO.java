package com.example.demo.entities;

public class AddRatingToMobileDTO {
	String mobileId;
	String ratingId;
	public AddRatingToMobileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddRatingToMobileDTO(String mobileId, String ratingId) {
		super();
		this.mobileId = mobileId;
		this.ratingId = ratingId;
	}
	public String getMobileId() {
		return mobileId;
	}
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
}
