package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Feedback;

public interface IFeedbackRepository extends MongoRepository<Feedback, String> {
}
