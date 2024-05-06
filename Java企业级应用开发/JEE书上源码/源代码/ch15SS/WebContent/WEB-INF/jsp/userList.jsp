<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>用户列表</h1>
    <a href="<c:url value="${pageContext.request.contextPath }/user/input"/>">继续添加</a>
    <table>
        <tr>
            <th>用户名</th>
            <th>兴趣爱好</th>
            <th>朋友</th>
            <th>职业</th>
            <th>户籍</th>
            <th>个人描述</th>
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.userName }</td>
                <td>
                	<c:forEach items="${user.hobby }" var="hobby">
                		${hobby }&nbsp;
                	</c:forEach>
                </td>
                <td>
                	<c:forEach items="${user.friends }" var="friend">
                		${friend }&nbsp;
                	</c:forEach>
                </td>
                <td>${user.carrer }</td>
                <td>${user.houseRegister }</td>
                <td>${user.remark }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>