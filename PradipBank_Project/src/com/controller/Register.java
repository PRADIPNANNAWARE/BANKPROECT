package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Model;


public class Register extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)
	{
		try
		{
			String accno = req.getParameter("accno");
			String name = req.getParameter("name");
			String pass = req.getParameter("password");
			String email = req.getParameter("email_id");
			String bal = req.getParameter("bal");
			
			int accno1 = Integer.parseInt(accno);
			int bal1 = Integer.parseInt(bal);
			
			Model m = new Model();
			m.setAccount_number(accno1);
			m.setName(name);
			m.setPassword(pass);
			m.setEmail_id(email);
			m.setBalance(bal1);
			boolean status = m.register();
			if(status == true)
			{
				res.sendRedirect("/PradipBank_Project/login.html");
			}
			else
			{
				res.sendRedirect("/PradipBank_Project/regincorrect.html");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
