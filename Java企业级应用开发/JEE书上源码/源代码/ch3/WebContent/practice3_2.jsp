<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!                         
	int n=0;       
%>
<body>
       <%
			n++;
			out.print("欢迎访问本网站！<br>");
			out.print("您是第"+n+"个访问本站的客户。");
		%>
</body>
</html>