package com.exercise.day4A1;

public class Application {
	
	public static void main(String[] args) {
		
		Student student_1;
		
		try {
			student_1 = new Student("Abhineet",78,1);
			
			student_1.setMarksScored(107);
		} 
		catch (RangeCheckException e) {
			e.getMessage();
		}
			
		Student student_2;
		
		try {
			student_2 = new Student("Abhineet",106,1);
		} 
		catch (RangeCheckException e) {
			e.getMessage();
		}
		
		
	}

}
