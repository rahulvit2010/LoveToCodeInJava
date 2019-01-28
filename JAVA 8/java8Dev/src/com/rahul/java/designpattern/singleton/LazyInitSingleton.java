package com.rahul.java.designpattern.singleton;

public class LazyInitSingleton {
	
	private static LazyInitSingleton Instance=null;
	
	private LazyInitSingleton()
	{
		
	}
    public static LazyInitSingleton getInstance()
    {
    	if(Instance==null)
    	{
    		Instance= new LazyInitSingleton();
    	}
    	return Instance;
    }
}
