package com.sapient.rest.service;

import org.springframework.stereotype.Service;

import com.sapient.rest.model.CreditCard;
import com.sapient.rest.model.MemoryDB;
import com.sapient.rest.util.CommonValidator;

@Service
public class AddNewCreditCardService implements IAddNewCreditCardService {

	@Override
	public boolean addCreditCard(CreditCard card) {
		if(this.validate(card)) {
			return MemoryDB.addNewCC(card);
		}
		return false;
	}
	
	private boolean validate(CreditCard card) {
		if (card == null) {
			System.out.println("Bad Request");
			return false;
		}
		
		if (card.getCcNumber() == null || card.getCcNumber().isEmpty() || card.getCcNumber().length() != 16) {
			System.out.println("Mandatory param ccNumber missing");
			return false;
		}
		
		if (card.getName() == null || card.getName().isEmpty()) {
			System.out.println("Mandatory param customer name missing");
			return false;
		}
		
		if (!CommonValidator.validateLuhn10(card.getCcNumber())) {
			System.out.println("Bad CC Number in request");
			return false;
		}
		
		return true;
	}

}
