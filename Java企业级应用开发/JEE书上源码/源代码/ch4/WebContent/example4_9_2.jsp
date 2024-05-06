<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_9_2.jsp</title>
</head>
<body>
	<form action="example4_9_3.jsp" method="post">
			<%
				//考号
				String id = request.getParameter("id");
				//把考号id以“id”为关键字存储到session对象中
				session.setAttribute("id", id);
				//单项选择第一题
				String first = request.getParameter("one");
				//把答案first以“one”为关键字存储到session对象中
				session.setAttribute("one", first);
				//判断第一题
				String second = request.getParameter("two");
				//把答案second以“two”为关键字存储到session对象中
				session.setAttribute("two", second);
			%>
			您的考号：<%=id%><br/>
			一、单项选择题（每题2分）
			<br/>
			1.<%=first%>
			<br />
			二、判断题（每题2分）
			<br />
			1.<%=second%><br/>
			<input type="submit" value="确认完毕"/>
			<a href="example4_9_1.jsp">重新答题</a>
		</form>
</body>
</html>
