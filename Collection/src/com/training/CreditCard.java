package com.training;

import java.util.*;

public class CreditCard {
	
	private int cardNumber;
	private String cardHolderName;
	private int cardLimit;
	private Set<Transaction> creditCardTransaction;
	
	public CreditCard() {
	}

	public CreditCard(int cardNumber, String cardHolderName, int cardLimit) {
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cardLimit = cardLimit;
		
		this.creditCardTransaction = new HashSet<Transaction>();	
	}
	
	public boolean addTransaction(Transaction trans) {
		
		this.creditCardTransaction.add(trans);
		
		return true;
	}
	
	public void printAllTransactions(){
		
		for(Transaction t : this.creditCardTransaction) {
			System.out.println(t);
		}
		
		return ;
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

	@Override
	public String toString() {
		return "CreditCard [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", cardLimit="
				+ cardLimit + ", creditCardTransaction=" + creditCardTransaction + "]";
	}
	
	
}
