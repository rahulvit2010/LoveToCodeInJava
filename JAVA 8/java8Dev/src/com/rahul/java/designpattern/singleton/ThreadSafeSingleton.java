package com.rahul.java.designpattern.singleton;

public class ThreadSafeSingleton {
	
	private static ThreadSafeSingleton Instance=null;
	
private ThreadSafeSingleton() {
	
}

public static  ThreadSafeSingleton getInstance()
{
	if(Instance==null)
	{
		synchronized(ThreadSafeSingleton.class)
		{
			if(Instance==null)
			{
				Instance= new ThreadSafeSingleton();
				
			}
		}
	}
	return Instance;
}
}
