package com.javaTraining.designPattern.singleton.ThreadSafe;

public class SingletoneSingleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis());
		 new Thread(()->System.out.println("first thread"+SingletoneExample.getInstance())).start();
		 new Thread(()->System.out.println("second thread"+SingletoneExample.getInstance())).start();
		 new Thread(()->System.out.println("third thread"+SingletoneExample.getInstance())).start();
		 new Thread(()->System.out.println("forth thread"+SingletoneExample.getInstance())).start();
		 new Thread(()->System.out.println("fifth thread"+SingletoneExample.getInstance())).start();
		 System.out.println(System.currentTimeMillis());
		 new Thread(()->System.out.println("djkhasjk"));
	}

}
