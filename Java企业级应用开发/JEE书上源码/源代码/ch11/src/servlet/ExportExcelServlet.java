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
		//获得要导出的商品信息
		ArrayList<Goods> allGoods = GetAllGoods.getAllGoods();
		//生成的Excel在服务器的uploadFiles目录中，以便下载文件
		File downLoadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		if(!downLoadFileDir.exists()){
			downLoadFileDir.mkdir();
		}
		//生成日期字符串，定义Excel文件名
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		String fileName = sdf.format(date)+".xls";
		WriteExcelFile.writeExcel(allGoods, downLoadFileDir + File.separator + fileName);
		//将生成的Excel文件从服务器下载
		FileInputStream in = null; // 输入流
		ServletOutputStream out = null; // 输出流
		try {
			// 设置下载文件使用的报头
			response.setHeader("Content-Type", "application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			// 读入文件
			in = new FileInputStream(downLoadFileDir + File.separator + fileName);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
