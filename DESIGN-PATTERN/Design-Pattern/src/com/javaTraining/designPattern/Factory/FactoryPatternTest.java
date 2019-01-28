package com.javaTraining.designPattern.Factory;

public class FactoryPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Computer pc=FactoryofObjects.getComputer("PC", "400GB", "8GB", "Intel i3");

		Computer server=FactoryofObjects.getComputer("Server", "4000GB", "80GB", "Intel i5");

		
		System.out.println("details of pc object");
		System.out.println(pc);
		
		
		System.out.println("details of server object");
		System.out.println(server);
	}

}
