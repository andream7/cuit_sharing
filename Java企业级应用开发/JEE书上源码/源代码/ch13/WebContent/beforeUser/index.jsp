<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>首页</title>
<link href="beforeUser/css/daohang.css" rel="stylesheet" type="text/css" />
<link href="beforeUser/css/common.css" rel="stylesheet" type="text/css" />
<link href="beforeUser/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		function openNotice(url){
			window.open (url, '站内公告', 'height=400, width=400, top=100, left=100, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
		}
</script>
</head>
<body>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<!--销售排行-->
			<div class="box">
				<div class="box_2">
					<div class="top10Tit">
						<span>销售排行</span>
					</div>
					<div class="top10List clearfix">
						<c:forEach var="sg" items="${salelist}"
							varStatus="status">
							<ul class="clearfix">
								<img class="iteration" src="beforeUser/images/top_${status.index+1}.gif" />
								<li class="topimg"><a
									href="before_detail?gno=${sg.id}"> <img
										class="samllimg" alt="" src="uploadFile/${sg.gpicture}" /></a></li>
								<li class="iteration1"><a title=""
									href="before_detail?gno=${sg.id}">${sg.gname}</a><br /> 售价：<font
									class="f1">￥${sg.grprice}元</font><br /></li>
							</ul>
						</c:forEach>
					</div>  
				</div>
			</div>
			<!--销售排行 end -->
			<!--人气排行-->
			<div class="blank5"></div>
			<div class="box">
				<div class="box_2">
					<div class="top10Tit">
						<span>人气排行</span>
					</div>
					<div class="top10List clearfix">
						<c:forEach var="sg" items="${focuslist}"
							varStatus="status">
							<ul class="clearfix">
								<img class="iteration" src="beforeUser/images/top_${status.index+1}.gif" />
								<li class="topimg"><a href="before_detail?gno=${sg.id}"><img
										class="samllimg" alt="" src="uploadFile/${sg.gpicture}" /></a></li>
								<li class="iteration1"><a title=""
									href="before_detail?gno=${sg.id}">${sg.gname}</a><br /> 售价：
									<font class="f1">￥${sg.grprice}元 </font><br /></li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
			<!--人气排行 end -->
		</div>
		<div class="AreaR">
			<div class="AreaR">
				<div class="AreaM clearfix">
					<div id="focus">
						<img src="beforeUser/images/540.jpg" />
					</div>
				</div>
				<div class="AreaRR clearfix">
					<!--公告栏-->
					<div class="box">
						<div class="box_1">
							<div class="title_bt">
								<h3>公告栏</h3>
							</div>
							<div class="post_list ared">
								<ul>
									<c:forEach var="nt" items="${noticelist}">
										<li><a href="javascript:openNotice('before_noticeDetail?nid=${nt.id}');">${nt.ntitle}</a></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<!--公告栏 end-->
				</div>
			</div>
			<div class="AreaR">
				<!--最新商品列表-->
				<div class="blank5"></div>
				<div class="box">
					<div class="box_color ared">
						<div class="title_bt">
							<span><a href="#">更多</a></span>
							<h3>最新商品</h3>
						</div>
						<div class="itemgood_nr clearfix">
							<ul>
								<c:forEach var="sg" items="${lastedlist}">
									<li>
										<div>
											<p class="pic">
												<a href="before_detail?gno=${sg.id}"><img
													src="uploadFile/${sg.gpicture}" /></a>
											</p>
											<p class="wz">
												<strong><a href="before_detail?gno=${sg.id}">${sg.gname}</a></strong><em>现价:<span>￥
														${sg.grprice}</span></em>
											</p>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<!--最新商品列表end-->
			</div>
		</div>
	</div>
</body>
</html>
