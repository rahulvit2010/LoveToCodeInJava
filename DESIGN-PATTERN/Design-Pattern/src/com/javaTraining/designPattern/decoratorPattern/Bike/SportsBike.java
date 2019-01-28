package com.javaTraining.designPattern.decoratorPattern.Bike;

public class SportsBike extends BikeDecorator {

	public SportsBike(Bike bike) {
		super(bike);
		// TODO Auto-generated constructor stub
	}
	
	public void bikeAssemble() {
		// TODO Auto-generated method stub
		bike.bikeAssemble();
		System.out.println("....Sports bike assembled..");
		
	}

}
