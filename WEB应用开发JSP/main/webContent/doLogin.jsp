<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/3/29
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page language="java" %>--%>
<%--<%@ page import="java.io.*, java.util.*" %>--%>
<%--<%@ page import="javax.servlet.*, javax.servlet.http.*" %>--%>
<%--<%@ page import="entities.User" %>--%>

<%--<%--%>
<%--    String name = request.getParameter("userName");--%>
<%--    String password = request.getParameter("pwd");--%>
<%--    String realN = application.getInitParameter("userName");--%>
<%--    String realP = application.getInitParameter("password");--%>
<%--    User user = new User();--%>
<%--    user.setUserName(name);--%>
<%--    user.setPwd(password);--%>
<%--    System.out.println(name+" "+password);--%>
<%--    if (name.equals(realN) && password.equals(realP)) {--%>
<%--        session.setAttribute("user", user);--%>
<%--        System.out.println(session.getAttribute("user").toString());--%>
<%--        request.getRequestDispatcher("/home.jsp").forward(request, response);--%>
<%--    } else {--%>
<%--        response.sendRedirect("login.jsp");--%>
<%--    }--%>
<%--%>--%>

<%--用jstl和el替代上面java代码的功能--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, javax.servlet.http.*" %>
<%@ page import="entities.User" %>

<%--<c:import var="webXml" url="WEB-INF/web.xml"></c:import>--%>
<%--<c:set var="name" value="${param.userName}"/>--%>
<%--<c:set var="password" value="${param.pwd}"/>--%>
<%--<c:set var="realN" value="${initParam.username}"/>--%>
<%--<c:set var="realP" value="${initParam.password}"/>--%>
<%--<c:set var="user" value="${entities.User()}"/>--%>
<%--<c:set var="user.userName" value="${name}"/>--%>
<%--<c:set var="user.pwd" value="${password}"/>--%>


<%--<c:if test="${name == realN && password == realP}">--%>
<%--    <c:set var="user" value="${user}" scope="session"/>--%>
<%--&lt;%&ndash;    &lt;%&ndash;%>--%>
<%--&lt;%&ndash;        User user = new User();&ndash;%&gt;--%>
<%--&lt;%&ndash;        user.setUserName("admin");&ndash;%&gt;--%>
<%--&lt;%&ndash;        user.setPwd("tomcat");&ndash;%&gt;--%>
<%--&lt;%&ndash;        session.setAttribute("user", user);&ndash;%&gt;--%>
<%--&lt;%&ndash;    %>&ndash;%&gt;--%>
<%--    <c:redirect url="${pageContext.request.contextPath}/home.jsp" />--%>
<%--</c:if>--%>
<%--<c:if test="${name != realN || password != realP}">--%>
<%--    <c:redirect url="login.jsp"/>--%>
<%--</c:if>--%>

<c:set var="name" value="${param.userName}"/>
<c:set var="password" value="${param.pwd}"/>
<c:set var="realN" value="${initParam.username}"/>
<c:set var="realP" value="${initParam.password}"/>
<c:set var="user" value="${entities.User}"/>
<c:set var="user.userName" value="${name}"/>
<c:set var="user.pwd" value="${password}"/>
<c:set var="userScope" value="${pageScope.user}"/>

<c:if test="${name == realN && password == realP}">
    <%
        User user = new User();
        user.setUserName("admin");
        user.setUserName(request.getParameter("userName"));
        user.setPwd(request.getParameter("pwd"));
        session.setAttribute("user", user);
    %>
    <c:redirect url="home.jsp"/>
</c:if>
<c:if test="${name != realN || password != realP}">
    <c:redirect url="login.jsp"/>
</c:if>
