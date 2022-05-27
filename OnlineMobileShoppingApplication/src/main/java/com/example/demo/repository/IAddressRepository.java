package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Address;

public interface IAddressRepository extends MongoRepository<Address, String> {

}
