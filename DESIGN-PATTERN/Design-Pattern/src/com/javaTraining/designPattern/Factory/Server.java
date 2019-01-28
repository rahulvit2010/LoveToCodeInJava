package com.javaTraining.designPattern.Factory;

public class Server extends Computer {
	
	private String HDD;
	private String RAM;
	private String Processor;
	
	@Override
	public String toString() {
		return "Server [HDD=" + HDD + ", RAM=" + RAM + ", Processor=" + Processor + "]";
	}

	public Server(String hDD, String rAM, String processor) {
		super();
		this.HDD = hDD;
		this.RAM = rAM;
		this.Processor = processor;
	}
	
	public  String getHDD(){
		return this.HDD;
	}

	public  String getRAM(){
		
	return this.RAM;	
	}

	public  String getProcessor(){
		return this.Processor;
	}

}
