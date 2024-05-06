<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>访问MySQL数据库</title>
</head>
<body>
	<%
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//建立连接
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8","root","root");
			st = con.createStatement();
			//发送查询SQL语句，返回结果集
			rs = st.executeQuery("select * from goods ");
			while(rs.next()){
				out.print(rs.getString("id") + "&nbsp;&nbsp;");
				out.print(rs.getString("gname") + "&nbsp;&nbsp;");
				out.print(rs.getString("gprice") + "&nbsp;&nbsp;");
				out.print("<br>");
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs.close();
			st.close();
			con.close();
		}	
	%>
</body>
</html>