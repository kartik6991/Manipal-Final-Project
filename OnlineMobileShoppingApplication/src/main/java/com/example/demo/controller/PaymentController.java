package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Payment;
import com.example.demo.exception.PaymentException;
import com.example.demo.service.IPaymentService;

@RestController
@RequestMapping("api")
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;
	
	@GetMapping("payments")
	public List<Payment> getAllPayments(){
		return this.paymentService.showAllPayments();
	}
	
	@PostMapping("addPayment")
	public Payment createPayment(@RequestBody Payment payment) throws PaymentException {
		return this.paymentService.addPayment(payment);
	}
	
	@DeleteMapping("cancelPayment/{id}")
	public String cancelPayment(@PathVariable("id") String id) throws PaymentException {
		return this.paymentService.deletePayment(id);
	}
	
	@PutMapping("updatePayment")
	public Payment updatePayment(@RequestBody Payment payment) throws PaymentException {
		return this.paymentService.updatePayment(payment);
	}
	
	@GetMapping("payment/{id}")
	public Payment showPaymentById(@PathVariable("id") String id)throws PaymentException {
		return this.paymentService.showPaymentById(id);
	}
	
	
}
