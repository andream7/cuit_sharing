package servlet.before;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(name = "before_noticeDetail", urlPatterns = { "/before_noticeDetail" })
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService as = new AdminService();
		String nid = request.getParameter("nid");
		List<Map<String, Object>> list = as.selectAnotice(nid);
		request.setAttribute("anotice", list.get(0));
		RequestDispatcher rds = request.getRequestDispatcher("admin/noticeDetail.jsp");
		rds.forward(request, response);
	}

}
