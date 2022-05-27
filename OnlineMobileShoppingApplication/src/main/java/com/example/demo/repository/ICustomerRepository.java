package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Customer;

public interface ICustomerRepository extends MongoRepository<Customer, String> {

	Customer findByEmailId(String EmailId);


}
