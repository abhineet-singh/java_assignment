package com.exercise.interface_runtime_poly;

public class SoftwareEngineer implements Billable {
	
	private double yearsOfExperience;

	public SoftwareEngineer(double yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	@Override
	public double calculate() {
		
		double salary = 0.0;
		
		if(this.getYearsOfExperience() <= 2) {
			salary = 50000.0;
		}
		else {
			salary = 65000.0;
		}
		
		return salary;
	}
	
	public double getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(double yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

}
