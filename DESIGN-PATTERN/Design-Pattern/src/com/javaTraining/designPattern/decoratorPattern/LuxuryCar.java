package com.javaTraining.designPattern.decoratorPattern;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override     
	public void assemble(){ 
	        car.assemble();         
	System.out.print(" Adding features of Luxury Car.");    
	 } 

}
