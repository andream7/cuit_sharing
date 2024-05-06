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
	//��ö�������
	String act = request.getParameter("act");
	String rs = null;
	if("link".equals(act)){//�������ɾ��
		String gno = request.getParameter("gno");
		//����ɾ��
		rs = as.deleteAgoods(gno);
	}else if("button".equals(act)){//�����ťɾ��
		//��ȡҳ����ѡ�е���ƷID
		String gno[] = request.getParameterValues("gno");
		//����ɾ��
		rs = as.deleteManygoods(gno);
	}
	if("ok".equals(rs)){//ɾ���ɹ�
		//���ز�ѯҳ��
		out.println("ɾ���ɹ���3���ӷ��أ�");
	}else{
		out.println("���Ӽ�¼��ɾ��ʧ�ܣ�3���ӷ��أ�");
	}
	response.setHeader("refresh", "3; url=admin_selectGoods?act=deleteSelect");
	return;	
	}
}
