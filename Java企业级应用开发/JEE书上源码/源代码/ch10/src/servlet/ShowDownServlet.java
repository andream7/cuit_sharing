package servlet;
import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/showDownServlet")
public class ShowDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ָ���ӷ�������uploadFilesĿ¼�У������ļ�
		File downLoadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		//���Ŀ¼�е��ļ�
		File[] list = downLoadFileDir.listFiles();
		request.setAttribute("fileList", list);
		RequestDispatcher dis = request.getRequestDispatcher("showInfo.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
