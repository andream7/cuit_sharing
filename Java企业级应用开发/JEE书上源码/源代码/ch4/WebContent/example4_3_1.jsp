<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_3_1.jsp</title>
</head>
<body>
	<%
		String number = request.getParameter("mynumber");
		int toNumber = 0;
		try{
			toNumber = Integer.parseInt(number);
			out.print(toNumber*toNumber);
		}catch(Exception e){
			request.setAttribute("errorMsg", "请输入一个整数！");
	%>
			<jsp:forward page="example4_3.jsp"></jsp:forward>
	<%		
		}
	%>
</body>
</html>