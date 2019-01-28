package com.rahul.java.designpattern.singleton;

public class LazyInitSingletonTest {

	public static void main(String[] args) {

		LazyInitSingleton instance1=LazyInitSingleton.getInstance();
		LazyInitSingleton instance2= LazyInitSingleton.getInstance();
		
		System.out.println("lazy init singleton");
		
		System.out.println((instance1==instance2));

	}

}
