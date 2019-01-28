package com.rahul.java.designpattern.builder;

public class Computer {
private String HDD;
private String RAM;
private boolean graphicsEnabled;
private boolean wifiEnabled;

public String getHDD() {
	return HDD;
}

public void setHDD(String hDD) {
	HDD = hDD;
}

public String getRAM() {
	return RAM;
}

public void setRAM(String rAM) {
	RAM = rAM;
}

public boolean isGraphicsEnabled() {
	return graphicsEnabled;
}

public void setGraphicsEnabled(boolean graphicsEnabled) {
	this.graphicsEnabled = graphicsEnabled;
}

public boolean isWifiEnabled() {
	return wifiEnabled;
}

public void setWifiEnabled(boolean wifiEnabled) {
	this.wifiEnabled = wifiEnabled;
}

Computer(ComputerBuilder builder)
{
  this.HDD=builder.HDD;
  this.RAM=builder.RAM;
  this.graphicsEnabled=builder.graphicsEnabled;
  this.wifiEnabled=builder.wifiEnabled;
}

public static class ComputerBuilder{
	private String HDD;
	private String RAM;
	private boolean graphicsEnabled;
	private boolean wifiEnabled;
	
	ComputerBuilder(String HDD,String RAM)
	{
		this.HDD=HDD;
		this.RAM=RAM;
	}
	
	public  ComputerBuilder setGraphicsEnabled(boolean graphicsEnable)
	{
		this.graphicsEnabled=graphicsEnable;
		return this;
	}
	
	public ComputerBuilder setWifiEnabled(boolean wifiEnabled)
	{
		this.wifiEnabled=wifiEnabled;
		return this;
	}
	
	Computer Build()
	{
		return new Computer(this);
	}
	
}


}