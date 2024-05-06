package servlet.admin;
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
import dto.AdminDTO;
@WebServlet("/admin_login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѹ���Ա��Ϣ���浽ʵ��ģ����
		AdminDTO adt = new AdminDTO();
		adt.setAname(request.getParameter("aname"));
		adt.setApwd(request.getParameter("apwd"));
		//ҵ���
		AdminService as = new AdminService();
		//��¼�ɹ�
		if(as.adminLogin(adt)){
			//�ѵ�¼�洢��session��
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", adt);
			//�����Ʒ����
			List<Map<String, Object>>  list = as.getGoodsType();
			session.setAttribute("goodsType", list);
			//��ת����̨��ҳ��
			RequestDispatcher rds = request.getRequestDispatcher("admin/main.jsp");
			rds.forward(request, response);
		}else{//��¼ʧ��
			response.sendRedirect("admin/loginerror.jsp");
		}
	}
}
