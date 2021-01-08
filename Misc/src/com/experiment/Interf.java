package com.experiment;

public interface Interf {

	public static final int x_var = 0;
	
	public abstract void show();
	
	default void normal_print() {
		
		System.out.println("normal print");
	}
}
