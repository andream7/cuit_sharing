<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useSession.jsp</title>
</head>
  <body>
   <form action="<%=response.encodeURL("sendMyName")%>" method="post">
    	<table>
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="user"/></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="提交"/></td>
    		</tr>
    	</table>	
    </form>
  </body>
</html>
