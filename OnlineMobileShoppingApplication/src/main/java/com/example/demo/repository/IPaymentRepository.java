package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Payment;

public interface IPaymentRepository extends MongoRepository<Payment, String> {
}
