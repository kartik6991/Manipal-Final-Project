package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.entities.LoginDTO;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.LoginException;
import com.example.demo.repository.ICustomerRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Optional<Customer> newCustomer = this.customerRepo.findById(customer.getCustomerId());
		if (newCustomer.isPresent())
			throw new CustomerException("Customer account already existed");
		return this.customerRepo.save(customer);
	}
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		return this.customerRepo.save(customer);
	}
	@Override
	public String cancelCustomer(String customerId) throws CustomerException {
		this.customerRepo.deleteById(customerId);
		return "Customer account deleted successfully";
	}
	@Override
	public List<Customer> showAllCustomers() {
		return customerRepo.findAll();
	}
	@Override
	public Customer showCustomerById(String customerId) throws CustomerException {
		Optional<Customer> customerOptional = this.customerRepo.findById(customerId);
		if (customerOptional.isEmpty())
			throw new CustomerException("Customer Id doesn't exist");
		return customerOptional.get();
	}
	@Override
	public String login(LoginDTO loginDTO) throws LoginException {
		Customer foundCustomer= this.customerRepo.findByEmailId(loginDTO.getEmailId());
		
		if (foundCustomer== null)
			throw new LoginException("Customer with EmailID doesnt exist");
		
		if (!foundCustomer.getCustomerPassword().equals(loginDTO.getPassword()))
			throw new LoginException("Password does't match.");
				
		String issuer = loginDTO.getEmailId();
		Date expiry = new Date(System.currentTimeMillis() + (60 * 60 * 1000));
		
		String jwt = Jwts.builder().setIssuer(issuer).setExpiration(expiry)
				.signWith(SignatureAlgorithm.HS512, "Secret123").compact();
		
		return jwt;
	}
}