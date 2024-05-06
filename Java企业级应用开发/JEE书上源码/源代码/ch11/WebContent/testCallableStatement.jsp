<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CallableStatement对象的使用</title>
</head>
<body>
<%
		Connection con = null;
		CallableStatement cs1 = null;
		CallableStatement cs2 = null;
		CallableStatement cs3 = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System88",
					"System88");
			// 调用存储过程pkg_test.TEST_ADDGOODS添加1个商品
			cs1 = con.prepareCall("call pkg_test.TEST_ADDGOODS(?,?,?,?)");
			// 设置IN类型的参数值
			cs1.setInt(1, 9);
			cs1.setString(2, "XX牙刷");
			cs1.setInt(3, 500);
			cs1.setString(4, "日用品");
			cs1.execute();
			out.print("调用存储过程pkg_test.TEST_ADDGOODS成功添加一个商品。" + "<br>");
			// 调用存储过程pkg_test.TEST_GETCOUNT统计商品价格大于400
			cs2 = con.prepareCall("call pkg_test.TEST_GETCOUNT(?,?)");
			// 设置IN类型的参数值
			cs2.setInt(1, 400);
			// 注册OUT类型的参数
			cs2.registerOutParameter(2, Types.INTEGER);// java.sql包中的Types
			cs2.execute();
			// getXxx(index)中的index 需要和上面registerOutParameter的index对应
			int count = cs2.getInt(2);
		out.print("调用存储过程pkg_test.TEST_GETCOUNT统计商品价格大于400的商品共有：" + count + "个。<br>");
			// 调用存储过程pkg_test.TEST_GETGOODS获得商品价格大于400的信息
			cs3 = con.prepareCall("call pkg_test.TEST_GETGOODS(?,?)");
			// 设置IN类型的参数值
			cs3.setInt(1, 400);
			cs3.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);// Oracle游标
			cs3.execute();
			// 由游标转换为结果集
			rs = (ResultSet)cs3.getObject(2);
			// 遍历价格大于400的商品
		out.print("调用存储过程pkg_test.TEST_GETGOODS获得价格大于400的商品有：" + "<br>");
			while(rs.next()){
				out.print("GOODSID：" + rs.getString(1) + " " 
						+ "GOODSNAME：" + rs.getString(2) + " "
						+ "GOODSPRICE：" + rs.getString(3) + " "
						+ "GOODSTYPE：" + rs.getString(4) + "<br>");
			}
			cs1.close();
			cs2.close();
			cs3.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
%>
</body>
</html>
