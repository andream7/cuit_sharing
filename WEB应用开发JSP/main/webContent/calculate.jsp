<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/3/19
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" %>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, javax.servlet.http.*" %>

<%
    try {
        int dividend = Integer.parseInt(request.getParameter("dividend"));
        int divisor = Integer.parseInt(request.getParameter("divisor"));
        int result = dividend / divisor;
        response.sendRedirect("returnPage.jsp?message=" + result);
    } catch (NumberFormatException e) {
        response.sendRedirect("error.jsp?message=please input legal number");
    } catch (ArithmeticException e) {
        response.sendRedirect("error.jsp?message=the divisor can not be zero");
    }
%>

<%--①获取表单用户名和密码，②获取web.xml中的用户名和密码，③验证用户名/密码；④验证成功将用户名保存到session对象，⑤跳转到相应的页面，⑥在home页面显示登录信息--%>
<%--请用EL写法和JSTL完成上面的操作--%>
