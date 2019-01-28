package com.javaTraining.designPattern.decoratorPattern.Bike;

public class BikeDecorator implements Bike {

	protected Bike bike;
	@Override
	public void bikeAssemble() {
		// TODO Auto-generated method stub
		this.bike.bikeAssemble();
		
	}
	public BikeDecorator(Bike bike) {
		this.bike = bike;
	}

}
