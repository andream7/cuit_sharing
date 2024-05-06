package servlet.admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AdminService;
@WebServlet("/admin_deleteGoods")
public class DeleteGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	AdminService as = new AdminService();
	PrintWriter out = response.getWriter();
	//获得动作类型
	String act = request.getParameter("act");
	String rs = null;
	if("link".equals(act)){//点击链接删除
		String gno = request.getParameter("gno");
		//单个删除
		rs = as.deleteAgoods(gno);
	}else if("button".equals(act)){//点击按钮删除
		//获取页面上选中的商品ID
		String gno[] = request.getParameterValues("gno");
		//批量删除
		rs = as.deleteManygoods(gno);
	}
	if("ok".equals(rs)){//删除成功
		//返回查询页面
		out.println("删除成功！3秒钟返回！");
	}else{
		out.println("有子记录，删除失败！3秒钟返回！");
	}
	response.setHeader("refresh", "3; url=admin_selectGoods?act=deleteSelect");
	return;	
	}
}
