<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getValue.jsp</title>
</head>
<body>
	<%
		String name = request.getParameter("userName");
		//userName为example4_1.jsp页面中的表单参数名
		out.println(name);
		//test为example4_1.jsp页面中request对象的属性名称
		String tt = (String)request.getAttribute("test");
		out.println("<br>" + tt);
	%>        
</body>
</html>
