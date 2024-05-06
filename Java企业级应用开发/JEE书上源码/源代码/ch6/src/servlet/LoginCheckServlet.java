package servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserCheck;
import dto.User;
@WebServlet(name = "loginCheckServlet", urlPatterns = { "/loginCheckServlet" })
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		User user = new User();// ʵ����ʵ��ģ��user
		user.setName(name);// �����ݴ���ģ��user��
		user.setPwd(pwd);// �����ݴ���ģ��user��
		UserCheck uc = new UserCheck();// ʵ����ҵ��ģ��userCheck
		if (uc.validate(user)) {
			// ��װ�����ݵ�ʵ��ģ��user���洢��request��Χ��
			request.setAttribute("user", user);
			RequestDispatcher dis = request
					.getRequestDispatcher("loginSuccess.jsp");
			dis.forward(request, response);
		} else {
			response.sendRedirect("loginCheck.jsp");
		}
	}
}
