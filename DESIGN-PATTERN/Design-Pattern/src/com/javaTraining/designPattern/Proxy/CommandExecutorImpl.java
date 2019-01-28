package com.javaTraining.designPattern.Proxy;

import java.io.IOException;

public class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String command) throws IOException {
		// TODO Auto-generated method stub
      Runtime.getRuntime().exec(command);
      System.out.println("'"+ command +"' command Executed.");
	}

}
