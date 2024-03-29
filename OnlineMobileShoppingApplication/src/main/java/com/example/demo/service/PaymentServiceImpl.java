package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AddCardToPaymentDTO;
import com.example.demo.entities.Card;
import com.example.demo.entities.Payment;
import com.example.demo.exception.CardException;
import com.example.demo.exception.PaymentException;
import com.example.demo.repository.ICardRepository;
import com.example.demo.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	private IPaymentRepository paymentRepo;
	@Autowired
	private ICardRepository cardRepo;
	
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
	public String deletePayment(String id) throws PaymentException {
		this.paymentRepo.deleteById(id);
		return "Payment is cancelled";
	}

	@Override
	public List<Payment> showAllPayments() {
		return paymentRepo.findAll();
	}

	@Override
	public Payment showPaymentById(String id) throws PaymentException {
		Optional<Payment> paymentOptional = this.paymentRepo.findById(id);
		if (paymentOptional.isEmpty())
			throw new PaymentException("Payment Id doesn't exist");
		return paymentOptional.get();
	}
	
	@Override
	public Payment addCardToPayment(AddCardToPaymentDTO addcardDTO)throws CardException, PaymentException{
		Optional<Card>cardOpt=this.cardRepo.findById(addcardDTO.getCardNumber());
		if (cardOpt.isEmpty())
			throw new CardException("Card Id doesn't exist");
		Card card=cardOpt.get();
		Optional<Payment>paymentOpt=this.paymentRepo.findById(addcardDTO.getPaymentId());
		if (paymentOpt.isEmpty())
			throw new PaymentException("Payment Id doesn't exist");
		Payment payment=paymentOpt.get();
		if(payment.getCard()==null)
			payment.setCard(card);
		return this.paymentRepo.save(payment);
	}
}
