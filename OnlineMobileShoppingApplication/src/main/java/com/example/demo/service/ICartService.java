package com.example.demo.service;

import com.example.demo.entities.AddtoCartDTO;
import com.example.demo.entities.Cart;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.MobileException;

public interface ICartService {

	Cart addMobileToCart(AddtoCartDTO cartDTO) throws CustomerException, MobileException;

	Cart deleteMobileItemsfromCart(AddtoCartDTO cartDTO) throws CustomerException, MobileException;
}
