package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.entities.LoginDTO;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.LoginException;
import com.example.demo.service.ICustomerService;

@CrossOrigin(value="http://localhost:3000/")
@RestController
@RequestMapping("api")
public class CustomerController {
	@Autowired
	private ICustomerService custService;

	@GetMapping("customers")
	public List<Customer> getAllCustomers() {
		return this.custService.showAllCustomers();
	}

	@PostMapping("addCustomer")
	public Customer createCustomer(@RequestBody Customer customer) throws CustomerException {
		return this.custService.addCustomer(customer);
	}

	@DeleteMapping("cancelCustomer/{id}")
	public String cancelCustomer(@PathVariable("id") String customerId) throws CustomerException {
		return this.custService.cancelCustomer(customerId);
	}

	@PutMapping("updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerException {
		return this.custService.updateCustomer(customer);
	}

	@GetMapping("customer/{id}")
	public Customer showCustomerById(@PathVariable("id") String customerId) throws CustomerException {
		return this.custService.showCustomerById(customerId);
	}

	@PostMapping("login")
	public String loginDTO(@RequestBody LoginDTO customer, HttpServletResponse response) throws LoginException {

		Cookie cookie = new Cookie("jwt", this.custService.login(customer));

		response.addCookie(cookie);
		return "Login Success !";
	}

	@PostMapping("logout")
	public String logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("jwt", "");
		response.addCookie(cookie);
		return "Logout Success.";
	}
}