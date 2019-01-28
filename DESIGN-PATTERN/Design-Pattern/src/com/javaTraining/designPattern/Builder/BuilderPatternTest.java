package com.javaTraining.designPattern.Builder;

public class BuilderPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Computer computer = new Computer.ComputerBuilder("200GB","10GB").build();
	     System.out.println(computer);
	     
	     //grphics enabled computer
	     System.out.println("****Grapchics enabled Computer***  ");
	     Computer computer1 = new Computer.ComputerBuilder("200GB","10GB").setGraphicsCardEnabled(true).build();
	     System.out.println(computer1);
	     

	     System.out.println("****wifi enabled Computer***  ");
	     Computer computer2 = new Computer.ComputerBuilder("200GB","10GB")
	    		 .setGraphicsCardEnabled(true)
	    		 .setWiFiCardEnabled(true)
	    		 .build();
	     System.out.println(computer2);
	}
}
