package servlet.admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AdminService;
@WebServlet("/admin_Type")
public class AdminType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		AdminService as = new AdminService();
		if("add".equals(act)) {
			String typename = request.getParameter("typename");
			as.addType(typename);
			//获得商品类型
			List<Map<String, Object>>  list = as.getGoodsType();
			HttpSession session = request.getSession(true);
			session.setAttribute("goodsType", list);
			response.sendRedirect("admin_Type?act=deleteSelect");
		}else if("deleteSelect".equals(act)) {
			List<Map<String, Object>> allType = as.getGoodsType();
			request.setAttribute("allType", allType);
			RequestDispatcher rds = request.getRequestDispatcher("admin/deleteType.jsp");
			rds.forward(request, response);
		}else if("delete".equals(act)) {
			String id = request.getParameter("id");
			String s = as.deleteType(id);
			//获得商品类型
			List<Map<String, Object>>  list = as.getGoodsType();
			HttpSession session = request.getSession(true);
			session.setAttribute("goodsType", list);
			PrintWriter out = response.getWriter();
			out.println(s);
			response.setHeader("refresh", "3; url=admin_Type?act=deleteSelect");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
