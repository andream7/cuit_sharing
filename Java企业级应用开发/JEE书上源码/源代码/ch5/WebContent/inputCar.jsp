<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inputCar.jsp</title>
</head>
<body>
	<form action="showCar.jsp" method="post" >
		请输入汽车品牌：
		<input type="text" name="tradeMark"/>
		<br>
		请输入汽车牌号：
		<input type="text" name="number"/>
		<br>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>