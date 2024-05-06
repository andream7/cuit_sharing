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
<title>register.jsp</title>
<link href="beforeUser/css/daohang.css" rel="stylesheet" type="text/css" />
<link href="beforeUser/css/common.css" rel="stylesheet" type="text/css" />
<link href="beforeUser/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="beforeUser/jsjs/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	//刷新验证码
	function refreshCode(){
       document.getElementById("code").src = "before_validateCode?t="+Math.random();
    }
	//表单验证
	function checkForm(){
		var bpwd = document.registerForm.bpwd.value;
		var rebpwd = document.registerForm.rebpwd.value;
		$("#flag").val("0");//flag为id
		if(bpwd != rebpwd){
			alert("两次密码不一致！");
			return false;
		}
		document.registerForm.submit();
		return true;
	}
	//验证邮箱是否已被注册
	function checkIsUse(bemail){
		$("#flag").val("1");//flag为id 
		$.ajax({//提交检查用户名是否可用请求
			//请求路径
			url : "before_register",
			//请求类型
			type : "post",
			//data表示发送的数据
			data : "bemail=" + bemail + "&&flag=" + $("#flag").val(),
			//成功响应的结果
			success : function(obj){
				$("#isExit").html(obj);
			},
	        error : function() {
	            alert("处理异常！");
	        }
		});
	}
</script>
</head>
<body>
	<div class="clearfix">
		<div class="blank20"></div>
		<div class="box4">
			<table>
				<tr>
					<td width="100%" valign="bottom">
						<h2>普通会员注册</h2>
					</td>
				</tr>
			</table>
		</div>
		<div class="blank10"></div>
		<div class="box4">
			<div class="case_ll clearfix">
				<div class="regist">
					<form action="before_register" method="post" name="registerForm">
						<input type="hidden" name="flag" id="flag"/>
						<table class="ttbb2">
							<tr>
								<td width="16%" align="right"><span class="cl_f30">*</span>
									E-mail：</td>
								<td width="59%"><input type="text" name="bemail"
									id="textfield" onblur="checkIsUse(this.value)" class="my_txt_350" /></td>
								<td width="25%"><span id="isExit"></span></td>
							</tr>
							<tr>
								<td align="right">&nbsp;</td>
								<td colspan="2" style="font-size: 12px; padding-bottom: 25px;">
									（有效的E-mail地址才能收到激活码，帐户在激活后才能享受网站服务。）</td>
							</tr>
							<tr>
								<td align="right"><span class="cl_f30">*</span> 密码：</td>
								<td><input type="password" name="bpwd" id="textfield2"
									class="my_txt_350" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="right">&nbsp;</td>
								<td colspan="2" style="font-size: 12px; padding-bottom: 25px;">
									（为了您帐户的安全，建议使用字符+数字等多种不同类型的组合，且长度大于5位。）</td>
							</tr>
							<tr>
								<td align="right"><span class="cl_f30">*</span> 重复密码：</td>
								<td><input type="password" name="rebpwd" id="textfield3"
									class="my_txt_350" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="right">&nbsp;</td>
								<td colspan="2" style="font-size: 12px; padding-bottom: 25px;">
									（确保您记住密码。）</td>
							</tr>				
							<tr>
								<td align="right"><span class="cl_f30">*</span> 验证码：</td>
								<td class="ared"><input type="text" name="code"
									id="textfield5" class="my_txt_120" />
									<img id="code" src="before_validateCode" /> 
									<a href="javascript:refreshCode();"><font color="blue">看不清，换一个！</font></a>
								</td>
								<td>${codeError}</td>
							</tr>
							<tr>
								<td align="right">&nbsp;</td>
								<td colspan="2" class="cl_f30" style="font-size: 12px; padding-bottom: 25px;"></td>
							</tr>
							<tr>
								<td align="right">&nbsp;</td>
								<td height="50"><input type="button" name="button" id="button" onclick="checkForm()" value="注册账号" class="my_ann1" /></td>
								<td>&nbsp;</td>
							</tr>
						</table>
					</form>
					<div class="blank20"></div>
				</div>
			</div>
		</div>
		<div class="blank10"></div>
	</div>
</body>
</html>
