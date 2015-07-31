package com.paydue.controller;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paydue.dto.LoginForm;

import com.paydue.service.LoginServiceInterface;
import com.paydue.util.PageUtil;

@Controller

@RequestMapping("/login/*")
public class LoginController
{
	
		@Autowired
		public LoginServiceInterface service;

		@RequestMapping("loginform")
		public String showForm(Model model) {
			System.out.println("============================");			
			model.addAttribute("loginForm",new LoginForm());
			return "loginform";
		}
		
		
		@RequestMapping("logindetails")
		public String doLogin(@Valid LoginForm loginForm,
				BindingResult result, Map model , @RequestParam("userName") String username, @RequestParam("password") String password)
		{
			boolean isValidUser=false;
			
			if (result.hasErrors()) 
			{
				return "loginform";
			}
			System.out.println("LoginController.doLogin() execution started !!");
			isValidUser=service.checkAuthentication(username, password);
			
			
			System.out.println("Username =====> "+"\t"+username);
			System.out.println("Password =====>"+"\t"+password);
			System.out.println("Got return value from service =====>"+"\t"+isValidUser);
			if(isValidUser)
			{			
			   return PageUtil.LOGIN_SUCCESS;
			}
			else
			{
				 return "loginform";
			}
			
		}



}


 
