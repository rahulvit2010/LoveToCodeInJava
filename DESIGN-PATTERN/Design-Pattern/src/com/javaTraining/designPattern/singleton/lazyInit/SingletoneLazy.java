package com.javaTraining.designPattern.singleton.lazyInit;

public class SingletoneLazy {
	
	private static  SingletoneLazy INSTANCE=null;
	
	private SingletoneLazy()
	{
		
	}
	
	public static  SingletoneLazy getInstance()
	{
		if(INSTANCE==null)
		{
			INSTANCE= new SingletoneLazy();
		}
	return INSTANCE;		
	}

}
