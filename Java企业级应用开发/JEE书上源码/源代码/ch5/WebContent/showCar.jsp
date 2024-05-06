<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showCar.jsp</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8"); 
	%>
	<jsp:useBean id="smallCar" class="com.bean.Car" scope="page"/>
	<%--通过HTTP表单的参数的值设置bean的属性（表单参数与属性自动匹配）--%>
	<jsp:setProperty property="*" name="smallCar"/>
	汽车的品牌是：<jsp:getProperty property="tradeMark" name="smallCar"/>
	<br>汽车的牌号是：<jsp:getProperty property="number" name="smallCar"/>
</body>
</html>