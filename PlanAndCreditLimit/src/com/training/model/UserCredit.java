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

	public Map<String, Integer> getUserCreditMap() {
		return userCreditMap;
	}
	
	
	

}
