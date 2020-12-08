package com.exercise.interface_runtime_poly;

public class Plumber implements Billable {
	
	private String skillLevel;

	public Plumber(String skill) {
		this.skillLevel = skill;
	}

	@Override
	public double calculate() {
		
		double salary = 0.0;
		
		if(this.getSkillLevel().equalsIgnoreCase("High")) {
			salary = 20000.0;
		}
		else {
			salary = 12000.0;
		}
		
		return salary;
	}
	
	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	

}
