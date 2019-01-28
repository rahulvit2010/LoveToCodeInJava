package com.javaTraining.designPattern.Proxy;

public class ProxyPatternTest {

	public static void main(String[] args) {

		CommandExecutorProxy proxycls= new CommandExecutorProxy("rahul","password1234");
		try {
			proxycls.runCommand("ls -ltr");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
