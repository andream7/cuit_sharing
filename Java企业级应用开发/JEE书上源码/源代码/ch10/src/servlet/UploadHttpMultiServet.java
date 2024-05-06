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
		//������Ӧ����������
		response.setContentType("text/html;charset=utf-8");
		//ȡ���������
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		String filediscription1 = request.getParameter("filediscription1");
		out.println("������ļ�1������" + filediscription1 + "<br>");
		String filediscription2 = request.getParameter("filediscription2");
		out.println("������ļ�2������" + filediscription2 + "<br>");
		//ָ���ϴ����ļ����浽��������uploadFilesĿ¼��
		File uploadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		if(!uploadFileDir.exists()){
			uploadFileDir.mkdir();
		}
		//���Part����
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			//û��ѡ���ļ������ļ���
			if (part == null || !part.getName().contains("resPat")) {
			   continue;
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
}
