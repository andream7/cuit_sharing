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
	// ������
	private int totalRows = 0;
	// ������
	private int totalCells = 0;
	// ������Ϣ������
	private String errorMsg;
	// ���췽��
	public ReadExcelFile() {
	}
	// ��ȡ������
	public int getTotalRows() {
		return totalRows;
	}
	// ��ȡ������
	public int getTotalCells() {
		return totalCells;
	}
	// ��ȡ������Ϣ
	public String getErrorInfo() {
		return errorMsg;
	}
	/**
	 * ��EXCEL�ļ�����ȡ��Ϣ����
	 * @param fielName
	 * @return
	 */
	public List<Goods> getExcelInfo(File mFile) {
		String fileName = mFile.getName();// ��ȡ�ļ���
		List<Goods> goodsList = null;
		try {
			if (!validateExcel(fileName)) {// ��֤�ļ����Ƿ�ϸ�
				return null;
			}
			boolean isExcel2003 = true;// �����ļ����ж��ļ���2003�汾����2007�汾
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
	 * ����excel��������ݶ�ȡ�ͻ���Ϣ
	 * @param is������
	 * @param isExcel2003 excel��2003����2007�汾
	 * @return
	 * @throws IOException
	 */
	public List<Goods> createExcel(File mFile, boolean isExcel2003) {
		List<Goods> goodsList = null;
		try {
			Workbook wb = null;
			if (isExcel2003) {// ��excel��2003ʱ,����excel2003
				wb = new HSSFWorkbook(new FileInputStream(mFile));
			} else {// ��excel��2007ʱ,����excel2007
				wb = new XSSFWorkbook(mFile);
			}
			goodsList = readExcelValue(wb);// ��ȡExcel����ͻ�����Ϣ
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	/**
	 * ��ȡExcel����ͻ�����Ϣ
	 * @param wb
	 * @return
	 */
	private List<Goods> readExcelValue(Workbook wb) {
		// �õ���һ��shell
		Sheet sheet = wb.getSheetAt(0);
		// �õ�Excel������
		this.totalRows = sheet.getPhysicalNumberOfRows();
		// �õ�Excel������(ǰ����������)
		if (totalRows > 1 && sheet.getRow(0) != null) {
			this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		List<Goods> goodsList = new ArrayList<Goods>();
		// ѭ��Excel��������һ���Ǳ�ͷ������Ҫ��
		for (int r = 1; r < totalRows; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			Goods goods = new Goods();
			// ѭ��Excel����
			for (int c = 0; c < this.totalCells; c++) {
				Cell cell = row.getCell(c);
				if (null != cell) {
					if (c == 0) {
						goods.setGname(cell.getStringCellValue());// ��Ʒ����
					} else if (c == 1) {
						goods.setGprice(cell.getNumericCellValue());// ��Ʒ�۸�
					}
				}
			}
			// ��ӵ�list
			goodsList.add(goods);
		}
		return goodsList;
	}
	/**
	 * ��֤EXCEL�ļ�
	 * @param filePath
	 * @return
	 */
	public boolean validateExcel(String filePath) {
		if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
			errorMsg = "�ļ�������excel��ʽ";
			return false;
		}
		return true;
	}
	/**
	 * �Ƿ���2003��excel������true��2003
	 * @param filePath
	 * @return
	 */  
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}
	/**
	 * �Ƿ���2007��excel������true��2007
	 * @param filePath
	 * @return
	 */
	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
}
