package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "loginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");//���ñ��룬��ֹ��������
		String name = request.getParameter("user"); //��ȡ�ͻ��ύ����Ϣ
		String password = request.getParameter("pwd");//��ȡ�ͻ��ύ����Ϣ
		out.println("<html><body>");
		if(name == null || name.length() == 0){
			out.println("�������û���");
		}
		else if(password == null || password.length() == 0){
			out.println("����������");
		}
		else if(name.length() > 0 && password.length() > 0){
			if(name.equals("zhangsan") && password.equals("lisi")){
				out.println("��Ϣ������ȷ");
			}else{
				out.println("��Ϣ�������");
			}
		}
		out.println("</body></html>");
	} 
}
