package com.sapient.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.rest.model.CreditCard;
import com.sapient.rest.service.IAddNewCreditCardService;
import com.sapient.rest.service.IGetCreditCards;

@RestController
public class CreditCardApi {

	@Autowired
	private IAddNewCreditCardService addNewCreditCardService;
	
	@Autowired
	private IGetCreditCards getCreditCards;

	@GetMapping("/credit-cards")
	public ResponseEntity<List<CreditCard>> getAllCards() {
		return new ResponseEntity<>(getCreditCards.getAllCreditCards(), HttpStatus.OK);
	}

	@PostMapping("/credit-cards/add")
	public ResponseEntity<Boolean> addCreditCard(@RequestBody CreditCard card) {
		boolean status = addNewCreditCardService.addCreditCard(card);
		if (status) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

}
