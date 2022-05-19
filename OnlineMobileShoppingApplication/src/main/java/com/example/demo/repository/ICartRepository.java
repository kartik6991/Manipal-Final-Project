package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Mobile;

public interface ICartRepository extends MongoRepository<Cart, Integer> {
//	Cart saveAll(List<Mobile> mobiles);
}
