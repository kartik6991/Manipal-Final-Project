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
public class CardServiceImpl implements ICardService{
	@Autowired
	private ICardRepository cardRepo;
	@Autowired
	private IPaymentRepository paymentRepo;

	@Override
	public Card addCard(Card card) throws CardException {
		Optional<Card> newCard = this.cardRepo.findById(card.getCardNumber());
		if (newCard.isPresent())
			throw new CardException("Already card added");
		return this.cardRepo.save(card);
	}

	@Override
	public Card updateCard(Card card) throws CardException {
		return this.cardRepo.save(card);
	}

	@Override
	public String deleteCardById(String cardNo) throws CardException {
		this.cardRepo.deleteById(cardNo);
		return "Card deleted successfully";
	}

	@Override
	public List<Card> showAllCard() {
		return cardRepo.findAll();
	}
	

	@Override
	public Card showCardById(String cardNo) throws CardException {
		Optional<Card> cardOptional = this.cardRepo.findById(cardNo);
		if (cardOptional.isEmpty())
			throw new CardException("Card number doesn't exist");
		return cardOptional.get();
	}
	
	@Override
	public Card addCardToPayment(AddCardToPaymentDTO addCardDTO) throws PaymentException, CardException{
		Optional<Payment>paymentOpt=this.paymentRepo.findById(addCardDTO.getPaymentId());
		if (paymentOpt.isEmpty())
			throw new PaymentException("Payment Id doesn't exist");
		Optional<Card> cardOptional = this.cardRepo.findById(addCardDTO.getCardNumber());
		if (cardOptional.isEmpty())
			throw new CardException("Card number doesn't exist");
		Payment payment=paymentOpt.get();
		Card card=cardOptional.get();
		if(payment.getCard()==null)
			payment.setCard(card);
		this.paymentRepo.save(payment);
		return payment.getCard();
	}
}
