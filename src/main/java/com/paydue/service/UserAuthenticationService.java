package com.paydue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.paydue.dao.LoginDaoInterface;
import com.paydue.dto.LoginForm;


public class UserAuthenticationService implements LoginServiceInterface
{
	boolean isValidUser=false;
	@Autowired
	private LoginDaoInterface dao;

	public boolean checkAuthentication(String userName, String userPassword) 
	{
		System.out.println("UserAuthenticationService.checkAuthentication() execution started !!");
		LoginForm loginform=dao.validateUser(userName, userPassword);
		if(loginform!=null)
		{
			if(loginform.getUserName().equals(userName)&&loginform.getPassword().equals(userPassword))
			{
				isValidUser=true;
			}
		}
		
		
		System.out.println("UserAuthenticationService.checAuthentication() executed successfully !!"+"\t"+isValidUser);
		return isValidUser;
		
	}
	
	

}
