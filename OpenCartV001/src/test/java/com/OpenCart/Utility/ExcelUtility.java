package com.OpenCart.Utility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;
public class ExcelUtility
{	
	FileOutputStream fos;
	FileInputStream fis;
	XSSFWorkbook book;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String path = null;
	ExcelUtility(String path)
	{
		this.path=path;
	}
	//count the row 
	public int getRowCount(String sheetName) throws IOException
	{
		fis= new FileInputStream(path);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		book.close();
		fis.close();
		return rowCount;
	}
	//count the cols
	public  int getCellCount(String sheetName,int rowNum) throws IOException
	{
		fis = new FileInputStream(path);
		book=new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		book.close();
		fis.close();
		return cellCount;
	}
	//read the data from cell
	public String getCellData(String sheetName,int rowNum,int colNum) throws IOException
	{
		fis = new FileInputStream(path);
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		String data = cell.getStringCellValue();
		book.close();
		fis.close();
		return data;
	}
	//write the data inside cell
	public void setCellData(String sheetName,int rowNum,int colNum,String data) throws IOException
	{
		fis = new FileInputStream(path);
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet(sheetName);
		if(sheet.getRow(rowNum)==null);
		{
			row=sheet.createRow(rowNum);
		}
		if (row.createCell(colNum) == null) 
		{	
			row.createCell(colNum);
		}
		cell.setCellValue(data);
		fos=new FileOutputStream(path);
		book.write(fos);
		book.close();
		fis.close();
		fos.close();
	}

}
