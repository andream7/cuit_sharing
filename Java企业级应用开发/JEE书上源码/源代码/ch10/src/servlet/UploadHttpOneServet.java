package servlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import util.MyUtil;
@WebServlet("/uploadHttpOneServet")
@MultipartConfig(maxFileSize = 10*1024*1024)//�����ϴ��ļ������ֵΪ10M
public class UploadHttpOneServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ����������
		response.setContentType("text/html;charset=utf-8");
		//ȡ���������
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		//���Part����
		Part part = request.getPart("resPath");
		String filediscription = request.getParameter("filediscription");
		out.println("������ļ�������" + filediscription + "<br>");
		//ָ���ϴ����ļ����浽��������uploadFilesĿ¼��
		File uploadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		if(!uploadFileDir.exists()){
			uploadFileDir.mkdir();
		}
		//���ԭʼ�ļ���
		String oldName = MyUtil.getFileName(part);
		out.println("�ϴ��ļ���ԭʼ����" + oldName + "<br>");
		out.println("�ϴ��ļ��Ĵ�С��" + part.getSize() + "<br>");
		if(oldName != null){
			//�ϴ�����������uploadFilesĿ¼��
			part.write(uploadFileDir + File.separator + oldName);
		}
		out.println("�ļ��ϴ�����" + uploadFileDir + File.separator + oldName + "<br>");
	}
}
