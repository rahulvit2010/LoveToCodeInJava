package com.rahul.solidPrinciple.InterfaceSegregation;

public interface IPrintTask {

	public boolean printContent(String Content);
	public boolean scanContent(String Content);
	public boolean faxContent(String Content);
	public boolean photocopyContent(String Content);
}
