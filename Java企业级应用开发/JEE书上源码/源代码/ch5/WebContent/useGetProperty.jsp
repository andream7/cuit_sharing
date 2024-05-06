<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useGetProperty.jsp</title>
</head>
<body>
	<jsp:useBean id="pig" class="com.bean.NewRectangle" scope="page"/>
	<%pig.setLength(30);%>
	<%pig.setWidth(20);%>
	<p>矩形的长是：<jsp:getProperty property="length" name="pig"/>
	<p>矩形的宽是：<jsp:getProperty property="width" name="pig"/>
	<p>矩形的面积是：<jsp:getProperty property="rectangleArea" name="pig"/>
	<p>矩形的周长是：<jsp:getProperty property="rectangleLength" name="pig"/>
</body>
</html>