package com.sapient.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sapient.rest.model.CreditCard;
import com.sapient.rest.model.MemoryDB;

@Service
public class GetCreditCards implements IGetCreditCards {

	@Override
	public List<CreditCard> getAllCreditCards() {
		return MemoryDB.getAllCardInfo();
	}

}
