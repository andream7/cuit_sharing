package servlet.before;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.BeforeUserService;
import dto.UserDTO;
@WebServlet("/before_focus")
public class FocusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String gno = request.getParameter("gno");
	HttpSession session = request.getSession(true);
	int bid = ((UserDTO)session.getAttribute("user")).getId();
	//ҵ���
	BeforeUserService bs = new BeforeUserService();
	String rs = bs.focusGoods(gno, bid);
	PrintWriter out = response.getWriter();
	//�ѹ�ע
	if("focused".equals(rs)){
		out.println("�ѹ�ע����Ʒ��3���ӷ��أ�");
	}else{
		if("focusSuccess".equals(rs)){
			out.println("�ɹ���ע����Ʒ��3���ӷ��أ�");
		}else{
			out.println("��עʧ�ܣ�3���ӷ��أ�");
		}
	}
	response.setHeader("refresh", "3; url=before_detail?gno=" + gno);
	return;
	}
}
