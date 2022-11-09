package com.model;

import java.sql.*;

public class Model {
	int account_number;
	String name;
	String email_id;
	String password;
	int balance;

	String path = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	String user = "system";
	String Dpassword = "pradip";

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public Model() {
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, user, Dpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean login() {
		try {
			String sql = "SELECT * FROM PRADIP_BANK WHERE ACCOUNT_NUMBER=? AND PASSWORD = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, account_number);
			pst.setString(2, password);

			rs = pst.executeQuery();

			if (rs.next() == true) 
			{
				account_number = rs.getInt(1);
				name = rs.getString(2);
				email_id = rs.getString(3);
				password = rs.getString(4);
				balance = rs.getInt(5);

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean register()
	{
		try
		{
			String sql = "insert into PRADIP_BANK values(?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, account_number);
			pst.setString(2, name);
			pst.setString(3, email_id);
			pst.setString(4, password);
			pst.setInt(5, balance);
			
			int row = pst.executeUpdate();
			
			if(row==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkBalance()
	{
		try
		{
			String sql = "SELECT * FROM PRADIP_BANK WHERE ACCOUNT_NUMBER=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, account_number);
			rs = pst.executeQuery();
			
			if(rs.next()==true)
			{
				balance = rs.getInt(5);
				return true;
			}
			else 
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean changePassword(String np)
	{
		try
		{
			String sql = "update pradip_bank set password = ? where account_number = ? and password=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, account_number);
			pst.setString(3, password);
			
			int row = pst.executeUpdate();
			if(row == 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean transfer(int amount , int taccno2)
	{
		try
		{
			String sql = "UPDATE PRADIP_BANK SET BALANCE=BALANCE-? WHERE ACCOUNT_NUMBER=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, amount);
			pst.setInt(2, account_number);
			int row1 = pst.executeUpdate();
			
			
			String sql2 = "UPDATE PRADIP_BANK SET BALANCE=BALANCE+? WHERE ACCOUNT_NUMBER=?";
			pst = con.prepareStatement(sql2);
			pst.setInt(1, amount);
			pst.setInt(2, taccno2);
			int row2 = pst.executeUpdate();
			
			if(row1==0 || row2==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean forgotpassword(String np)
	{
		try
		{
			String sql = "UPDATE PRADIP_BANK SET PASSWORD=? WHERE ACCOUNT_NUMBER=? AND NAME=? AND EMAIL_ID=? ";
			pst=con.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, account_number);
			pst.setString(3, name);
			pst.setString(4, email_id);
			
			int row=pst.executeUpdate();
			if(row == 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	// Setter and Getter Methods 

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}