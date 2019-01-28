package com.javaTraining.designPattern.singleton.staticBlock;

public class SingletoneStaticBlock {
	
	private static SingletoneStaticBlock INSTANCE=null;
	private SingletoneStaticBlock()
	{
		
	}
	static{
		INSTANCE=new SingletoneStaticBlock();
	}

	public static SingletoneStaticBlock getInstance()
	{
		return INSTANCE;
	}
}
