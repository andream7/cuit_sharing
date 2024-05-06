<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_16.jsp</title>
</head>
<body>
	<%
		int pageSum = 1;
		int sessionSum = 1;
		int applicationSum = 1;
		//页面域计数
		if(pageContext.getAttribute("pageCount") != null){
			pageSum = Integer.parseInt(pageContext.getAttribute("pageCount").toString());
			pageSum++;
		}
		pageContext.setAttribute("pageCount", pageSum);
		//会话域计数
		if(session.getAttribute("sessionCount") != null){
			sessionSum = Integer.parseInt(session.getAttribute("sessionCount").toString());
			sessionSum++;
		}
		session.setAttribute("sessionCount", sessionSum);
		//应用域计数
		if(application.getAttribute("applicationCount") != null){
			applicationSum = Integer.parseInt(application.getAttribute("applicationCount").toString());
			applicationSum++;
		}
		application.setAttribute("applicationCount", applicationSum);
	%>
		<p>页面域访问统计：<%=pageSum%></p>
		<p>会话域访问统计：<%=sessionSum%></p>
		<p>应用域访问统计：<%=applicationSum%></p>
</body>
</html>