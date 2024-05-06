package util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import entity.Goods;
public class WriteExcelFile {
	private static HSSFWorkbook wb;
	public static void writeExcel(ArrayList<Goods> result, String path) {
		if (result == null) {
			return;
		}
		wb = new HSSFWorkbook();
		//Excel文件sheet1表
		HSSFSheet sheet = wb.createSheet("sheet1");
		//第一行表头
		HSSFRow row0 = sheet.createRow(0);
		row0.createCell(0).setCellValue("id");
		row0.createCell(1).setCellValue("gname");
		row0.createCell(2).setCellValue("gprice");
		//将ArrayList中数据写到每一行
		for (int i = 1; i < result.size(); i++) {
			HSSFRow row = sheet.createRow(i);
			if (result.get(i) != null) {
					HSSFCell cell0 = row.createCell(0);
					cell0.setCellValue(result.get(i).getId());
					HSSFCell cell1 = row.createCell(1);
					cell1.setCellValue(result.get(i).getGname());
					HSSFCell cell2 = row.createCell(2);
					cell2.setCellValue(result.get(i).getGprice());
			}
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		// Excel文件生成后存储的位置。
		File file = new File(path);
		OutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(content);
			os.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
