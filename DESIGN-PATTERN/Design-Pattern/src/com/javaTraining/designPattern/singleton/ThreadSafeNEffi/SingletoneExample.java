package com.javaTraining.designPattern.singleton.ThreadSafeNEffi;

//Double check locking
public class SingletoneExample {
	
	private static SingletoneExample INSTANCE=null;
	
	private SingletoneExample()
	{
		
	}
	
	public static  SingletoneExample getInstance()
	{
		if(INSTANCE==null)
		{
			synchronized(SingletoneExample.class)
			{
				if(INSTANCE==null)
				{
					INSTANCE= new SingletoneExample();
				}
			}
			
		}
		return INSTANCE;
		
	}

}
