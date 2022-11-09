package com.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginValidation extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)
	{
		try 
		{
			String accno = req.getParameter("accno");
			String pass = req.getParameter("pass");
			System.out.println(pass);
			if(accno.length()!=4 || pass.length()==0)
			{
				res.sendRedirect("/PradipBank_Project/invalid.html");
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/Login").forward(req, res);
			}
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
  
}
