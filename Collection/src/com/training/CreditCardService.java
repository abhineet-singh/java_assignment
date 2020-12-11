package com.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreditCardService implements DataAccess<CreditCard> {
	
	private List<CreditCard> creditList;

	public CreditCardService() {
		this.creditList = new ArrayList<CreditCard>();
	}

	@Override
	public boolean add(CreditCard ...cards) {	
		
		for(CreditCard card : cards) {
			this.creditList.add(card);
		}
		
		return true;
	}

	@Override
	public CreditCard findById(int id) {
		return null;
	}

	@Override
	public List<CreditCard> findAll() {
		return this.creditList;
	}

	@Override
	public List<CreditCard> sortedList(String sortByField) {
		
		switch (sortByField) {
		case "CardNumber": 
			Collections.sort(this.creditList,new CardNumberComparator());
			break;
		case "CardLimit" :
			Collections.sort(this.creditList,new CreditLimitComparator());
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + sortByField);
		}
		
		return this.creditList;	
	}

}
