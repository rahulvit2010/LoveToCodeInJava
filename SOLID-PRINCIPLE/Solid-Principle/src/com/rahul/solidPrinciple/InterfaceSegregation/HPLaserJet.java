package com.rahul.solidPrinciple.InterfaceSegregation;

public class HPLaserJet implements IPrintTask {

	@Override
	public boolean printContent(String Content) {
		// TODO Auto-generated method stub
		System.out.println("printing done");
		return true;
	}

	@Override
	public boolean scanContent(String Content) {
		// TODO Auto-generated method stub
		System.out.println("scanning done");
		return true;
	}

	@Override
	public boolean faxContent(String Content) {
		// TODO Auto-generated method stub
		System.out.println("faxContent done");
		return true;
	}

	@Override
	public boolean photocopyContent(String Content) {
		System.out.println("photocopyContent done");
		return true;
	}

}
