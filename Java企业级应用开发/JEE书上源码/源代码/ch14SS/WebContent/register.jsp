<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head>
<meta charset="UTF-8"> 
<style type="text/css">
	.textSize{
		width: 100pt;
		height: 15pt
	}
</style>
<title>注册画面</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	//输入姓名后，调用该方法，判断用户名是否可用
	function nameIsNull(){
		$.ajax({//提交检查用户名是否可用请求
				//请求路径
				url : "jsontest/isUse.action",
				//请求类型
				type : "post",
				//data表示发送的数据
				data : {
					uname : $("#uname").val()
				},
				//成功响应的结果
				success : function(obj){
					if(obj.isResult == "no"){
						$("#isExit").html("<font color=red size=5>×</font>");
						alert("用户已存在，请修改！");
					}else{
						$("#isExit").html("<font color=green size=5>√</font>");
						alert("用户可用");
					}
				},
		        error : function() {
		            alert("处理异常！");
		        }
			});
	}
	//注册时检查输入项
	function allIsNull(){
		var name=document.registForm.uname.value;
		var pwd=document.registForm.upass.value;
		var repwd=document.registForm.reupass.value;
		if(name==""){
			alert("请输入姓名！");
			document.registForm.uname.focus();
			return false;
		}
		if(pwd==""){
			alert("请输入密码！");
			document.registForm.upass.focus();
			return false;
		}
		if(repwd==""){
			alert("请输入确认密码！");
			document.registForm.reupass.focus();
			return false;
		}
		if(pwd!=repwd){
			alert("2次密码不一致，请重新输入！");
			document.registForm.upass.value="";
			document.registForm.reupass.value="";
			document.registForm.upass.focus();
			return false;
		}
		document.registForm.submit();
		return true;
	}
</script>
</head>
<body style="background-image: url('images/bb.jpg');">
	<form action="user/regist.action" method="post" name="registForm">
		<table>
			<tr>
				<td>姓名：</td>
				<td>
					<input class="textSize" type="text" id="uname" name="uname" onblur="nameIsNull()" />
						<span id="isExit"></span>
				</td>
			</tr>
			
			<tr>
				<td>密码：</td>
				<td><input class="textSize" type="password" maxlength="20" name="upass"/></td>
			</tr>
			
			<tr>
				<td>确认密码：</td>
				<td><input class="textSize" type="password" maxlength="20" name="reupass"/></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="button" value="注册" onclick="allIsNull()"/></td>
			</tr>
		</table>
	</form>
</body>
</html>