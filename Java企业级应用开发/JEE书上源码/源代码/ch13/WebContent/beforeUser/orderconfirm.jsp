<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			function submitorder(total){
				if(window.confirm("是否真的提交订单，提交后不可再修改订单信息！")){
					window.location.href="before_ordersubmit?amount=" + total;
					return true;
				}
				return false;
			}
 		</script> 
	</head>
  <body>
	<div class="blank"></div>
	<div class="block clearfix"><!--当前位置-->
	<div class="location ared">当前位置：<a href="index.php">首页</a> > 购物流程 > 确认订单信息</div>
	<div class="blank"></div>
			<div class="nFlowBox">
   <form action="" method="post">
    <h6>商品列表</h6>
             <table style="width:99%; align-content: center;">
            <tr>
              <th bgcolor="#ffffff">商品名称</th>
              <th bgcolor="#ffffff">市场价格</th>
              <th bgcolor="#ffffff">购买数量</th>
              <th bgcolor="#ffffff">小计</th>
            </tr> 
           <c:forEach var="ce" items="${cartlist}"> 
            <tr>
              <td bgcolor="#ffffff" align="center">
                  	${ce.gname}
              </td>
              <td align="center" bgcolor="#ffffff">${ce.grprice}</td>
              <td align="center" bgcolor="#ffffff">
                ${ce.shoppingnum}
              </td>
              <td align="center" bgcolor="#ffffff">￥&nbsp;${ce.smallsum}&nbsp;元 </td>
            </tr>
       	  </c:forEach>
       	  	<tr>
       	  		<td bgcolor="#ffffff" colspan="4" align="right">
       	 			应付款 
       	 			<font class="pricetype" size="5" color="red">￥&nbsp;${total}&nbsp;元</font>  	
              </td>
          </tr>   	
        </table>   
        <div align="center" style="margin:8px auto;">
       		 <img style="cursor:pointer;"  onclick="submitorder(${total})" src="beforeUser/images/bnt_subOrder.gif" />
    	</div>  
    	<input type="hidden" name="goodsamount" value="20"/>
    </form>
</div>
</div>
</body>
</html>




