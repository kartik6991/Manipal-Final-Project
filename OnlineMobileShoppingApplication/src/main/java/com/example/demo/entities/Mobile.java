package com.example.demo.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Mobile {
	@Id
	private String mobileId;
	@NotBlank(message="Name can't be blank")
	private String mobileName;
	private Float mobileCost;
	private Integer quantity;
	private LocalDate mfd;
	private String modelNumber;
	private String companyName;
	private Rating rating;
	private Feedback feedback;

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mobile(String mobileId, @NotBlank(message = "Name can't be blank") String mobileName, Float mobileCost,
			Integer quantity, LocalDate mfd, String modelNumber, String companyName, Rating rating, Feedback feedback) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.mobileCost = mobileCost;
		this.quantity = quantity;
		this.mfd = mfd;
		this.modelNumber = modelNumber;
		this.companyName = companyName;
		this.rating = rating;
		this.feedback = feedback;
	}

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public Float getMobileCost() {
		return mobileCost;
	}

	public void setMobileCost(Float mobileCost) {
		this.mobileCost = mobileCost;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getMfd() {
		return mfd;
	}

	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mobileId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobile other = (Mobile) obj;
		return Objects.equals(mobileId, other.mobileId);
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
}
