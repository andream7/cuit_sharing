<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int firstNumber = Integer.parseInt(request.getParameter("firstNumber"));
	int secondNumber = Integer.parseInt(request.getParameter("secondNumber"));
	out.print("<br>" + firstNumber + "和" + secondNumber + "的最大公约数是：");
	while(firstNumber % secondNumber != 0){
		int temp = firstNumber % secondNumber;
		firstNumber = secondNumber;
		secondNumber = temp; 
	}
	out.print(secondNumber);
%>
</body>
</html>