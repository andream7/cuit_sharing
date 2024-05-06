<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getValues.jsp</title>
</head>
<body>
	您去过的城市：<br>
	<%
		String yourCities[] = request.getParameterValues("cities");
		for(int i = 0; i < yourCities.length; i ++){
			out.println(yourCities[i] +  "<br>");
		}
	%>        
</body>
</html>
