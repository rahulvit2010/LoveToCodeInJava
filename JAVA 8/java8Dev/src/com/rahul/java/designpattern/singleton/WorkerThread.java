package com.rahul.java.designpattern.singleton;

public class WorkerThread implements Runnable {

	@Override
	public void run() {
		ThreadSafeSingleton	Instance=ThreadSafeSingleton.getInstance();
		System.out.println(Thread.currentThread().getId()+ " ---------------> ThreadSafeSingleton instance" +Instance);
	}

}
