package servlet.before;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.BeforeUserService;
import dto.UserDTO;
@WebServlet(name = "before_putCart", urlPatterns = { "/before_putCart" })
public class PutCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gno = request.getParameter("gno");//��ƷID
		String mknum = request.getParameter("mknum");//��������
		HttpSession session = request.getSession(true);
		int bid = ((UserDTO)session.getAttribute("user")).getId();
		//ҵ���
		BeforeUserService bs = new BeforeUserService();
		RequestDispatcher rds = null;
		//�ɹ������ﳵҳ��
		if(bs.putCart(gno, bid, mknum)){
			rds = request.getRequestDispatcher("before_selectCart");
		}else{
			rds = request.getRequestDispatcher("beforeUser/operateerror.jsp");
		}
		rds.forward(request, response);
	}
}
