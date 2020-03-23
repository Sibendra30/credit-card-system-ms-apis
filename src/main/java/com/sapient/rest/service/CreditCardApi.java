package com.sapient.rest.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.rest.model.CreditCard;
import com.sapient.rest.model.MemoryDB;
import com.sapient.rest.util.CommonValidator;

@RestController
public class CreditCardApi {
	
	@GetMapping("/credit-cards")
	public List<CreditCard> getAllCards() {
		return MemoryDB.getAllCardInfo();
	}
	
	@PostMapping("/credit-cards/add")
	public boolean addCreditCard(@RequestBody CreditCard card) {
		this.validate(card);
		return MemoryDB.addNewCC(card);
	}
	
	private void validate(CreditCard card) {
		if (card == null) {
			System.out.println("Bad Request");
		}
		
		if (card.getCcNumber() == null || card.getCcNumber().isEmpty()) {
			System.out.println("Mandatory param ccNumber missing");
		}
		
		if (card.getName() == null || card.getName().isEmpty()) {
			System.out.println("Mandatory param customer name missing");
		}
		
		if (!CommonValidator.validateLuhn10(card.getCcNumber())) {
			System.out.println("Bad CC Number in request");
		}
	}
	 
}
