package com.training;

import java.util.Comparator;

public class CreditLimitComparator implements Comparator<CreditCard> {

	@Override
	public int compare(CreditCard o1, CreditCard o2) {
		
		if(o1.getCardLimit() > o2.getCardLimit())		return 1;
		
		if(o1.getCardLimit() < o2.getCardLimit())		return -1;

		return 0;
	}

}
