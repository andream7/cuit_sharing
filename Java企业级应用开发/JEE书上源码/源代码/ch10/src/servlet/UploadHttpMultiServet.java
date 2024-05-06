package servlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import util.MyUtil;
@WebServlet("/uploadHttpMultiServet")
@MultipartConfig
public class UploadHttpMultiServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应的内容类型
		response.setContentType("text/html;charset=utf-8");
		//取得输出对象
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		String filediscription1 = request.getParameter("filediscription1");
		out.println("输入的文件1描述：" + filediscription1 + "<br>");
		String filediscription2 = request.getParameter("filediscription2");
		out.println("输入的文件2描述：" + filediscription2 + "<br>");
		//指定上传的文件保存到服务器的uploadFiles目录中
		File uploadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		if(!uploadFileDir.exists()){
			uploadFileDir.mkdir();
		}
		//获得Part集合
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			//没有选择文件或不是文件域
			if (part == null || !part.getName().contains("resPat")) {
			   continue;
			}
			//获得原始文件名
			String oldName = MyUtil.getFileName(part);
			out.println("上传文件的原始名：" + oldName + "<br>");
			out.println("上传文件的大小：" + part.getSize() + "<br>");
			if(oldName != null){
				//上传到服务器的uploadFiles目录中
				part.write(uploadFileDir + File.separator + oldName);
			}
			out.println("文件上传到：" + uploadFileDir + File.separator + oldName + "<br>");
		}
	}
}
