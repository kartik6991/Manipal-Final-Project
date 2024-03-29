package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AddCardToPaymentDTO;
import com.example.demo.entities.Card;
import com.example.demo.exception.CardException;
import com.example.demo.exception.PaymentException;
import com.example.demo.service.ICardService;

@CrossOrigin(value="http://localhost:3000/")
@RestController
@RequestMapping("api")
public class CardController {
	@Autowired
	private ICardService cardService;
	
	@GetMapping("cards")
	public List<Card> getAllCards(){
		return this.cardService.showAllCard();
	}
	
	@PostMapping("addCard")
	public Card createCard(@RequestBody Card card) throws CardException {
		return this.cardService.addCard(card);
	}
	
	@DeleteMapping("cancelCard/{id}")
	public String cancelCard(@PathVariable("id") String id) throws CardException {
		return this.cardService.deleteCardById(id);
	}
	
	@PutMapping("updateCard")
	public Card updateCard(@RequestBody Card card) throws CardException {
		return this.cardService.updateCard(card);
	}
	
	@GetMapping("card/{id}")
	public Card showCardById(@PathVariable("id") String id)throws CardException {
		return this.cardService.showCardById(id);
	}
	
	@PostMapping("addcardtopayment")
	public Card addRatingtoMobile(@RequestBody AddCardToPaymentDTO addCardDTO) throws CardException, PaymentException{
		return this.cardService.addCardToPayment(addCardDTO);
	}
}
