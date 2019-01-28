package com.javaTraining.designPattern.decoratorPattern;

public class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	public void assemble(){  
	       car.assemble(); 
	       System.out.print(" Adding features of Sports Car.");    
	 } 


}
