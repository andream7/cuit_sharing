<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>computer.jsp</title>
</head>
<body>
	<%
		String m = request.getParameter("length");
		String n = request.getParameter("width");
		double a = Double.parseDouble(m);
		double b = Double.parseDouble(n);
		out.print("我是被加载的页面，负责计算矩形的面积" + "<br>");
		out.print("给我传递的矩形的长度是:"+a+",宽度是:" + b + "<br>");
		out.print("矩形的面积是:" + a * b);
	%>
</body>
</html>
