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

import service.AdminService;

@WebServlet("/admin_userManager")
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String act = request.getParameter("act");//获得动作类型
	AdminService as = new AdminService();
	PrintWriter out = response.getWriter();
	List<Map<String, Object>> list = as.selectUsers();
	request.setAttribute("userList", list);
	RequestDispatcher rds = null;
	//查询
	if("manager".equals(act)){
		rds = request.getRequestDispatcher("admin/userManager.jsp");
		rds.forward(request, response);
	}else if("delete".equals(act)){
		String bid = request.getParameter("bid");
		String rs = as.deleteUser(bid);
		if("nodelete".equals(rs)){
			out.println("有子记录，删除失败！3秒钟返回！");
		}else{
			out.println("删除成功！3秒钟返回！");
		}
		response.setHeader("refresh", "3; url=admin_userManager?act=manager");
		return;
	}
	}

}
