package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Customer;
import com.example.demo.entities.LoginDTO;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.LoginException;

public interface ICustomerService {
	public Customer addCustomer(Customer Customer) throws CustomerException;

	public Customer updateCustomer(Customer Customer) throws CustomerException;

	public String cancelCustomer(String Customerid) throws CustomerException;

	public List<Customer> showAllCustomers();

	public Customer showCustomerById(String customerId) throws CustomerException;
	
	public String login(LoginDTO loginDTO) throws LoginException;
}