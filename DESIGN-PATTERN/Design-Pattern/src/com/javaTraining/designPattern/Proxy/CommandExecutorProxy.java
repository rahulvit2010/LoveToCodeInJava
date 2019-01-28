package com.javaTraining.designPattern.Proxy;

import java.util.Collections;

public class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin=false;
	private CommandExecutor commandExecutor;
	
	@Override
	public void runCommand(String command) throws Exception {
		// TODO Auto-generated method stub
		if(isAdmin)
		{
			commandExecutor.runCommand(command);	
		}
		else if(command.trim().startsWith("rm"))
		{
			throw new Exception(" rm  command is not allowed for non  admin user");
		}
		else
		{
			commandExecutor.runCommand(command);
		}

	}
	public CommandExecutorProxy(String userName, String passWord)
	{
		if(("rahul").equals(userName) && ("password").equals(passWord))
		{
			isAdmin=true;
		}
		commandExecutor= new CommandExecutorImpl();
	}

}
