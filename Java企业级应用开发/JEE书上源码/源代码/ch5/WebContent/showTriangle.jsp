<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showTriangle.jsp</title>
</head>
<body> 
<jsp:useBean id="triangle" class="com.bean.Triangle" scope="page" />
	<jsp:setProperty name="triangle" property="*" />
	<P>
		三角形的三边是： <BR>边A：<jsp:getProperty name="triangle" property="sideA" />
		边B：<jsp:getProperty name="triangle" property="sideB" />
		边C：<jsp:getProperty name="triangle" property="sideC" />
	<P>
		这三个边能构成一个三角形吗？
		<jsp:getProperty name="triangle" property="triangle" />
	<P>
		面积是：
		<jsp:getProperty name="triangle" property="area" />
</body>
</html>