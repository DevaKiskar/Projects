package datadriventest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Sprint2 {
	// Get total number of rows by getLastRowNum() method from sheet...
	public static int getRow(String xlfile, String xlsheet) throws IOException {
		FileInputStream file = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(xlsheet);
		int tot_Rows = sheet.getLastRowNum();
		wb.close();
		file.close();
		return tot_Rows;
	}

	// Get total number of Cells by getLastCellNum() method from row...
	public static int getCell(String xlfile, String xlsheet, int RowNum) throws IOException {
		FileInputStream file = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(xlsheet);
		XSSFRow row = sheet.getRow(RowNum);
		int tot_cells = row.getLastCellNum();
		wb.close();
		file.close();
		return tot_cells
				;
	}

	// Get CellData by getCellValue() method from cell...
	public static String getCellData(String xlfile, String xlsheet, int RowNum, int CellNum) throws IOException {
		FileInputStream file = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(xlsheet);
		XSSFRow row = sheet.getRow(RowNum);
		XSSFCell cell = row.getCell(CellNum);

		String data;
		try {
			// data=cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
			// return data;
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		file.close();
		return data;
	}

	public static void setcellvalue(String xlfile, String xlsheet, int RowNum, int CellNum, String celldata)
			throws IOException {
		FileInputStream file = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(xlsheet);
		XSSFRow row = sheet.getRow(RowNum);
		XSSFCell cell = row.createCell(CellNum);
		cell.setCellValue(celldata);

		// write a value into cell using OutputStream...
		FileOutputStream fileoutput = new FileOutputStream(xlfile);
		wb.write(fileoutput);
		wb.close();
		fileoutput.close();
		file.close();
	}
}
