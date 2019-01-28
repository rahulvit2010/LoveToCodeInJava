package com.javaTraining.designPattern.flyweight;

public class CPlatform implements Platform {
	
	public CPlatform(){
		System.out.println("CPlatform object created");
	}

	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing C code.");
	}

}