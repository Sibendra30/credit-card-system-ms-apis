package com.sapient.rest.model;

import java.util.ArrayList;
import java.util.List;

public class MemoryDB {

	private static List<CreditCard> creditCards = new ArrayList<>();
	
	public static boolean addNewCC(CreditCard newCard) {
		return creditCards.add(newCard);
	}
	
	public static List<CreditCard> getAllCardInfo() {
		return creditCards;
	}
}
