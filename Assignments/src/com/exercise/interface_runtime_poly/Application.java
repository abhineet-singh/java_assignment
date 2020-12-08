package com.exercise.interface_runtime_poly;

public class Application {
	
	public static void printSalary(Billable person) {

		System.out.println(person.calculate());
	}
	
// this method is a factory method which returns an instance of Billable
	public static Billable getProfessionObject(int key) {
		
		switch(key) {
		case 1: 
			return new SoftwareEngineer(3);
		case 2:
			return new Plumber("High");
		case 3:
			return new Advocate("Senior");
		default:
			return null;
			
		}
	}
	
	public static void main(String[] args) {
		
		Billable obj = getProfessionObject(Integer.parseInt(args[0]));
		
		printSalary(obj);
	}

}
