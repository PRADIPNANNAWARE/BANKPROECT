package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.model.Model;


public class Transfer extends HttpServlet {
	
	public void service(HttpServletRequest req , HttpServletResponse res)
	{
		try
		{
			String taccno = req.getParameter("taccno");
			String amount = req.getParameter("amount");
			int taccno2 = Integer.parseInt(taccno);
			int amount2 = Integer.parseInt(amount);
			
			HttpSession hs = req.getSession();
			
			int accno = (int)hs.getAttribute("accno");
			
			Model m = new Model();
			m.setAccount_number(accno);
			boolean status1 =  m.checkBalance();
			
			if(status1 == true)
			{
				int bal = m.getBalance();
				if(bal>amount2)
				{
					boolean status =  m.transfer(amount2,taccno2);
					
					if(status == true)
					{
						res.sendRedirect("/PradipBank_Project/transfersuccess.html");
					}
					else
					{
						res.sendRedirect("/PradipBank_Project/transferfail.html");
					}
				}
				
				else
				{
					res.sendRedirect("/PradipBank_Project/transferfail.html");
				}
			}
			else
			{
				res.sendRedirect("/PradipBank_Project/transferfail.html");
			}
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
