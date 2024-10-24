package com.Utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel file Utility class is used to read the data from excel
 * and also to write or create the data to the excel file
 * 
 * @author PraneethReddy
 *
 */
public class ExcelUtility {
	private FileInputStream file;
	private FileOutputStream fileoutput;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	public int noOfRows;
	public int noOfCells;
	PropertyFileUtiltity property = new PropertyFileUtiltity();

	/**
	 * Constructor to intialize the Excel file and to load workbook
	 */
	public ExcelUtility() {
		try {
			file = new FileInputStream(property.getExcelPath());
			workbook = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retriving the last row number of sheet
	 * 
	 * @param sheetName
	 * @return noOfRows
	 */
	public int getLastRowNumber(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int noOfRows = sheet.getLastRowNum();
		return noOfRows;
	}

	/**
	 * Getting the last cell number of a row
	 * 
	 * @param sheetName
	 * @param Rowindex
	 * @return noOfCells
	 */
	public int getLastCellNumber(String sheetName, int Rowindex) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(Rowindex);
		int noOfCells = row.getLastCellNum();
		return noOfCells;
	}

	/**
	 * Reading the data from Excel sheet
	 * 
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return data
	 */
	public String getData(String sheetName, int rowIndex, int cellIndex) {
		try {
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		row = sheet.getRow(rowIndex);
		cell = row.getCell(cellIndex);
		
		DataFormatter format=new DataFormatter();
		//format.formatCellValue(cell);
		String data = format.formatCellValue(cell);

		return data;
	}

	/**
	 * Writing the data to excel sheet
	 * 
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @param data
	 * @throws IOException
	 */
	public void setData(String sheetName, int rowIndex, int cellIndex, String data) throws IOException {
		sheet = workbook.getSheet(sheetName);
		row = sheet.createRow(rowIndex);
		cell = row.createCell(cellIndex);
		cell.setCellValue(data);
	}

	/**
	 * Output stream used to write the data to excel
	 * 
	 * @param destExcelFile
	 * @throws IOException
	 */
	public void Excelwrite(String destExcelFile) throws IOException {
		fileoutput = new FileOutputStream(destExcelFile);
		workbook.write(fileoutput);

	}
}
