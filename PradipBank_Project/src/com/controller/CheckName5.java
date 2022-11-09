package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckName5 extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)
	{
	try
	{
		res.sendRedirect("PradipBank_Project/invalidPasscheckname.html");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}
