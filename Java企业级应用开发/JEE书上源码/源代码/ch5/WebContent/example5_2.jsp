<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example5_2.jsp</title>
</head>
<body>
	<jsp:useBean id="rectangle" class="com.bean.Rectangle" scope="page"/>
	<p>矩形的长是：<%=rectangle.getLength()%>
	<p>矩形的宽是：<%=rectangle.getWidth() %>
	<p>矩形的面积是：<%=rectangle.computerArea() %>
	<p>矩形的周长是：<%=rectangle.computerLength() %>
</body>
</html>