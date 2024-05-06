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
import javax.servlet.http.HttpSession;

import service.AdminService;
import service.BeforeUserService;

@WebServlet(name = "first", urlPatterns = { "/before_first" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typeid = request.getParameter("typeid");//�����Ʒ����
		AdminService as = new AdminService();
		BeforeUserService bs = new BeforeUserService();
		//�ѵ�¼�洢��session��
		HttpSession session = request.getSession(true);
		//�����Ʒ����
		List<Map<String, Object>>  list = as.getGoodsType();
		session.setAttribute("goodsType", list);
		//���������Ʒ
		List<Map<String, Object>>  lastedlist = bs.getLastedGoods(typeid);
		//�������������Ʒ
		List<Map<String, Object>>  salelist = bs.getSaleOrder();
		//�����������
		List<Map<String, Object>>  focuslist = bs.getFocusOrder();
		//��ù���
		List<Map<String, Object>>  noticelist = bs.getNotice();
		request.setAttribute("lastedlist", lastedlist);
		request.setAttribute("salelist", salelist);
		request.setAttribute("focuslist", focuslist);
		request.setAttribute("noticelist", noticelist);
		RequestDispatcher rds = request.getRequestDispatcher("beforeUser/index.jsp");
		rds.forward(request, response);
	}
}
