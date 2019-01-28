package com.javaTraining.designPattern.singleton.earlyInit;

public class SingletonEarly {
	
private static final SingletonEarly INSTANCE=new SingletonEarly();

private SingletonEarly()
{
	
}

public static SingletonEarly getInstance()
{
	return INSTANCE;
}
}
