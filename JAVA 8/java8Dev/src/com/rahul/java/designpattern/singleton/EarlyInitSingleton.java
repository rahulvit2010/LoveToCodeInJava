package com.rahul.java.designpattern.singleton;

public class EarlyInitSingleton {

	private static final EarlyInitSingleton Instance= new EarlyInitSingleton();
	private EarlyInitSingleton() {
		
	}
	
	public static EarlyInitSingleton getInstance()
	{
		return Instance;
	}

}
