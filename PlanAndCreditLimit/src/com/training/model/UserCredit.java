package com.training.model;

import java.util.Map;
import java.util.HashMap;

public class UserCredit {
	
	private Map<String,Integer> userCreditMap;

	public UserCredit() {
		super();
		this.userCreditMap = new HashMap<String,Integer>();
		
		this.userCreditMap.put("abhineet", 2000);
		this.userCreditMap.put("xyz", 3000);
		this.userCreditMap.put("pqr", 2000);
	}

	
	public int updateCreditLimit(String userName, int deductionAmt) {
		
		int isDeductedSuccessfully = 1;
		
		if(this.userCreditMap.containsKey(userName)) {
			
			int currentLimitOfUser =  this.userCreditMap.get(userName);
			
			if(currentLimitOfUser >= deductionAmt) {
				
				currentLimitOfUser -= deductionAmt;
				
				this.userCreditMap.replace(userName, currentLimitOfUser);	
			}
			else {		
				isDeductedSuccessfully = 0;		
			}	
		}
		else {
			isDeductedSuccessfully = -1;
		}
		
		return isDeductedSuccessfully;
	}
	
	public int getCreditLimitOfUser(String userName) {
		
		int creditLimitAmt = 0;
		
		if(this.userCreditMap.containsKey(userName)) {
			
			creditLimitAmt = this.userCreditMap.get(userName);
		}
		
		return creditLimitAmt;
	}
}
