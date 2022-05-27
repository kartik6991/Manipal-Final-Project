package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Card;

public interface ICardRepository extends MongoRepository<Card, String>{
}
