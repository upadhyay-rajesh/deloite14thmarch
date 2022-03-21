package com.whatsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whatsapp.entity.WhatsappUser;
import com.whatsapp.service.WhatsappService;
import com.whatsapp.service.WhatsappServiceInterface;

public class REgisterServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("nm");
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		WhatsappUser wu=new WhatsappUser();
		wu.setName(name);
		wu.setPassword(password);
		wu.setEmail(email);
		wu.setAddress(address);
		
		WhatsappServiceInterface ws=new WhatsappService();
		int i=ws.createProfileService(wu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
				out.println("Registration Success");
			}
		out.println("</body></html>");
	}
	
	

	
}















