package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException{
		//������Ӧ����������
		response.setContentType("text/html;charset=utf-8");
		//ȡ���������
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		//�����������ʾ����һ��Servlet��
		out.println("��һ��Servlet��");
		out.println("</body></html>");
	} 
}
