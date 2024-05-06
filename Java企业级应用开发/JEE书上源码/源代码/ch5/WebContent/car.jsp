<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>car.jsp</title>
</head>
<body>
	<jsp:useBean id="smallCar" class="com.bean.Car" scope="page"/>
	<%
		String carNo = "京A8888";
	%>
	<%--使用setProperty标记设置smallCar的属性tradeMark值为"宝马X6"--%>
	<jsp:setProperty property="tradeMark" name="smallCar" value="宝马X6"/>
	<%--使用setProperty标记设置smallCar的属性number值为carNo--%>
	<jsp:setProperty property="number" name="smallCar" value="<%=carNo %>"/>
	汽车的品牌是：<jsp:getProperty property="tradeMark" name="smallCar"/>
	<br>汽车的牌号是：<jsp:getProperty property="number" name="smallCar"/>
</body>
</html>