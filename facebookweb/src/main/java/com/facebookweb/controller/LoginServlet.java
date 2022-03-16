package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;

public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("em");
		String password=request.getParameter("pass");
		
		FacebookUser fb=new FacebookUser();
		fb.setEmail(email);
		fb.setPassword(password);
		
		FacebookServiceInterface fs= new FacebookService();
		boolean b=fs.checkLoginService(fb);
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(b) {
				out.println("welcome "+email);
				out.println("<a href=ViewProfileServlet>view profile</a>");
				out.println("<a href=EditProfileServlet>edit profile</a>");
				out.println("<a href=SearchProfileServlet>search profile</a>");
				out.println("<a href=DeleteProfileServlet>delete profile</a>");
				out.println("<a href=ViewAllProfileServlet>view all profile</a>");
			}
			else {
				out.println("Invalid id and password <a href=login.html>login again</a>");
			}
		
		
	}

}










