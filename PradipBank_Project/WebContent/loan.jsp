<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

	session = request.getSession();
	String name = (String)session.getAttribute("name");
	out.println("<br>");
	
%>

<a href="/PradipBank_Project/carloan.jsp">Click here to applay for car loan @6.5%</a><br>
<a href="/PradipBank_Project/houseloan.jsp">Click here to applay for house loan @11%%</a><br>
<a href="/PradipBank_Project/educationloan.jsp">Click here to applay for education loan @8%</a><br>

</body>
</html>