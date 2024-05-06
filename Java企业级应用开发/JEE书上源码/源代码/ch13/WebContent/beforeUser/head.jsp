<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
<title>首页</title>
<link href="beforeUser/css/daohang.css" rel="stylesheet" type="text/css" />
<link href="beforeUser/css/common.css" rel="stylesheet" type="text/css" />
<link href="beforeUser/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function clearValue(){
		document.myForm.mykey.value = "";
	}
</script>
</head>
<body>
	<div class="all_zong">
		<!--最上面 灰色条部分-->
		<div class="all_zong_top">
			<div class="all_zong_top_right a8c">
				<table class="main_login">
					<tr>
						<td>
							<p id="content">
								<c:if test="${sessionScope.user != null }">欢迎 ${sessionScope.user.bemail}</c:if>
								<c:if test="${sessionScope.user == null }"><a href="beforeUser/userLogin.jsp">登录</a></c:if>
							</p>
						</td>
						<td>
							<p>
								<a href="beforeUser/register.jsp">注册</a>
							</p>
						</td>
						<td><span class="xx">|</span><a href="before_userCenter?act=index">用户中心</a><span
							class="xx">|</span></td>
					</tr>
				</table>
			</div>
		</div>
		<!--end-->
		<!--logo 搜索-->
		<div class="all_zong_logo">
			<div class="all_zong_logo2">
				<img src="beforeUser/images/mylogo.png" />
			</div>
			<div class="back_search">
				<div class="back_search_red">
					<form action="before_search" name="myForm" method="post">
						<div class="div2">
							<input type="text" name="mykey" class="txt" value="请输入您要查询的内容"  onfocus="clearValue()" />
						</div>
						<div class="div1">
							<input type="submit" class="an"  value="搜索" />
						</div>
					</form>
				</div>
			</div>
			<!--end-->
		</div>
		<!--红色 导航-->
		<div class="skin_a">
			<div class="front_daohangbj">
				<div class="all_zong">
					<div class="front_daohang">
						<ul>
							<li class="backbj"><a href="before_first?typeid=0">首页</a></li>
							<!-- 显示商品类型 -->
							<c:forEach var="g" items="${sessionScope.goodsType}">
								<li><a href="before_first?typeid=${g.id }">${g.typename }</a>
								</li>
							</c:forEach>
							<li class="buy">
								<p class="car">
									<a href="before_selectCart">购物车</a>
								</p>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--红色 导航 end-->
	</div>
</body>
</html>
