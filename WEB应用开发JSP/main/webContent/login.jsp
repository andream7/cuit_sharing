<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <style type="text/css">
        .modal-footer {
            border-top: 0px;
        }
    </style>
</head>
<body>
<!--login modal-->
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h1 class="text-center">登录</h1>
            </div>
            <div class="modal-body">
                <form class="form col-md-12 center-block" action="doLogin.jsp" method="post">
                    <div class="form-group">
                        <input type="text" name="userName" class="form-control input-lg" placeholder="用户名">
                    </div>
                    <div class="form-group">
                        <input type="password" name="pwd" class="form-control input-lg" placeholder="密码">
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="autoLogin"> 下一次自动登录
                        </label>
                    </div>
                    <div class="btn-group pull-right">
                        <button class="reset btn btn-default">重置</button>
                        <button class="submit btn btn-primary">登录</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>



<!-- script references -->
<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
<script type='text/javascript' src="js/bootstrap.min.js"></script>


</body>
</html>

