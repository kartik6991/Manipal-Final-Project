package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.exception.CustomerException;
import com.example.demo.repository.ICustomerRepository;

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
	public String cancelCustomer(Integer customerId) throws CustomerException {
		this.customerRepo.deleteById(customerId);
		return "Customer account deleted successfully";
	}

	@Override
	public List<Customer> showAllCustomers() {
		return customerRepo.findAll();
	}
}
