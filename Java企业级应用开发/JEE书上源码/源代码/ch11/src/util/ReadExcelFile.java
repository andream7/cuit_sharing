package util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import entity.Goods;
public class ReadExcelFile {
	// 总行数
	private int totalRows = 0;
	// 总条数
	private int totalCells = 0;
	// 错误信息接收器
	private String errorMsg;
	// 构造方法
	public ReadExcelFile() {
	}
	// 获取总行数
	public int getTotalRows() {
		return totalRows;
	}
	// 获取总列数
	public int getTotalCells() {
		return totalCells;
	}
	// 获取错误信息
	public String getErrorInfo() {
		return errorMsg;
	}
	/**
	 * 读EXCEL文件，获取信息集合
	 * @param fielName
	 * @return
	 */
	public List<Goods> getExcelInfo(File mFile) {
		String fileName = mFile.getName();// 获取文件名
		List<Goods> goodsList = null;
		try {
			if (!validateExcel(fileName)) {// 验证文件名是否合格
				return null;
			}
			boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
			if (isExcel2007(fileName)) {
				isExcel2003 = false;
			}
			goodsList = createExcel(mFile, isExcel2003);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	/**
	 * 根据excel里面的内容读取客户信息
	 * @param is输入流
	 * @param isExcel2003 excel是2003还是2007版本
	 * @return
	 * @throws IOException
	 */
	public List<Goods> createExcel(File mFile, boolean isExcel2003) {
		List<Goods> goodsList = null;
		try {
			Workbook wb = null;
			if (isExcel2003) {// 当excel是2003时,创建excel2003
				wb = new HSSFWorkbook(new FileInputStream(mFile));
			} else {// 当excel是2007时,创建excel2007
				wb = new XSSFWorkbook(mFile);
			}
			goodsList = readExcelValue(wb);// 读取Excel里面客户的信息
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	/**
	 * 读取Excel里面客户的信息
	 * @param wb
	 * @return
	 */
	private List<Goods> readExcelValue(Workbook wb) {
		// 得到第一个shell
		Sheet sheet = wb.getSheetAt(0);
		// 得到Excel的行数
		this.totalRows = sheet.getPhysicalNumberOfRows();
		// 得到Excel的列数(前提是有行数)
		if (totalRows > 1 && sheet.getRow(0) != null) {
			this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		List<Goods> goodsList = new ArrayList<Goods>();
		// 循环Excel行数，第一行是表头，不需要读
		for (int r = 1; r < totalRows; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			Goods goods = new Goods();
			// 循环Excel的列
			for (int c = 0; c < this.totalCells; c++) {
				Cell cell = row.getCell(c);
				if (null != cell) {
					if (c == 0) {
						goods.setGname(cell.getStringCellValue());// 商品名称
					} else if (c == 1) {
						goods.setGprice(cell.getNumericCellValue());// 商品价格
					}
				}
			}
			// 添加到list
			goodsList.add(goods);
		}
		return goodsList;
	}
	/**
	 * 验证EXCEL文件
	 * @param filePath
	 * @return
	 */
	public boolean validateExcel(String filePath) {
		if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
			errorMsg = "文件名不是excel格式";
			return false;
		}
		return true;
	}
	/**
	 * 是否是2003的excel，返回true是2003
	 * @param filePath
	 * @return
	 */  
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}
	/**
	 * 是否是2007的excel，返回true是2007
	 * @param filePath
	 * @return
	 */
	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
}
