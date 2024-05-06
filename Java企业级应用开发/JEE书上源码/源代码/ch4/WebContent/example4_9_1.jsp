<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_9_1.jsp</title>
</head>
<body>
	<form action="example4_9_2.jsp" method="post">
			考号：
			<input type="text" name="id"/>
			<p>
				一、单项选择题（每题2分）
				<br/><br/>
				1.下列哪个方法是获取session中关键字是key的对象（ ）。
				<br />
				<input type="radio" name="one" value="A"/>
				A．public void setAttribute(String key, Object obj)<br/>
				<input type="radio" name="one" value="B"/>
				B．public void removeAttribute(String key)<br/>
				<input type="radio" name="one" value="C"/>
				C．public Enumeration getAttributeNames()<br/>
				<input type="radio" name="one" value="D"/>
				D．public Object getAttibute(String key)<br/>
			</p>
			<p>
				二、判断题（每题2分）
				<br/><br/>
				1.同一用户在多个Web服务中，所对应的session对象是互不相同的。
				<br/>
				<input type="radio" name="two" value="True"/>
				True
				<input type="radio" name="two" value="False"/>
				False
			</p><br/>
			<input type="submit" value="提交" name=submit>
			<input type="reset" value="重置" name=reset>
		</form>
</body>
</html>
