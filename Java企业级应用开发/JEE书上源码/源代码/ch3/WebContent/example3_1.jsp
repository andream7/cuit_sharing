<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="a.jsp"/>     <!-- JSP动作标记 --> 
<%!
	int i = 0;                   //数据声明
	int add(int x, int y) {      //方法声明
		return x + y;
	}
%>
<html>      <!-- html标记 -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	i ++;                   //Java程序片
	int result = add(1, 2);    
%>
	i的值为<%=i%>             <%--Java表达式 --%>
	<br>
	1+2的和为<%=result%>
</body>
</html>