package com.training;

import java.util.*;

public class Application {

	public static void main(String[] args) {
		
		CreditCard card1 = new CreditCard(1234, "Abhineet", 24000);
		CreditCard card2 = new CreditCard(2345, "Abhi", 25000);
		CreditCard card3 = new CreditCard(1, "xyz", 26000);
			
		CreditCardService service = new CreditCardService();

		service.add(card1,card2,card3);
		
		List<CreditCard> list = service.findAll();
		
		for(CreditCard l : list) {
			System.out.println(l);
		}
				
		System.out.println("====================================================");
		
		List<CreditCard> list2 = service.sortedList("CardLimit");
		
		for(CreditCard l : list2) {
			System.out.println(l);
		}
		
		System.out.println("====================================================");
		
		List<CreditCard> list3 = service.sortedList("CardNumber");
		
		for(CreditCard l : list3) {
			System.out.println(l);
		}
		
		// creating new credit card
		CreditCard card4 = new CreditCard(234, "XYZ", 230000);		
		service.add(card4);
		
		// creating transactions
		Transaction trans1 = new Transaction("109XT8", "debited", 5000);
		Transaction trans2 = new Transaction("109XT9", "debited", 5000);
		Transaction trans3 = new Transaction("109XT10", "debited", 5000);
		
		// adding transactions to a particular card
		card4.addTransaction(trans1);
		card4.addTransaction(trans2);
		card4.addTransaction(trans3);
		
		// printing the transactions
		card4.printAllTransactions();
		
		// usage of HashMap
		HashMap<String, CreditCard> cardMap = new HashMap<String,CreditCard>();
		
		cardMap.put(card1.getCardHolderName(), card1);
		cardMap.put(card2.getCardHolderName(), card2);
		
		System.out.println(cardMap.get("Abhineet"));
		
		Set<Map.Entry<String, CreditCard>> setView = cardMap.entrySet();
		
		for(Map.Entry<String, CreditCard> k : setView) {
			
			System.out.println("Key is := " + k.getKey() + "\nValue is := " + k.getValue());
		}

		
	}

}
