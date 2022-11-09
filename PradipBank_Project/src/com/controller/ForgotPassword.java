package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Model;

public class ForgotPassword extends HttpServlet {
	public void service(HttpServletRequest req , HttpServletResponse res)
	{
		try 
		{
			String accno1 = req.getParameter("accno");
			String email = req.getParameter("email");
			String name = req.getParameter("name");
			String np = req.getParameter("np");
			
			int accno = Integer.parseInt(accno1);
			
			Model m = new Model();
			m.setAccount_number(accno);
			m.setName(name);
			m.setEmail_id(email);
			
			boolean status = m.forgotpassword(np);
			
			if(status == true)
			{
				res.sendRedirect("/PradipBank_Project/login.html");
			}
			else
			{
				res.sendRedirect("/PradipBank_Project/forgetpassfail.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
}
