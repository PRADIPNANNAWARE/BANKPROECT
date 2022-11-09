package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;


public class Login extends HttpServlet 
{
	public void service(HttpServletRequest req , HttpServletResponse res)
	{
		try 
		{
			String accno = req.getParameter("accno");
			String pass = req.getParameter("pass");
			int account_number = Integer.parseInt(accno);
			
			Model m = new Model();
			m.setAccount_number(account_number);
			m.setPassword(pass);
			
			boolean status = m.login();
			if(status == true)
			{
				int a = m.getAccount_number();
				String b = m.getName();
				String c = m.getPassword();
				String d = m.getEmail_id();
				int e = m.getBalance();
				
				HttpSession session = req.getSession(true);
				session.setAttribute("accno", a);
				session.setAttribute("name", b);
				session.setAttribute("pass", c);
				session.setAttribute("email", d);
				session.setAttribute("bal", e);
				
				res.sendRedirect("/PradipBank_Project/welcome.jsp");
			}
			else
			{
				res.sendRedirect("/PradipBank_Project/incorrect.html");
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
