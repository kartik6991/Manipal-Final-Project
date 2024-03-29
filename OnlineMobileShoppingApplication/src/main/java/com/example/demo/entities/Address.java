package com.example.demo.entities;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
	@Id
	String add_Id;
	@NotBlank(message="City can't be blank")
	String city;
	@NotBlank(message="District can't be blank")
	String district;
	@NotBlank(message="State can't be blank")
	String state;

	public Address() {
		super();
	}

	public Address(String add_Id,String city, String district, String state) {
		super();
		this.add_Id=add_Id;
		this.city = city;
		this.district = district;
		this.state = state;
	}
	
	public String getAdd_Id() {
		return add_Id;
	}

	public void setAdd_Id(String add_Id) {
		this.add_Id = add_Id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
