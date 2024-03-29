package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AddtoCartDTO;
import com.example.demo.entities.Cart;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.MobileException;
import com.example.demo.service.ICartService;


@CrossOrigin(value="http://localhost:3000/")
@RestController
@RequestMapping("api")

public class CartController {
	@Autowired
	private ICartService cartService;
	
	@PostMapping("addcart")
	public Cart addToCart(@RequestBody AddtoCartDTO cartDTO) throws CustomerException,MobileException{
		return this.cartService.addMobileToCart(cartDTO);
	}
	
	@DeleteMapping("deletecart")
	public Cart deleteMobileItemsfromCart(@RequestBody AddtoCartDTO cartDTO) throws CustomerException,MobileException{
		return this.cartService.deleteMobileItemsfromCart(cartDTO);
	}
}
