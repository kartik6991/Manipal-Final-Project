package com.example.demo.entities;

public class CustomerLogin {
	Integer id;
	String password;

	public CustomerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerLogin(Integer id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
