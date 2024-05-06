<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_11_2.jsp</title>
</head>
<body>
	<%!
		StringBuffer message = new StringBuffer("");
		ServletContext application;
		synchronized void sendMessage(String s){
			application = getServletContext();
			message.append(s + "->") ;
			//把成语内容message以“message”为关键字存储到application对象中
			application.setAttribute("message", message);
		}
	%>
	<%
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("mes");
		sendMessage(content);
		out.print("您的四字成语已经提交！3秒钟后回到成语页面，继续接龙！");
		response.setHeader("refresh", "3;url=example4_11_1.jsp");
	%>
</body>
</html>
