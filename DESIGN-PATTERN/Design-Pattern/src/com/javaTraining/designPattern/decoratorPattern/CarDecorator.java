package com.javaTraining.designPattern.decoratorPattern;

public class CarDecorator implements Car {
	
	   protected Car car;           
	   public CarDecorator(Car c){  
	          this.car=c;    
	    }          


	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		System.out.println("in car decorator");
	       this.car.assemble();    
	}

}
                                                        