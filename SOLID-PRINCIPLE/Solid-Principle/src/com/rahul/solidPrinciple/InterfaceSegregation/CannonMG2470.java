package com.rahul.solidPrinciple.InterfaceSegregation;


//problem...cannon printer can only fax and scan..but as it is implementing 
//the IPrintTask..then it has to implement all the non relevent method
public class CannonMG2470 implements IPrintTask {

	@Override
	public boolean printContent(String Content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scanContent(String Content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean faxContent(String Content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean photocopyContent(String Content) {
		// TODO Auto-generated method stub
		return false;
	}

}
