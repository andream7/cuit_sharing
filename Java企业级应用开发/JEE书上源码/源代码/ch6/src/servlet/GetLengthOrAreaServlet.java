package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "getLengthOrAreaServlet", urlPatterns = { "/getLengthOrAreaServlet" })
public class GetLengthOrAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String l = request.getParameter("length");   
		String w = request.getParameter("width");
		out.println("<html><body>");
		double m = 0 ,n = 0;
		try{
			m = Double.parseDouble(l);
			n = Double.parseDouble(w);
			out.println("���ε��ܳ��ǣ�" + ( m + n ) * 2);
		}catch(NumberFormatException e){
			out.println("�����������ַ���");
		}
		out.println("</body></html>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String l = request.getParameter("length");   
		String w = request.getParameter("width");
		out.println("<html><body>");
		double m = 0, n = 0;
		try{
			m = Double.parseDouble(l);
			n = Double.parseDouble(w);
			out.println("���ε�����ǣ�" + m * n);
		}catch(NumberFormatException e){
			out.println("�����������ַ���");
		}
		out.println("</body></html>");
	}
}
