package com.example.demo.entities;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Feedback {
	@Id
	@Size(min = 3, max = 25, message = "Rating Id should be min of 3 chars & max of 25 chars.")
	@Pattern(regexp = "[0-9]+", message = "Rating Id should be Numeric, No space allowed.")
	private String feedbackId;
	private String form;
	private Date DateTime;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Feedback(String feedbackId, String form, Date dateTime) {
		super();
		this.feedbackId = feedbackId;
		this.form = form;
		DateTime = dateTime;
	}
	
	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}


	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
	public Date getDateTime() {
		return DateTime;
	}

	public void setDateTime(Date DateTime) {
		this.DateTime = DateTime;
	}
}
