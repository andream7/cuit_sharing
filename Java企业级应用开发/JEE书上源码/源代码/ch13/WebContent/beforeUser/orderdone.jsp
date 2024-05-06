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
<title>商品详情</title>
<link href="beforeUser/css/daohang.css" rel="stylesheet" type="text/css" />
<link href="beforeUser/css/common.css" rel="stylesheet" type="text/css" />
<link href="beforeUser/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
			//确定按钮
			function gogo(){
				document.forms[0].submit();
			}
		</script>
  </head>
  <body>
  	<div class="blank"></div>
	<div class="block clearfix"><!--当前位置-->
	<div class="location ared">当前位置：<a href="before_first?typeid=0">首页</a> > 购物流程 > 生成订单</div>
	<div class="blank"></div>
	<div class="nFlowBox">
    <h2 style="text-align:center; height:30px; line-height:30px;">感谢您在本站购物！您的订单已提交成功，
         	请记住您的订单号: <font style="color:red" size='5'>${ordersn}</font></h2><br/>
      <div align="center">
      <form action="before_pay" method="post">
            	<input type="hidden" name="ordersn" value="${ordersn}"/>
            	<input type="image" src="beforeUser/images/Chinapay_logo.jpg" onclick="gogo()"/>
      </form>
      </div>
    </div>
    </div>
  </body>
</html>
