package servlet;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "thirdServlet", urlPatterns = { "/thirdServlet" },
initParams={@WebInitParam(name = "firstParam", value = "one"),
		@WebInitParam(name = "secondParam", value = "two")})
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String first = null;
	private String second = null;
	private static int count = 0;
	public void init(ServletConfig config) throws ServletException {
		//��ò���firstParam��ֵ
		first = config.getInitParameter("firstParam");
		second = config.getInitParameter("secondParam");
		System.out.println("��һ������ֵ��" + first);
		System.out.println("�ڶ�������ֵ��" + second);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count ++ ;
		System.out.println("���ǵ�" + count + "���ͻ��������Servlet!");
	}
	public void destroy() {
	}
}