package com.javaTraining.designPattern.decoratorPattern.Bike;

public class TestDecorator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SportsBike sprtsBike= new SportsBike(new BasicBike());
		sprtsBike.bikeAssemble();

	}

}
