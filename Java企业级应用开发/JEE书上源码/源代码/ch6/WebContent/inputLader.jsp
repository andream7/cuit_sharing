<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inputLader.jsp</title>
</head>
 <body>
    <h2>输入矩形的长和宽，提交给servlet（post方式）求面积:</h2>
    <form action="getLengthOrAreaServlet" method="post">
    	长：<input type="text" name="length"/><br/>
    	宽：<input type="text" name="width"/><br/>
    	<input type="submit" value="提交"/>
    </form>
     <br/>
    <h2>输入矩形的长和宽，提交给servlet（get方式）求周长:</h2>
    <form action="getLengthOrAreaServlet" method="get">
    	长：<input type="text" name="length"/><br/>
    	宽：<input type="text" name="width"/><br/>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>