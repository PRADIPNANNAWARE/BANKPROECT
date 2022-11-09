package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegValidation extends HttpServlet
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
			
			if(accno.length() !=4 || pass.length()==0)
			{
				res.sendRedirect("/PradipBank_Project/reginvalid.html");
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/Register").forward(req, res);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
