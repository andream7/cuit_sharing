<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>后台登录</title>
	<style type="text/css">
	table{
		text-align: center
	}
	.textSize{
		width: 120px;
		height: 25px
	}
	* {
		margin: 0px;
		padding: 0px;
	}
	body {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 12px;
		margin: 10px 10px auto;
		background-image: url(admin/images/bb.jpg)
	}
	</style>
	<script type="text/javascript">
	//确定按钮
	function gogo(){
		document.forms[0].submit();
	}
	//取消按钮
	function cancel(){
		document.forms[0].action="";
	}
	</script>
  </head>
  <body>
  	<form action="admin_login" method="post">
	<table>
		<tr>
			<td colspan="2"><img src="admin/images/login.gif"></td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><input type="text" class="textSize" name="aname"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" class="textSize" name="apwd"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="image" src="admin/images/ok.gif" onclick="gogo()">
				<input type="image" src="admin/images/cancel.gif" onclick="cancel()">
			</td>
		</tr>
	</table>
	</form>
  </body>
</html>
