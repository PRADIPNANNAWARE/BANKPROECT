package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;


public class Balance extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)
	{
		try
		{
			HttpSession hs = req.getSession();
			int accon = (int)hs.getAttribute("accno");
			
			Model m = new Model();
			m.setAccount_number(accon);
			boolean status = m.checkBalance();
			if(status == true)
			{
				int bal = m.getBalance();
				hs.setAttribute("new_bal", bal);
				res.sendRedirect("/PradipBank_Project/balancesuccess.jsp");
			}
			else
			{
				res.sendRedirect("/PradipBank_Project/balancefail.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
