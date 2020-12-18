package com.training.service;

import com.training.model.User;

public class Validator {
	
	public boolean validate(User user) {
		
		boolean result = false;
		
		if(user.getUserName().equals("Abhineet") && user.getPassword().equals("india"))	{
			result =  true;
		}
		
		return result;
	}

}
