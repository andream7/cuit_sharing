<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<jsp:include page="head.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
    <title>userLogin.jsp</title>
	<link href="beforeUser/css/daohang.css" rel="stylesheet" type="text/css" />
	<link href="beforeUser/css/common.css" rel="stylesheet" type="text/css" />
	<link href="beforeUser/css/style.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	table{
		text-align: center
	}
	.textSize{
		width: 120px;
		height: 20px
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
	function refreshCode(){
       document.getElementById("code").src = "before_validateCode?t="+Math.random();
    }
	</script>
  </head>
  <body>
  	<form action="before_userLogin" method="post">
	<div align="center">
	<table>
		<tr>
			<td colspan="3"><img src="admin/images/login.gif"></td>
		</tr>
		<tr>
			<td>E-Mail：</td>
			<td><input type="text" class="textSize" name="bemail"></td>
			<td>${bemailError}</td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" class="textSize" name="bpwd"></td>
			<td>${bpwdError}</td>
		</tr>		
		<tr>
			<td>验证码：</td>
			<td><input type="text" class="textSize" name="code"></td>
		  <td>${codeError}</td>
		</tr>		
		<tr>
			<td>
				<img id="code" src="before_validateCode"/>
			</td>
			<td class="ared">
				<a href="javascript:refreshCode();"><font color="blue">看不清，换一个！</font></a>
			</td>
			<td></td>
		</tr>		
		<tr>
			<td colspan="2">
				<input type="image" src="admin/images/ok.gif" onclick="gogo()">
				<input type="image" src="admin/images/cancel.gif" onclick="cancel()">
			</td>
		</tr>
	</table>
	</div>
	</form>
  </body>
</html>
