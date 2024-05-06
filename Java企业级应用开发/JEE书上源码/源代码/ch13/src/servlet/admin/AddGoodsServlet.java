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
@MultipartConfig(maxFileSize = 10*1024*1024)//设置上传文件的最大值为10M
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDTO gd = new GoodsDTO();//实体模型
		//获得动作类型，不是通过表单域提交，所以可以通过request获取
		String act =  request.getParameter("act");
		//获得Part对象
		Part part = request.getPart("gpicture");
		//指定上传的文件保存到服务器的uploadFile目录中
		File uploadFileDir = new File(getServletContext().getRealPath("/uploadFile"));
		if(!uploadFileDir.exists()){
			uploadFileDir.mkdir();
		}
		//获得原始文件名
		String oldName = MyUtil.getFileName(part);
		try{
			String gname = request.getParameter("gname");
			String gpicture = null;
			if("add".equals(act)){
				if(oldName != null){
					//上传时的新文件名
					gpicture = MyUtil.getStringID() + oldName.substring(oldName.lastIndexOf("."));
					//上传图片
					part.write(uploadFileDir + File.separator + gpicture);
				}
			}else if("update".equals(act)){
				gd.setId(Integer.parseInt(request.getParameter("gno")));
				//修改时没有选择图片，使用旧图片
				if(oldName == null){
					gpicture = request.getParameter("oldgpicture");
				}else{
					//上传时的新文件名
					gpicture = MyUtil.getStringID() + oldName.substring(oldName.lastIndexOf("."));
					//上传图片
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
			//数据输入有误
			response.sendRedirect("admin/addGoods.jsp");
			return ;
		}
		//业务层
		AdminService as = new AdminService();
		//添加
		if("add".equals(act)){
			//成功
			if(as.addGoods(gd)){
				//跳转到后台主页面
				response.sendRedirect("admin_selectGoods?act=select");
			}else{
				response.sendRedirect("admin/addGoods.jsp");
			}
		}
		//修改
		else if("update".equals(act)){
			//成功
			if(as.updateGoods(gd)){
				//跳转到后台主页面
				response.sendRedirect("admin_selectGoods?act=select");
			}else{
				//失败跳到修改页面
				response.sendRedirect("admin_detail?act=updateAgoods&gno=" + gd.getId());
			}
		}
	}
}
