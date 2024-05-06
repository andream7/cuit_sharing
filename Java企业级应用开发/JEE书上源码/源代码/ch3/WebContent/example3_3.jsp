<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example3_3.jsp</title>
</head>
<%!                    
	int n=0;              
	int add(int x,int y){
		return x+y;
	}
%>
<body>
	<%
	 	int m=0; 
		n++;
		m++;
		int result=add(1,2);
		out.print("成员变量n的值为："+n+"<br>");
		out.print("局部变量m的值为："+m+"<br>");
		out.print("1+2="+result+"<br>"+"<br>");
		out.print("第"+n+"个客户");
	%>
</body>
</html>