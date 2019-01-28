package com.rahul.java.designpattern.singleton;

public class EarlyInitSingletonTest {

	public static void main(String[] args) {
		// 
		
		
		System.out.println("early init test");
		EarlyInitSingleton object1=EarlyInitSingleton.getInstance();
		EarlyInitSingleton object2=EarlyInitSingleton.getInstance();
		
		System.out.println("both objects are equels:::");
		System.out.println((object1==object2));

	}

}
