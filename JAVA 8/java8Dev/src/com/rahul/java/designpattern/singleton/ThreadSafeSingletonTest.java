package com.rahul.java.designpattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeSingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ExecutorService executor= Executors.newFixedThreadPool(50);
	
	for(int i=0;i<50;i++)
	{
		Runnable worker= new WorkerThread();
		executor.execute(worker);
	}

	 executor.shutdown();
     while (!executor.isTerminated()) {
     }
     System.out.println("Finished all threads");
     
	}

}
