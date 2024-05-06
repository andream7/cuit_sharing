package servlet.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dto.GoodsDTO;
import service.AdminService;
import util.MyUtil;

@WebServlet("/admin_addGoods")
@MultipartConfig(maxFileSize = 10*1024*1024)//�����ϴ��ļ������ֵΪ10M
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDTO gd = new GoodsDTO();//ʵ��ģ��
		//��ö������ͣ�����ͨ�������ύ�����Կ���ͨ��request��ȡ
		String act =  request.getParameter("act");
		//���Part����
		Part part = request.getPart("gpicture");
		//ָ���ϴ����ļ����浽��������uploadFileĿ¼��
		File uploadFileDir = new File(getServletContext().getRealPath("/uploadFile"));
		if(!uploadFileDir.exists()){
			uploadFileDir.mkdir();
		}
		//���ԭʼ�ļ���
		String oldName = MyUtil.getFileName(part);
		try{
			String gname = request.getParameter("gname");
			String gpicture = null;
			if("add".equals(act)){
				if(oldName != null){
					//�ϴ�ʱ�����ļ���
					gpicture = MyUtil.getStringID() + oldName.substring(oldName.lastIndexOf("."));
					//�ϴ�ͼƬ
					part.write(uploadFileDir + File.separator + gpicture);
				}
			}else if("update".equals(act)){
				gd.setId(Integer.parseInt(request.getParameter("gno")));
				//�޸�ʱû��ѡ��ͼƬ��ʹ�þ�ͼƬ
				if(oldName == null){
					gpicture = request.getParameter("oldgpicture");
				}else{
					//�ϴ�ʱ�����ļ���
					gpicture = MyUtil.getStringID() + oldName.substring(oldName.lastIndexOf("."));
					//�ϴ�ͼƬ
					part.write(uploadFileDir + File.separator + gpicture);
				}
			}
			double goprice = Double.parseDouble(request.getParameter("goprice"));
			double grprice = Double.parseDouble(request.getParameter("grprice"));
			int gstore = Integer.parseInt(request.getParameter("gstore"));
			int typeid = Integer.parseInt(request.getParameter("typeid"));
			gd.setGname(gname);
			gd.setGpicture(gpicture);
			gd.setGoprice(goprice);
			gd.setGrprice(grprice);
			gd.setGoodstype_id(typeid);
			gd.setGstore(gstore);
		}catch(Exception e){
			//������������
			response.sendRedirect("admin/addGoods.jsp");
			return ;
		}
		//ҵ���
		AdminService as = new AdminService();
		//���
		if("add".equals(act)){
			//�ɹ�
			if(as.addGoods(gd)){
				//��ת����̨��ҳ��
				response.sendRedirect("admin_selectGoods?act=select");
			}else{
				response.sendRedirect("admin/addGoods.jsp");
			}
		}
		//�޸�
		else if("update".equals(act)){
			//�ɹ�
			if(as.updateGoods(gd)){
				//��ת����̨��ҳ��
				response.sendRedirect("admin_selectGoods?act=select");
			}else{
				//ʧ�������޸�ҳ��
				response.sendRedirect("admin_detail?act=updateAgoods&gno=" + gd.getId());
			}
		}
	}
}
