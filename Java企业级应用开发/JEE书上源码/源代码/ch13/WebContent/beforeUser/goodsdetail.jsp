<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
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
	function goCart() {
		document.putcartform.submit();
	}
	function gofocus(gno) {
		window.location.href = "before_focus?gno=" + gno;
	}
</script>
</head>
<body>
	<form action="before_putCart" name="putcartform" method="post">
		<div class="blank"></div>
		<div class="block clearfix">
			<div class="location ared">
				当前位置：<a href="#">首页</a> > <a href="#">商品详情</a>
			</div>
			<div class="blank"></div>
			<div id="goodsInfo">
				<div class="imgInfo">
					<input type="hidden" name="gno"
						value="${agoods.id}"/><img
						src="uploadFile/${agoods.gpicture}"
						width="230px" height="230px" />
				</div>
			</div>
			<!--商品表述-->
			<div class="goods_desc">
				<div class="bt">
					${agoods.gname}
				</div>
				<div class="goods_show">
					<ul>
						<li><span>价格:</span> <strong class="yj">${agoods.goprice}元</strong></li>
						<li><span>折扣价:</span><strong
							class="xj">${agoods.grprice}元</strong>
						</li>
						<li><span>类型:</span> ${agoods.typename}</li>
						<li><span>购买数量:</span>${agoods.gname} <input type="text" name="mknum"
							class="good_txt" value="1" /> (库存${agoods.gstore}件)</li>
					</ul>
				</div>
				<p class="bottom10 top5">
					<img src="beforeUser/images/goods_ann2.gif" style="cursor: pointer"
						onclick="goCart()" />&nbsp;&nbsp;<input type="button"
						style="cursor: pointer" class="sh_bnt2"
						onclick="gofocus('${agoods.id}')"
						value="关注" />
				</p>
			</div>
			<!--end-->
			</div>
	</form>
</body>
</html>
