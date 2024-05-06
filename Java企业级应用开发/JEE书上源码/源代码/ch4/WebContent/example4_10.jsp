<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>example4_10.jsp</title>
</head>
<body>
<%
	// session调用setMaxInactiveInterval(int n)方法设置最长“发呆”时间为10秒
	session.setMaxInactiveInterval(10);
	//session调用isNew()方法判断session是不是新创建的
 	boolean flg = session.isNew();
 	if (flg) {
 		out.println("欢迎您第一次访问当前Web服务。");
 		out.println("<hr/>");
 	}
 	out.println("session允许的最长发呆时间为：" + 
		session.getMaxInactiveInterval()+ "秒。");
 	//获取session对象被创建的时间
 	long num = session.getCreationTime();
 	//将整数转换为Date对象
 	Date time = new Date(num);
 	//用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat对象
 	SimpleDateFormat matter = new SimpleDateFormat(
 	 			"北京时间：yyyy年MM月dd日HH时mm分ss秒E。");
 	//得到格式化后的字符串
 	String strTime = matter.format(time);
 	out.println("<br/>session的创建时间为：" + strTime);
 	out.println("<br/>session的id为：" + session.getId() + "。");
 %> 
</body>
</html>
