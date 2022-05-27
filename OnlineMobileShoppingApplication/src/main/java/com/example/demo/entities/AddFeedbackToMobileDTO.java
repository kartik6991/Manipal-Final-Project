package com.example.demo.entities;

public class AddFeedbackToMobileDTO {
	String mobileId;
	String feedbackId;
	public AddFeedbackToMobileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddFeedbackToMobileDTO(String mobileId, String feedbackId) {
		super();
		this.mobileId = mobileId;
		this.feedbackId = feedbackId;
	}
	public String getMobileId() {
		return mobileId;
	}
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
}
