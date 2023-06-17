package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static Object[][] getTestDataFromExcel(String fileName, String sheetName) {

		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName;
		File file = new File(filePath);
		FileInputStream fis;
		XSSFWorkbook workbook = null;
		Object[][] data = null;

		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet(sheetName);
			int lastRowNum = sheet.getLastRowNum();
			short lastCellNum = sheet.getRow(0).getLastCellNum();
			data = new Object[lastRowNum][lastCellNum];
			int rowCount = 0;
			for (int i = 1; i <= lastRowNum; i++) {
				int colCount = 0;
				for (int j = 0; j < lastCellNum; j++) {
					data[rowCount][colCount] = sheet.getRow(i).getCell(j).getStringCellValue();
					colCount++;
				}
				rowCount++;
			}
			fis.close();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static void main(String[] args) {

		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + "LoginTestData.xlsx";
		File file = new File(filePath);
		FileInputStream fis;
		XSSFWorkbook workbook = null;
		Object[][] data = null;

		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet("InvalidData");
			int lastRowNum = sheet.getLastRowNum();
			System.out.println("Last row: " + lastRowNum);
			short lastCellNum = sheet.getRow(0).getLastCellNum();
			System.out.println("Last col: " + lastCellNum);
			data = new Object[lastRowNum][lastCellNum];
			int rowCount = 0;
			for (int i = 1; i <= lastRowNum; i++) {
				int colCount = 0;
				for (int j = 0; j < lastCellNum; j++) {
					String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
					data[rowCount][colCount] = cellValue;
					colCount++;
				}
				rowCount++;
			}

			for (Object[] obj : data) {
				System.out.println(Arrays.toString(obj));
			}

			fis.close();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
