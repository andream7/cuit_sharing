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
import service.AdminService;
@WebServlet("/admin_selectGoods")
public class SelectGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	AdminService as = new AdminService();
	List<Map<String, Object>>  list = null;
	//获得动作类型
	String act = request.getParameter("act");
	//条件查询
	String gname = request.getParameter("gname");
	String typeid = request.getParameter("typeid");
	//在条件查询分页URL中使用
	String gname1 = request.getParameter("gname1");
	//条件查询首页
	if(gname1 == null) {
		gname1 = gname;
	}else {
		//解码URL中的中文
		gname1 = java.net.URLDecoder.decode(gname1,"utf-8");
	}
	//条件查询非首页
	if(gname == null) {
		gname = gname1;
	}
	//条件查询
	if("condiction".equals(act)){
		list = as.conditionSelectGoods(gname, typeid);
	}else{
		list = as.selectGoods();
	}	
	RequestDispatcher rds = null;
	//分页查询
	int temp = list.size();
	request.setAttribute("totalCount", temp);
	int totalPage = 0;
	if (temp == 0) {
		totalPage = 0;//总页数
	} else {
		//返回大于或者等于指定表达式的最小整数
		totalPage = (int) Math.ceil((double) temp / 10);
	}
	String pageCur11 = request.getParameter("pageCur");
	if (pageCur11 == null) {
		pageCur11 = "1";
	}
	int  pageCur = Integer.parseInt(pageCur11);
	if ((pageCur - 1) * 10 > temp) {
		pageCur = pageCur - 1;
	}
	//分页查询
	int startIndex = (pageCur - 1) * 10;//起始位置
	int perPageSize = 10;//每页10个
	if("condiction".equals(act)) {
		list = as.conditionSelectGoodsByPage(gname, typeid, startIndex, perPageSize);
	}else {
		list = as.selectAllGoodsByPage(startIndex, perPageSize);
	}
	//回显查询条件
	request.setAttribute("gname1", gname1);
	request.setAttribute("act", act);
	request.setAttribute("typeid", typeid);
	request.setAttribute("allGoods", list);
	request.setAttribute("totalPage", totalPage);
	request.setAttribute("pageCur", pageCur);
	//查询页面
	if("select".equals(act) || "condiction".equals(act)){
		rds = request.getRequestDispatcher("admin/selectAllGoods.jsp");
	}
	//修改查询页面
	else if("updateSelect".equals(act)){
		rds = request.getRequestDispatcher("admin/updateSelect.jsp");
	}
	//删除查询页面
	else if("deleteSelect".equals(act)){
		rds = request.getRequestDispatcher("admin/deleteSelect.jsp");
	}
	rds.forward(request, response);
	}
}
