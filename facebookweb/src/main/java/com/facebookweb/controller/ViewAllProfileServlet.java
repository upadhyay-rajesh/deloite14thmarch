package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;

public class ViewAllProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacebookServiceInterface fs= new FacebookService();
		List<FacebookUser> b=fs.viewAllProfileService();
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
		
		out.println(b.size()+"  record found<br>");
		if(b.size()>0) {
			
			for(FacebookUser ff:b) {
				out.println("<font color=red size=5>User Detail is below</font>");
				out.println("<br>Name is "+ff.getName());
				out.println("<br>Password is "+ff.getPassword());
				out.println("<br>Email is "+ff.getEmail());
				out.println("<br>Address is "+ff.getAddress());
			}
		}
		else {
			out.println("no record found in database");
		}
		out.println("</center></body></html>");
	}

}















