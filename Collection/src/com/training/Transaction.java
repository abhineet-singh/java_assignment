package com.training;

public class Transaction {

	private String id;
	private String description;
	private double amount;
	
	public Transaction() {
	}

	public Transaction(String id, String description, double amount) {
		this.id = id;
		this.description = description;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", description=" + description + ", amount=" + amount + "]";
	}
	
	
}
