package com.exercise.day4A1;

public class RangeCheckException extends Exception {

	@Override
	public String getMessage() {
		
		System.out.println("Marks should be in the Range of 0-100");
		
		return "Marks should be in the Range of 0-100";
	}

}
