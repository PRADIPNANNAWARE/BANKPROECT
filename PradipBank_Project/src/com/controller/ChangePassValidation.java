package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangePassValidation extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)
	{
		try
		{
			String op = req.getParameter("op");
			String np = req.getParameter("np");
			String cp = req.getParameter("cp");
			
			if(op.length()==0 || np.length()==0 || cp.length()==0)
			{
				res.sendRedirect("/PradipBank_Project/changepassfail.html");
			}
			else
			{
				if(np.equals(cp))
				{
					res.sendRedirect("/PradipBank_Project/ChangePassword");
				}
				else
				{
					res.sendRedirect("/PradipBank_Project/changepassfail.html");
				}
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
