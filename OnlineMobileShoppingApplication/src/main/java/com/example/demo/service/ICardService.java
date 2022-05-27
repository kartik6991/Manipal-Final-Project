package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.AddCardToPaymentDTO;
import com.example.demo.entities.Card;
import com.example.demo.exception.CardException;
import com.example.demo.exception.PaymentException;

public interface ICardService{

	Card addCard(Card card) throws CardException;

	Card updateCard(Card card) throws CardException;

	List<Card> showAllCard();

	String deleteCardById(String cardNo) throws CardException;

	Card showCardById(String cardNo) throws CardException;

	Card addCardToPayment(AddCardToPaymentDTO addCardDTO) throws PaymentException, CardException;
}
