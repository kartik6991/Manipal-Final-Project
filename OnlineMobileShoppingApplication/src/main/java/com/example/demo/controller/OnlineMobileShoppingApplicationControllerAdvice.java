package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.MobileNotFoundException;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.exception.UserNotFoundException;

public class OnlineMobileShoppingApplicationControllerAdvice {
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public String customerExceptionHandler(Exception e) {
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(MobileNotFoundException.class)
	public String mobileExceptionHandler(Exception e) {
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(OrderNotFoundException.class)
	public String orderExceptionHandler(Exception e) {
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public String userExceptionHandler(Exception e) {
		return e.getMessage();
	}
}
