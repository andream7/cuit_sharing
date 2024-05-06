<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
<title>操作失败页面</title>
  </head>
  
  <body>
    	操作失败，请重新操作！<br>
    	<a href="javascript:history.back()">返回</a>
  </body>
</html>
