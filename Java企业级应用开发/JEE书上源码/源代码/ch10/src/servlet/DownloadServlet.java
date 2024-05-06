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
		// 要下载的文件路径
		File downLoadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		String aFileName = null; // 要下载的文件名
		FileInputStream in = null; // 输入流
		ServletOutputStream out = null; // 输出流
		try {
			aFileName = request.getParameter("resPath");
			// 设置下载文件使用的报头
			response.setHeader("Content-Type", "application/x-msdownload");
			// MyUtil.toUTF8String(aFileName)解决下载的文件名中中文字符乱码
			response.setHeader("Content-Disposition", "attachment; filename=" + MyUtil.toUTF8String(aFileName));
			// 读入文件
			in = new FileInputStream(downLoadFileDir + File.separator + aFileName);
			// 得到响应对象的输出流，用于向客户端输出二进制数据
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
