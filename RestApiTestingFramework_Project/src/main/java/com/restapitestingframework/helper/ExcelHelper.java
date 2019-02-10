package com.restapitestingframework.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
@author Stavan S. Kodolikar
*
*
*/
public class ExcelHelper {
	
		static Object[][] data;
		static int writerowindex=1;
	
	public static Object[][] getExcelData(String sheetName) throws IOException {

		// XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir") +
		// "\\test-input\\TestInputData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir")+"\\test-input\\TestInputData.xlsx");

		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rowindex = 0;
		int colindex = -1;
		int rowNum = sheet.getLastRowNum();
		int colNum = sheet.getRow(0).getLastCellNum();

		data = new Object[rowNum][colNum];

		Iterator<Row> rowIterator = sheet.rowIterator();

		while (rowIterator.hasNext()) {
			if (rowindex == rowNum - 1) {
				rowindex = 0;
			} else {
				rowindex++;
			}
			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {

				if (colindex == colNum - 1) {
					colindex = 0;
				} else {
					colindex++;
				}
				Cell cell = cellIterator.next();

				switch (cell.getCellTypeEnum()) {
				case STRING:
					data[rowindex][colindex] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[rowindex][colindex] = String.valueOf(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[rowindex][colindex] = String.valueOf(cell.getBooleanCellValue());
					break;
				case FORMULA:
					data[rowindex][colindex] = String.valueOf(cell.getCellFormula());
					break;
				case BLANK:
					data[rowindex][colindex] = "";
					break;

				default:
					System.out.println("");
					break;
				}

			}

		}

		return data;
	}

	
	public static void setExcelData(List<String> resultL,String sheetName) throws IOException {
		
		int colNum = resultL.size();
		
        XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir")+"\\test-output\\TestOutputData.xlsx"); 
  
        
        XSSFSheet worksheet = workbook.getSheet(sheetName);
        
   
        Row row=worksheet.createRow(writerowindex++);
			
        for (int k = 0; k < colNum; k++) {
			Cell cell=row.createCell(k);
			String s=resultL.get(k);
			cell.setCellValue(s);
			
		}


		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\test-output\\TestOutputData.xlsx");
		workbook.write(fos); 

	}
	
	
	public static void main(String[] args) throws IOException {
		HashMap<Integer,List<String>> resultHM = new HashMap<Integer, List<String>>();
		List l1=new ArrayList();
		l1.add("A");
		l1.add("B");
		l1.add("C");
		l1.add("D");
		
		List l2=new ArrayList();
		l2.add("P");
		l2.add("Q");
		l2.add("R");
		l2.add("S");
		
		resultHM.put(0, l1);
		resultHM.put(1, l2);
		
		
	}
}
