package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//����urlPatterns��ֵ������һ��������ά������ʹ��@WebServlet("/secondServlet")��ע�⡣
@WebServlet(name = "secondServlet", urlPatterns = { "/secondServlet" }) 
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ����������
		response.setContentType("text/html;charset=utf-8");
		//ȡ���������
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		//�����������ʾ���ڶ���Servlet��
		out.println("�ڶ���Servlet��");
		out.println("</body></html>");
	}
}
