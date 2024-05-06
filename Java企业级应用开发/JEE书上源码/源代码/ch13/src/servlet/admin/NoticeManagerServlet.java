package servlet.admin;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.NoticeDTO;
import service.AdminService;
@WebServlet("/admin_noticeManager")
public class NoticeManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String act = request.getParameter("act");//获得动作类型
	AdminService as = new AdminService();
	List<Map<String, Object>> list = as.selectNotice();//查询公告
	request.setAttribute("noticeList", list);
	RequestDispatcher rds = null;
	//查询
	if("manager".equals(act)){
		rds = request.getRequestDispatcher("admin/noticeManager.jsp");
	}else if("add".equals(act)){
		NoticeDTO nd = new NoticeDTO(); 
		String ntitle = request.getParameter("ntitle");       
		String ncontent = request.getParameter("ncontent");
		nd.setNtitle(ntitle);
		nd.setNcontent(ncontent);
		as.addNotice(nd);//添加
		rds = request.getRequestDispatcher("admin_noticeManager?act=manager");
	}
	rds.forward(request, response);
	}
}
