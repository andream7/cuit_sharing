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

@WebServlet(name = "before_detail", urlPatterns = { "/before_detail" })
public class BeforeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����Ʒ���
		String gno = request.getParameter("gno");
		AdminService as = new AdminService();
		List<Map<String, Object>> list = as.selectAGoods(gno);
		//��һ����Ʒ��ϸ��Ϣ�浽request��
		request.setAttribute("agoods", list.get(0));
		RequestDispatcher rds =request.getRequestDispatcher("beforeUser/goodsdetail.jsp");
		rds.forward(request, response);
	}
}
