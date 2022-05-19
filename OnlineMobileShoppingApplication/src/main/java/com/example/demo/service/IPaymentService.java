package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Payment;
import com.example.demo.exception.PaymentException;

public interface IPaymentService {
	public Payment addPayment(Payment payment) throws PaymentException;

	public Payment updatePayment(Payment payment) throws PaymentException;

	public String deletePayment(Integer id) throws PaymentException;

	public List<Payment> showAllPayments();
}
