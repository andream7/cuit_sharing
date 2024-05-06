<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int row = Integer.parseInt(request.getParameter("row"));
	int col = Integer.parseInt(request.getParameter("col"));
	out.print("<table border=1>");
	for(int i = 1; i <= row; i++){
		out.print("<tr>");
		for(int j = 1; j <= col; j++){
			out.print("<td>");
			out.print(i*j);
			out.print("</td>");
		}
		out.print("</tr>");
	}
	out.print("</table>");
%>
</body>
</html>