package com.javaTraining.designPattern.Factory;

public class FactoryofObjects {
	
	public static Computer getComputer(String type,String HDD,String RAM,String Processor)
	{
		Computer Instance=null;
		switch(type)
		{
		case "PC" :
			Instance= new PC(HDD,RAM,Processor);
		case "Server" :
			Instance= new Server(HDD,RAM,Processor);
			
		}
		return Instance;
	}

}
