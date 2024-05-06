package servlet.before;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.BeforeUserService;
import dto.UserDTO;
@WebServlet("/before_focus")
public class FocusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String gno = request.getParameter("gno");
	HttpSession session = request.getSession(true);
	int bid = ((UserDTO)session.getAttribute("user")).getId();
	//业务层
	BeforeUserService bs = new BeforeUserService();
	String rs = bs.focusGoods(gno, bid);
	PrintWriter out = response.getWriter();
	//已关注
	if("focused".equals(rs)){
		out.println("已关注该商品！3秒钟返回！");
	}else{
		if("focusSuccess".equals(rs)){
			out.println("成功关注该商品！3秒钟返回！");
		}else{
			out.println("关注失败！3秒钟返回！");
		}
	}
	response.setHeader("refresh", "3; url=before_detail?gno=" + gno);
	return;
	}
}
