package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.CustomerException;
import com.example.demo.exception.MobileException;
import com.example.demo.exception.OrderException;

@RestControllerAdvice
public class OnlineMobileShoppingApplicationControllerAdvice {
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerException.class)
	public String customerExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(MobileException.class)
	public String mobileExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(OrderException.class)
	public String orderExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(addressException.class)
	public String addressExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(categoryException.class)
	public String categoryExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(cartException.class)
	public String cartExceptionHandler(Exception e) {
		return e.getMessage();
	}
}
