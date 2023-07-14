<%@ page import="jsp.exp.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>HTML</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/main1.css" rel="stylesheet">
	</head>
	<body>
<!-- Wrap all page content here -->
<div id="wrap">
  
  <!-- Fixed navbar -->
  <!-- 导航栏 开始-->
  <div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Project</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">首页</a></li>
          <li><a href="admin.jsp">管理页面</a></li>
          <li><a href="#">导航2</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">菜单 <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="logout.jsp">退出</a></li>
            
              <li class="divider"></li>
              <li class="dropdown-header">个人信息</li>
             
            </ul>
          </li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
   <!-- 导航栏 结束-->
  <!-- Begin page content -->
  <div class="container">
    <div class="page-header">
      <h1>用户信息：</h1>
    </div>
      <%
          User user = (User) request.getAttribute("user");
          //设置解码方式为GBK
          response.setContentType("text/html;charset=GBK");
          out.print("<p class=\"lead\">用户名：" + user.getUserName() + "</p>");
          out.print("<p class=\"lead\">密码：" + user.getPwd() + "</p>");
          out.print("<p class=\"lead\">性别：" + user.getGender() + "</p>");
          out.print("<p class=\"lead\">类型：" + user.getCategory() + "</p>");
          out.print("<p class=\"lead\">兴趣：" + user.getInterest() + "</p>");
          out.print("<p class=\"lead\">注册时间：" + user.getRegTime() + "</p>");


      %>

  </div>
</div>

<div id="footer">
  <div class="container">
    <p class="text-muted credit">网站访问次数：</p>
  </div>
</div>

	<!-- script references -->
		<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>
	</body>
</html>