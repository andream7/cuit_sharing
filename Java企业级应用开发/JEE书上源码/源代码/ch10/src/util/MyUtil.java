package util;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.Part;
public class MyUtil {
	/**
	 * �����ļ����ַ�����ת������
	 */
	public static String toUTF8String(String str){
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		for(int i = 0; i < len; i++){
			//ȡ���ַ��е�ÿ���ַ�
			char c = str.charAt(i);
			//Unicode��ֵ��0-255֮�䣬��������
			if(c >= 0 && c <= 255){
				sb.append(c);
			}else{//ת��UTF-8����
				byte b[];
				try {
					b = Character.toString(c).getBytes("UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					b = null;
				}
				//ת��Ϊ%HH���ַ�����ʽ
				for(int j = 0; j < b.length; j ++){
					int k = b[j];
					if(k < 0){
						k &= 255;
					}
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
	/**
	 * ��Part�л��ԭʼ�ļ���
	 */
	public static String getFileName(Part part){
		if(part == null)
			return null;
		//fileName��ʽΪ��form-data; name="resPath"; filename="20140920_110531.jpg"
		String fileName = part.getHeader("content-disposition");
		//û��ѡ���ļ�
		if(fileName.lastIndexOf("=") + 2 == fileName.length() - 1)
			return null;
		return fileName.substring(fileName.lastIndexOf("=") + 2, fileName.length() - 1);
	}
	
}
