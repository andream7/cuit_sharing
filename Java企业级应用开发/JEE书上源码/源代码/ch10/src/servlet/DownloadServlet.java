package servlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.MyUtil;
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Ҫ���ص��ļ�·��
		File downLoadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		String aFileName = null; // Ҫ���ص��ļ���
		FileInputStream in = null; // ������
		ServletOutputStream out = null; // �����
		try {
			aFileName = request.getParameter("resPath");
			// ���������ļ�ʹ�õı�ͷ
			response.setHeader("Content-Type", "application/x-msdownload");
			// MyUtil.toUTF8String(aFileName)������ص��ļ����������ַ�����
			response.setHeader("Content-Disposition", "attachment; filename=" + MyUtil.toUTF8String(aFileName));
			// �����ļ�
			in = new FileInputStream(downLoadFileDir + File.separator + aFileName);
			// �õ���Ӧ������������������ͻ����������������
			out = response.getOutputStream();
			out.flush();
			int aRead = 0;
			byte b[] = new byte[1024];
			while ((aRead = in.read(b)) != -1 & in != null) {
				out.write(b, 0, aRead);
			}
			out.flush();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
