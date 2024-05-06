<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
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
		text-align: center;
	}
	.textSize{
		width: 120px;
		height: 25px;
	}
	* {
		margin: 0px;
		padding: 0px;
	}
	body {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 12px;
		margin: 10px 10px auto;
		background-image: url(images/bb.jpg);
	}
	.errorMessage {font-weight:bold; color:red; }
	<!--errorMessage会自动更改错误消息的样式 -->
	</style>
	<script type="text/javascript">
	//确定按钮
	function gogo(){
		document.forms[0].submit();
	}
	//取消按钮
	function cancel(){
		document.forms[0].action = "";
	}
	</script>
  </head>
  <body>
  	<form action="user/login" method="post">
	<table>
		<tr>
			<td colspan="2"><img src="images/login.gif"></td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><input type="text" name="uname" class="textSize"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="upass" class="textSize"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="image" src="images/ok.gif" onclick="gogo()" >
				<input type="image" src="images/cancel.gif" onclick="cancel()" >
			</td>
		</tr>
	</table>
	</form>
	${errorMsg }
  </body>
</html>
