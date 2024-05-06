<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_7.jsp</title>
</head>
<body>
	<%
		int myNumber = 1000;
		Date myDate = new  Date();
		out.print(myNumber);
		out.print("<br>");
		out.print(myDate);
	%>
</body>
</html>