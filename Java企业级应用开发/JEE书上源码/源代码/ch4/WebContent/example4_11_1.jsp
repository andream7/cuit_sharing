<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_11_1.jsp</title>
</head>
<body>
<h2>四字成语接龙</h2>
<%
	//取出application中关键字是message的对象（成语内容）
	StringBuffer s = (StringBuffer)application.getAttribute("message");
	if(s != null){
		out.print(s.toString());
	}
	else{
		out.print("还没有词语，请您龙头开始！<br>");
	}
%>
<form action="example4_11_2.jsp" method="post">
	四字成语输入：<input type="text" name="mes"/><br>
	<input type="submit" value="提交"/>
</form>
</body>
</html>
