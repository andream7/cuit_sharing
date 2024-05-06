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
import javax.servlet.http.HttpSession;
import service.AdminService;
import dto.AdminDTO;
@WebServlet("/admin_login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//把管理员信息保存到实体模型中
		AdminDTO adt = new AdminDTO();
		adt.setAname(request.getParameter("aname"));
		adt.setApwd(request.getParameter("apwd"));
		//业务层
		AdminService as = new AdminService();
		//登录成功
		if(as.adminLogin(adt)){
			//把登录存储到session中
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", adt);
			//获得商品类型
			List<Map<String, Object>>  list = as.getGoodsType();
			session.setAttribute("goodsType", list);
			//跳转到后台主页面
			RequestDispatcher rds = request.getRequestDispatcher("admin/main.jsp");
			rds.forward(request, response);
		}else{//登录失败
			response.sendRedirect("admin/loginerror.jsp");
		}
	}
}
