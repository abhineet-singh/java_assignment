package com.example.model;

public class Application {

	public static void main(String[] args) {
		
		BankAccount account = new SavingAccount("1234","Abhineet",10000.0,"Abhineet");
		
		System.out.println("new balance := " + account.deposit(100001)); 
		
		System.out.println("new balance := " + account.withdraw(6000));

	}

}
