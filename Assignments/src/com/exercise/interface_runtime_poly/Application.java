package com.exercise.interface_runtime_poly;

public class Application {
	
	public static void printSalary(Billable person) {

		System.out.println(person.calculate());
	}

	public static void main(String[] args) {
		
		SoftwareEngineer newSE = new SoftwareEngineer(3);
		Plumber newPlumber = new Plumber("High");
		Advocate newAdvocate = new Advocate("Senior");
		
		printSalary(newSE);
		printSalary(newPlumber);
		printSalary(newAdvocate);

	}

}
