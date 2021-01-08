package com.experiment;

public class Abhineet implements Interf{
	
	public String name;
	public String id;
	
	public Abhineet(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public void show() {
		System.out.println("show something");
		
		return ;
		
	}

}
