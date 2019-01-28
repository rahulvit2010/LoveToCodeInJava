package com.rahul.solidPrinciple.SingleRespoprinc;
//user related responsiblitly
public interface Iuser {

	public boolean Login(String userName,String password);
	public boolean Register(String userName,String password,String email);
   
	
	/*
	 * we dont need below methods as they are related to error logs and email
	 */
	/*
	 * public void LogError(String error); 
	 * public boolean SendMail(String emailContent);
	 */
}
