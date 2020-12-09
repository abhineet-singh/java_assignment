package com.exercise.day4A1;

public class Student {
	
	private String name;
	private double marksScored;
	private int rollNumber;
	
	public Student(String name, double marksScored, int rollNumber) throws RangeCheckException {
		this.name = name;
		this.rollNumber = rollNumber;
		
		if(marksScored < 0 || marksScored > 100) {
			System.out.print("In constructor ");
			
			throw new RangeCheckException();
		}
		else {
			this.marksScored = marksScored;
		}
	}

	public Student() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(double marksScored) {
		
		if(marksScored < 0 || marksScored > 100) {
			
			System.out.print("In Setter Method ");
			
			RangeCheckException e = new RangeCheckException();
			
			e.getMessage();		
		}
		else {
			this.marksScored = marksScored;
		}	
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	
	
	
}
