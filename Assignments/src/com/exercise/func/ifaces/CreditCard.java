package com.exercise.func.ifaces;

import java.util.*;

public class CreditCard {
	
	private int cardNumber;
	private String cardHolderName;
	private int cardLimit;
	
	public CreditCard() {
	}

	public CreditCard(int cardNumber, String cardHolderName, int cardLimit) {
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cardLimit = cardLimit;	
	}
		
	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public int getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(int cardLimit) {
		this.cardLimit = cardLimit;
	}

	
	
}
