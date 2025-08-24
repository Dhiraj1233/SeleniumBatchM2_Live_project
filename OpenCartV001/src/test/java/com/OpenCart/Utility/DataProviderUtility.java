package com.OpenCart.Utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtility 
{
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		String path="./testData/OpenCar_Login.xlsx";//taking xl file from testData
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for Xlutility
		int totalRows = xlutil.getRowCount("Sheet1");
		int totalCols = xlutil.getCellCount("Sheet1",1);
		String loginData[][]=new String[totalRows+1][totalCols];//3+1//3
		for (int r = 1; r <=totalRows; r++) //1
		{
			for (int c = 0; c<totalCols; c++) 
			{
				loginData[r-1][c]=xlutil.getCellData("Sheet1", r ,c);	
			}
		}
		return loginData;
	}
}

