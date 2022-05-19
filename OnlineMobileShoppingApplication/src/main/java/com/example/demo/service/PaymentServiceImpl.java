package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Order;
import com.example.demo.entities.Payment;
import com.example.demo.exception.OrderException;
import com.example.demo.exception.PaymentException;
import com.example.demo.repository.IPaymentRepository;

public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	private IPaymentRepository paymentRepo;

	@Override
	public Payment addPayment(Payment payment) throws PaymentException {
		Optional<Payment> newPayment = this.paymentRepo.findById(payment.getPaymentId());
		if (newPayment.isPresent())
			throw new PaymentException("Already paid");
		return this.paymentRepo.save(payment);
	}

	@Override
	public Payment updatePayment(Payment payment) throws PaymentException {
		return this.paymentRepo.save(payment);
	}

	@Override
	public String deletePayment(Integer id) throws PaymentException {
		this.paymentRepo.deleteById(id);
		return "Payment is cancelled";
	}

	@Override
	public List<Payment> showAllPayments() {
		return paymentRepo.findAll();
	}

}
