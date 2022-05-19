package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Customer;
import com.example.demo.exception.CustomerException;

public interface ICustomerService {
	public Customer addCustomer(Customer Customer) throws CustomerException;

	public Customer updateCustomer(Customer Customer) throws CustomerException;

	public String cancelCustomer(Integer Customerid) throws CustomerException;

	public List<Customer> showAllCustomers();
}
