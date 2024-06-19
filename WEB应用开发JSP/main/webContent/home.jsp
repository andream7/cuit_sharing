<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page errorPage="error.jsp" %>
<%@ page import="java.util.*" %>
<%@page import="entities.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>首页</title>

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
<%--    <!-- 导航栏 开始-->--%>
<%--    <div class="navbar navbar-default navbar-fixed-top">--%>
<%--        <div class="container">--%>
<%--            <div class="navbar-header">--%>
<%--                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">--%>
<%--                    <span class="icon-bar"></span>--%>
<%--                    <span class="icon-bar"></span>--%>
<%--                    <span class="icon-bar"></span>--%>
<%--                </button>--%>
<%--                <a class="navbar-brand" href="#">Project</a>--%>
<%--            </div>--%>
<%--            <div class="collapse navbar-collapse">--%>
<%--                <ul class="nav navbar-nav">--%>
<%--                    <li class="active"><a href="#">首页</a></li>--%>
<%--                    <li><a href="admin.jsp">管理页面</a></li>--%>
<%--                    <li><a href="#">退出</a></li>--%>
<%--                </ul>--%>
<%--            </div><!--/.nav-collapse -->--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <!-- 导航栏 结束-->--%>
    <jsp:include page="header.jsp" flush="true"></jsp:include>
    <!-- Begin page content -->
    <%--    原版欢迎界面代码--%>
    <div class="container">
        <div class="page-header">
            <h1>成功登录！</h1>
        </div>
        <%--    <p class="lead">欢迎您：注册用户名！</p>--%>
        <p class="lead">欢迎您：

            <%--            请用jstl和el重新实现下面控制不同情况输出的代码--%>

<%--            <%--%>
<%--                if(request.getSession().getAttribute("user")==null){--%>
<%--                   out.print("游客");--%>
<%--                }else {--%>
<%--                    User user = (User) request.getSession().getAttribute("user");--%>
<%--                    out.print((String) user.getUserName());--%>
<%--                }--%>
<%--            %>--%>
            <%
                User user = (User) request.getSession().getAttribute("user");
//                String userName = (String) request.getSession().getAttribute("userName");
//                if(userName==null){
//                    System.out.println("userName为空");
                if(user==null){
                    System.out.println("user为空");
                }else {
                    System.out.print((String) user.getUserName());
                }
            %>
            <c:if test="${sessionScope.user==null}">
                游客
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                ${sessionScope.user.userName}
            </c:if>
        </p>
    </div>
</div>
<%--    实验四中使用的欢迎界面代码 使用时需要停用homeFilter--%>

<div id="footer">
    <div class="container">
        <p class="text-muted credit">网站访问次数：</p>
    </div>
</div>

<h1>除法运算器</h1>
<form action="calculate.jsp" method="post">
    <label>除数：</label>
    <input type="text" name="dividend"><br>
    <label>被除数：</label>
    <input type="text" name="divisor"><br>
    <button type="submit">计算</button>
</form>


<!-- script references -->
<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
<script type='text/javascript' src="js/bootstrap.min.js"></script>
</body>
</html>