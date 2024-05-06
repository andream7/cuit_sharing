<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用连接池连接数据库</title>
</head>  
<body>
<jsp:useBean id="conpool" class="bean.ConnectionPool" scope="application" />
<body bgcolor="AliceBlue">
	<%
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//使用conpool对象调用getOneCon方法从连接池中获得一个连接对象
			con = conpool.getOneCon();
			if (con == null) {
				out.print("人数过多，稍后访问");
				return;
			}
			st = con.createStatement();
			rs = st.executeQuery("select * from goods where gprice>50");
			out.print("<table border=1>");
			out.print("<tr>");
			out.print("<th>商品编号</th>");
			out.print("<th>商品名称</th>");
			out.print("<th>商品价格</th>");
			out.print("</tr>");
			while (rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString(1) + "</td>");
				out.print("<td>" + rs.getString(2) + "</td>");
				out.print("<td>" + rs.getString(3) + "</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					//使用conpool对象调用releaseCon方法把连接对象放回连接池中
					conpool.releaseCon(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	%>
</body>
</html>