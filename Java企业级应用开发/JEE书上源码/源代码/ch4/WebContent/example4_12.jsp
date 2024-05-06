<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//添加页面域属性值
		pageContext.setAttribute("pageKey", "页面域属性");
		//获取页面域属性值
		String pageValue = (String)pageContext.getAttribute("pageKey");
		//添加请求域属性值
		pageContext.getRequest().setAttribute("requestKey", "请求域属性");
		//获取请求域属性值
		String requestValue = (String)pageContext.getAttribute("requestKey", 2);
		out.print(pageValue + "<br>");	
		out.print(requestValue);	
	%>
</body>
</html>