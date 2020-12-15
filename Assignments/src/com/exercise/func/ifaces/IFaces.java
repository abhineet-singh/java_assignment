package com.exercise.func.ifaces;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class IFaces {
	
	public static boolean checkNameLimit(CreditCard card, String name, Integer limit) {
		
		BiFunction<String, Integer, Boolean> check = (nameToCheck,limitToCheck) -> {
			 
			if(card.getCardHolderName().equals(nameToCheck) && card.getCardLimit() == limitToCheck)
				return true;
			else
				return false;
					
		};
		
		return check.apply(name, limit);
	}
	
	public static CreditCard retConstructor(Integer num) {
		
		Supplier<CreditCard> lambda1 = () -> new CreditCard();
		
		Supplier<CreditCard> lambda2 = () -> {return (new CreditCard(1234, "abhineet", 14000));};
		
		if(num == 0)	return lambda1.get();
		
		else		return lambda2.get();
		
		
	}

}
