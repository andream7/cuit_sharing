<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
//获取当前项目的路径，如：http://localhost:8080/项目名称。
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
    <title>loginerror.jsp</title>
  </head>
  <body>
    	登录失败，请查看用户名和密码是否正确？ <br>
    	<a href="javascript:history.back()">返回</a>
  </body>
</html>
