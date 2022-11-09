package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;


public class ChangePassword extends HttpServlet 
{
	public void service(HttpServletRequest req , HttpServletResponse res)
	{
		try 
		{
			String op = req.getParameter("op");
			String np = req.getParameter("np");
			String cp = req.getParameter("cp");
			
			HttpSession hs = req.getSession();
			int accno = (int)hs.getAttribute("accno");
			
			Model m = new Model();
			
			m.setAccount_number(accno);
			m.setPassword(op);
			boolean status = m.changePassword(cp);
			
			if(status == true)
			{
				res.sendRedirect("/PradipBank_Project/login.html");
			}
			else
			{
				res.sendRedirect("/PradipBank_Project/invalidchangepass.html");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
