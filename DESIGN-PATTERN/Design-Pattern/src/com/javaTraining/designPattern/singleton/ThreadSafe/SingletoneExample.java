package com.javaTraining.designPattern.singleton.ThreadSafe;

public class SingletoneExample {
	
	private static SingletoneExample INSTANCE=null;
	
	private SingletoneExample()
	{
		
	}
	
	public static synchronized SingletoneExample getInstance()
	{
		if(INSTANCE==null)
		{
			INSTANCE= new SingletoneExample();
		}
		return INSTANCE;
		
	}

}
