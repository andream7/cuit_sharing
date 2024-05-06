<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("uname");
		String password = request.getParameter("pwd");
		if("tom".equals(name) && "jenny".equals(password)){
	%>
			<jsp:forward page="success.jsp"/>
	<%
		}else{
	%>
			<jsp:forward page="login.jsp"/>
	<%	
		}
	%>
</body>
</html>