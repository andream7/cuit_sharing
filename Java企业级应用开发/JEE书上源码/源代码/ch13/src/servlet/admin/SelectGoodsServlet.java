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
	//��ö�������
	String act = request.getParameter("act");
	//������ѯ
	String gname = request.getParameter("gname");
	String typeid = request.getParameter("typeid");
	//��������ѯ��ҳURL��ʹ��
	String gname1 = request.getParameter("gname1");
	//������ѯ��ҳ
	if(gname1 == null) {
		gname1 = gname;
	}else {
		//����URL�е�����
		gname1 = java.net.URLDecoder.decode(gname1,"utf-8");
	}
	//������ѯ����ҳ
	if(gname == null) {
		gname = gname1;
	}
	//������ѯ
	if("condiction".equals(act)){
		list = as.conditionSelectGoods(gname, typeid);
	}else{
		list = as.selectGoods();
	}	
	RequestDispatcher rds = null;
	//��ҳ��ѯ
	int temp = list.size();
	request.setAttribute("totalCount", temp);
	int totalPage = 0;
	if (temp == 0) {
		totalPage = 0;//��ҳ��
	} else {
		//���ش��ڻ��ߵ���ָ�����ʽ����С����
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
	//��ҳ��ѯ
	int startIndex = (pageCur - 1) * 10;//��ʼλ��
	int perPageSize = 10;//ÿҳ10��
	if("condiction".equals(act)) {
		list = as.conditionSelectGoodsByPage(gname, typeid, startIndex, perPageSize);
	}else {
		list = as.selectAllGoodsByPage(startIndex, perPageSize);
	}
	//���Բ�ѯ����
	request.setAttribute("gname1", gname1);
	request.setAttribute("act", act);
	request.setAttribute("typeid", typeid);
	request.setAttribute("allGoods", list);
	request.setAttribute("totalPage", totalPage);
	request.setAttribute("pageCur", pageCur);
	//��ѯҳ��
	if("select".equals(act) || "condiction".equals(act)){
		rds = request.getRequestDispatcher("admin/selectAllGoods.jsp");
	}
	//�޸Ĳ�ѯҳ��
	else if("updateSelect".equals(act)){
		rds = request.getRequestDispatcher("admin/updateSelect.jsp");
	}
	//ɾ����ѯҳ��
	else if("deleteSelect".equals(act)){
		rds = request.getRequestDispatcher("admin/deleteSelect.jsp");
	}
	rds.forward(request, response);
	}
}
