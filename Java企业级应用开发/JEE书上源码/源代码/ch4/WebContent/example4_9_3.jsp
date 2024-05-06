<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_9_3.jsp</title>
</head>
<body>
	<%
		//获取考号
		//获取session中关键字是id的对象（考号）
		String id = (String) session.getAttribute("id");
		//计算成绩
		int sum = 0;
		//如果单项选择第一题选中D选项，得2分。
		//获取session中关键字是one的对象（选择答案）
		String first = (String) session.getAttribute("one");
		if ("D".equals(first)) {
			sum += 2;
		}
		//如果判断第一题选中True，得2分。
		//获取session中关键字是two的对象（判断答案）
		String second = (String) session.getAttribute("two");
		if ("True".equals(second)) {
			sum += 2;
		}
	%>
	您的成绩公布如下：
	<table border="1">
		<tr>
			<th width="50%">
				考号
			</th>
			<th width="50%">
				成绩
			</th>
		</tr>
		<tr>
			<td><%=id%></td>
			<td align="right"><%=sum%></td>
		</tr>
	</table>
</body>
</html>
