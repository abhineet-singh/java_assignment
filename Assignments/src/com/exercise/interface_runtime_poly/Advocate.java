package com.exercise.interface_runtime_poly;

public class Advocate implements Billable {
	
	private String seniorityLevel;
	
	public Advocate(String seniorityLevel) {
		super();
		this.seniorityLevel = seniorityLevel;
	}

	@Override
	public double calculate() {
		
		double salary = 0.0;
		
		if(this.getSeniorityLevel().equalsIgnoreCase("Junior")) {
			salary = 35000.0;
		}
		else if(this.getSeniorityLevel().equalsIgnoreCase("Senior")){
			salary = 50000.0;
		}
		else {
			salary = 60000.0;
		}
		
		return salary;
	}
	
	public String getSeniorityLevel() {
		return seniorityLevel;
	}

	public void setSeniorityLevel(String seniorityLevel) {
		this.seniorityLevel = seniorityLevel;
	}

}
