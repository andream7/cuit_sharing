package util;

import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class UploadDown {
	/**
	 * @discription 下载文件
	 * @param aFilePath 要下载的文件路径
	 * @param aFileName 要下载的文件名
	 * @param response 响应对象
	 */
	public static void downLoad(String aFilePath, String aFileName, HttpServletResponse response){
		FileInputStream in = null; //输入流
		ServletOutputStream out = null; //输出流
		try {
			//设置下载文件使用的报头
			response.setHeader("Content-disposition", "attachment; filename="
					+ aFileName);
			// 读入文件
			in = new FileInputStream(aFilePath + aFileName); 
			//得到响应对象的输出流，用于向客户端输出二进制数据
			out = response.getOutputStream();
			out.flush();
			int aRead = 0;
			byte b[] = new byte[1024];
			while ((aRead = in.read(b)) != -1 & in != null) {
				out.write(b,0,aRead);
			}
			out.flush();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
	}
	
}
