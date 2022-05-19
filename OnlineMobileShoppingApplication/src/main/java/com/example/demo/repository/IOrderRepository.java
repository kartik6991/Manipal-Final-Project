package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Order;

public interface IOrderRepository extends MongoRepository<Order, Integer> {
}
