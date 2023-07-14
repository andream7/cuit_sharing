<%@ page import="jsp.exp.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                    <li><a href="#">退出</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
    <!-- 导航栏 结束-->
    <!-- Begin page content -->
    <%--  <div class="container">--%>
    <%--    <div class="page-header">--%>
    <%--      <h1>用户列表</h1>--%>
    <%--    </div>--%>
    <%--    <div class="table-responsive">--%>
    <%--            <table class="table table-striped">--%>
    <%--              <thead>--%>
    <%--                <tr>--%>
    <%--                  <th>序号</th>--%>
    <%--                  <th>用户名</th>--%>
    <%--                  <th>密码</th>--%>
    <%--                  <th>操作</th>--%>
    <%--                </tr>--%>
    <%--              </thead>--%>
    <%--              <tbody>--%>
    <%--                <tr>--%>
    <%--                  <td>1001</td>--%>
    <%--                  <td>Lorem</td>--%>
    <%--                  <td>ipsum</td>--%>
    <%--                  <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1002</td>--%>
    <%--                  <td>amet</td>--%>
    <%--                  <td>consectetur</td>--%>
    <%--                  <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1003</td>--%>
    <%--                  <td>Integer</td>--%>
    <%--                  <td>nec</td>--%>
    <%--                  <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1003</td>--%>
    <%--                  <td>libero</td>--%>
    <%--                  <td>Sed</td>--%>
    <%--                  <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1004</td>--%>
    <%--                  <td>dapibus</td>--%>
    <%--                  <td>diam</td>--%>
    <%--                  <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1005</td>--%>
    <%--                  <td>Nulla</td>--%>
    <%--                  <td>quis</td>--%>
    <%--                  <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1006</td>--%>
    <%--                  <td>nibh</td>--%>
    <%--                  <td>elementum</td>--%>
    <%--                   <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1007</td>--%>
    <%--                  <td>sagittis</td>--%>
    <%--                  <td>ipsum</td>--%>
    <%--                  <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1008</td>--%>
    <%--                  <td>Fusce</td>--%>
    <%--                  <td>nec</td>--%>
    <%--                  <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1009</td>--%>
    <%--                  <td>augue</td>--%>
    <%--                  <td>semper</td>--%>
    <%--                 <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1010</td>--%>
    <%--                  <td>massa</td>--%>
    <%--                  <td>Vestibulum</td>--%>
    <%--                 <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1011</td>--%>
    <%--                  <td>eget</td>--%>
    <%--                  <td>nulla</td>--%>
    <%--                  <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1012</td>--%>
    <%--                  <td>taciti</td>--%>
    <%--                  <td>sociosqu</td>--%>
    <%--                  <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--                <tr>--%>
    <%--                  <td>1013</td>--%>
    <%--                  <td>torquent</td>--%>
    <%--                  <td>per</td>--%>
    <%--                <td><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>--%>
    <%--                </tr>--%>
    <%--              </tbody>--%>
    <%--            </table>--%>
    <%--          </div>--%>
    <%--  </div>--%>
    <%--</div>--%>
    <%--  实现代码--%>
    <table>
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>密码</th>
        </tr>
    </table>
    <div class="container">
        <div class="page-header">
            <h1>用户列表</h1>
        </div>
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:set var="users" value="${requestScope.userList}"/>
                <c:forEach var="user" items="${users}" varStatus="loop">
                    <%
                        System.out.println("1");
                    %>
                    <tbody>
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.pwd}</td>
                        <td><a href="userInfo.do?userId=${user.id}">查看详情</a>&nbsp;&nbsp;<a href="delete.do?userId=${user.id}">删除</a></td>
                    </tr>
                    </tbody>
                </c:forEach>
                <tbody>
                <tr>
                    <td>1001</td>
                    <td>Lorem</td>
                    <td>ipsum</td>
                    <td><a href="#">查看详情</a>&nbsp;&nbsp;<a href="#">删除</a></td>
                </tr>
                </tbody>
            </table>
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