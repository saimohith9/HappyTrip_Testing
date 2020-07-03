package com.sa.happytrip.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DataProvider {
	
	private static Sheet WSheet;
	private static Workbook WBook;
	private static Row row;
	
	@org.testng.annotations.DataProvider(name = "adminLogin")
	public Object[][] loginData() {
		String fileName = "D:\\work space\\testing\\happytripproject\\logs\\TestData.xlsx";
		 String sheetName = "Login";
		return getExceldata(fileName,sheetName);
	}
	
	@org.testng.annotations.DataProvider(name = "validFields")
	public Object[][] fieldsData() {
		String fileName = "D:\\work space\\testing\\happytripproject\\logs\\TestData.xlsx";
		 String sheetName = "validFields";
		return getExceldata(fileName,sheetName);
	}
	@org.testng.annotations.DataProvider(name = "Distance")
	public Object[][] distancedata() {
		String fileName = "D:\\work space\\testing\\happytripproject\\logs\\TestData.xlsx";
		 String sheetName = "Distance";
		return getExceldata(fileName,sheetName);
	}
	@org.testng.annotations.DataProvider(name = "depDates")
	public Object[][] depdatesdata() {
		String fileName = "D:\\work space\\testing\\happytripproject\\logs\\TestData.xlsx";
		 String sheetName = "depDates";
		return getExceldata(fileName,sheetName);
	}
	@org.testng.annotations.DataProvider(name = "arrdeptimes")
	public Object[][] arrdeptimes() {
		String fileName = "D:\\work space\\testing\\happytripproject\\logs\\TestData.xlsx";
		 String sheetName = "arrdeptimes";
		return getExceldata(fileName,sheetName);
	}
	@org.testng.annotations.DataProvider(name = "Cost")
	public Object[][] costData() {
		String fileName = "D:\\work space\\testing\\happytripproject\\logs\\TestData.xlsx";
		 String sheetName = "Cost";
		return getExceldata(fileName,sheetName);
	}
	@org.testng.annotations.DataProvider(name = "times")
	public Object[][] timesData() {
		String fileName = "D:\\work space\\testing\\happytripproject\\logs\\TestData.xlsx";
		 String sheetName = "times";
		return getExceldata(fileName,sheetName);
	}
	
	private Object[][] getExceldata(String fileName, String sheetName) {
	Object[][] excelData = null;
					try {
					FileInputStream	excelFile = new FileInputStream(new File(fileName));
						WBook =new XSSFWorkbook(excelFile);
						} catch (FileNotFoundException e1) {
						System.out.println("cannot read excel");						
						e1.printStackTrace();
					} catch (IOException e) {
						System.out.println("cannot read excel");
						e.printStackTrace();
					}		
					WSheet = WBook.getSheet(sheetName);
					row = WSheet.getRow(0);
					int startRow = 0;
					int startColoum = 0;
					int totalRows = WSheet.getLastRowNum()-1;
					int totalColoumns = WSheet.getRow(0).getLastCellNum();
					excelData = new String[totalRows][totalColoumns];
					for(int i = startRow; i < totalRows-1;i++) {
						Row row = WSheet.getRow(i+1);
						DataFormatter data = new DataFormatter();
						for(int j =startColoum;j < totalColoumns;j++) {
							Cell cell = row.getCell(j);
							excelData[i][j]= data.formatCellValue(cell);
							System.out.println(excelData[i][j]);
						}
	}
	return excelData;
	}
}

