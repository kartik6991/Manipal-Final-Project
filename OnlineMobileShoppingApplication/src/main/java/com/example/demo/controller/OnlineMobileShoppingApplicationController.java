package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.exception.CustomerException;
import com.example.demo.service.ICustomerService;

//@CrossOrigin(value="http://localhost:3000/")
@RestController
@RequestMapping("api")
public class OnlineMobileShoppingApplicationController {
	@Autowired
	private ICustomerService custService;
	
	@GetMapping("customers")
	public List<Customer> getAllCustomers(){
		return this.custService.showAllCustomers();
	}
	
	@PostMapping("addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) throws CustomerException {
		return this.custService.addCustomer(customer);
	}
}
