package com.javaTraining.designPattern.Builder;

public class Computer {

//required parameter.	
private String HDD;
private String RAM;
//optional parameter
private boolean isgraphicsCardEnabled;
private boolean wifiCardEnabled;


public Computer(ComputerBuilder builder) {
	super();
	HDD = builder.HDD;
	RAM = builder.RAM;
	this.isgraphicsCardEnabled = builder.isgraphicsCardEnabled;
	this.wifiCardEnabled = builder.wifiCardEnabled;
}

static class ComputerBuilder{
	
	//required parameter.	
	private String HDD;
	
	private String RAM;
	//optional parameter
	private boolean isgraphicsCardEnabled;
	private boolean wifiCardEnabled;
	
	public ComputerBuilder(String hDD, String rAM) {
		super();
		HDD = hDD;
		RAM = rAM;
	}
	
	public ComputerBuilder setGraphicsCardEnabled(boolean isgraphicsCardEnabled)
	{
		this.isgraphicsCardEnabled=isgraphicsCardEnabled;
		return this;
	}
	public ComputerBuilder setWiFiCardEnabled(boolean wifiCardEnabled)
	{
		this.wifiCardEnabled=wifiCardEnabled;
		return this;
	}

	public Computer build()
	{
		return new Computer(this);
		
	}
	
}

@Override
public String toString() {
	return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", isgraphicsCardEnabled=" + isgraphicsCardEnabled
			+ ", wifiCardEnabled=" + wifiCardEnabled + "]";
}

public String getHDD() {
	return HDD;
}

public String getRAM() {
	return RAM;
}

public boolean isIsgraphicsCardEnabled() {
	return isgraphicsCardEnabled;
}

public boolean isWifiCardEnabled() {
	return wifiCardEnabled;
}



}
