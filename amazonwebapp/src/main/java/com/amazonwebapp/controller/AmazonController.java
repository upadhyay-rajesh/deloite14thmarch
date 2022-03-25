package com.amazonwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amazonwebapp.entity.AmazonUser;
import com.amazonwebapp.service.AmazonServiceInterface;

@Controller
public class AmazonController {
	
	@Autowired
	private AmazonServiceInterface aservice;

	@RequestMapping("RegistrationServlet")
	public ModelAndView registerUser(@RequestParam("nm") String name,@RequestParam("pass") String password, @RequestParam("em") String email,@RequestParam("ad") String address) {
		AmazonUser am=new AmazonUser();
		am.setName(name);
		am.setPassword(password);
		am.setEmail(email);
		am.setAddress(address);
		
		int i=aservice.createProfile(am);
		
		String s="profile not created";
		
		if(i>0) {
			s="profile created";
		}
		ModelAndView mv=new ModelAndView();
		mv.addObject("result", s);
		mv.setViewName("registrationresult.jsp");
		
		return mv;
		
	}
}










