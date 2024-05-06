package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginServlet_1")
public class LoginServlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//���ñ��룬��ֹ��������
		String name = request.getParameter("user"); //��ȡ�ͻ��ύ����Ϣ
		String password = request.getParameter("pwd");//��ȡ�ͻ��ύ����Ϣ
		if(name == null || name.length() == 0){
			response.sendRedirect("login_1.jsp");
		}
		else if(password == null || password.length() == 0){
			response.sendRedirect("login_1.jsp");
		}
		else if(name.length() > 0 && password.length() > 0){
			if(name.equals("zhangsan") && password.equals("123")){
				// ת��
				RequestDispatcher dis = request.getRequestDispatcher("loginSuccess_1.jsp");
				dis.forward(request, response);
			}else{
				response.sendRedirect("login_1.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
