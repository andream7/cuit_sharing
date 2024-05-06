package servlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Goods;
import util.GetAllGoods;
import util.WriteExcelFile;
@WebServlet("/exportExcelServlet")
public class ExportExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���Ҫ��������Ʒ��Ϣ
		ArrayList<Goods> allGoods = GetAllGoods.getAllGoods();
		//���ɵ�Excel�ڷ�������uploadFilesĿ¼�У��Ա������ļ�
		File downLoadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		if(!downLoadFileDir.exists()){
			downLoadFileDir.mkdir();
		}
		//���������ַ���������Excel�ļ���
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		String fileName = sdf.format(date)+".xls";
		WriteExcelFile.writeExcel(allGoods, downLoadFileDir + File.separator + fileName);
		//�����ɵ�Excel�ļ��ӷ���������
		FileInputStream in = null; // ������
		ServletOutputStream out = null; // �����
		try {
			// ���������ļ�ʹ�õı�ͷ
			response.setHeader("Content-Type", "application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			// �����ļ�
			in = new FileInputStream(downLoadFileDir + File.separator + fileName);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
