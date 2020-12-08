package com.example.model;

public class SavingAccount extends BankAccount {
	
	private String nominee;

	public SavingAccount(String accountNumber, String accountHolderName, double currentBalance, String nominee) {
		super(accountNumber, accountHolderName, currentBalance);
		this.nominee = nominee;
	}

	@Override
	public double deposit(double amount) {
		
		double newBalance = 0.0;
		
		if(amount > 100000) {
			System.out.println("Maximum Amount Deposit Limit Crossed");
			
			newBalance = this.getCurrentBalance();
		}
		else {
			newBalance = this.getCurrentBalance() + amount;
			
			this.setCurrentBalance(newBalance);
		}

		return newBalance;
	}

	@Override
	public double withdraw(double amount) {
		
		double newBalance = 0.0;
		
		if(this.getCurrentBalance() - amount < 5000) {
			System.out.println("Should Maintain A Minimum Balance of 5000");
			
			newBalance = this.getCurrentBalance();
		}
		else {
			newBalance = this.getCurrentBalance() - amount;
			
			this.setCurrentBalance(newBalance);
		}
		
		return newBalance;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

}
