package org.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Recruiter extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = getServletContext().getInitParameter("Website-name");
		
		String website = getServletConfig().getInitParameter("Email");
		
		PrintWriter out = response.getWriter();
				
		out.println(website);
		out.println(email);

		
	}	
}

