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
@WebServlet(name = "userLogin", urlPatterns = { "/before_userLogin" })
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String bemail = request.getParameter("bemail");
	String bpwd = request.getParameter("bpwd");
	String code1 = request.getParameter("code");
	HttpSession session = request.getSession(true);
	//ʵ��
	UserDTO ud = new UserDTO();
	ud.setBemail(bemail);
	ud.setBpwd(bpwd);
	//ҵ��
	BeforeUserService bs = new BeforeUserService();
	//��ȡ��֤��
	String code2 = (String)session.getAttribute("rand");
	RequestDispatcher rds = null;
	//��֤��������ȷ
	if(code2.equalsIgnoreCase(code1)){
		//�����������
		if(bs.isExit(ud).size() < 1 ){
			request.setAttribute("bemailError", "�����������");
			rds = request.getRequestDispatcher("beforeUser/userLogin.jsp");
		}else if(bs.isLogin(ud).size() < 1){//������ȷ���������
			request.setAttribute("bpwdError", "�����������");
			rds = request.getRequestDispatcher("beforeUser/userLogin.jsp");
		}else{
			//��bid�浽ud��
			ud.setId((Integer)(bs.isLogin(ud).get(0)).get("id"));
			session.setAttribute("user", ud);
			//��¼�ɹ���ת����ҳ
			rds = request.getRequestDispatcher("before_first?typeid=0");
		}
	}else{
		request.setAttribute("codeError", "��֤���������");
		rds = request.getRequestDispatcher("beforeUser/userLogin.jsp");
	}
	rds.forward(request, response);
	}
}
