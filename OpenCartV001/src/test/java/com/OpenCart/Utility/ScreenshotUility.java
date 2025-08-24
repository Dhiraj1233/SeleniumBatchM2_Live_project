package com.OpenCart.Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.OpenCart.testbase.BaseClass;

public class ScreenshotUility extends BaseClass
{
	public static String getDefect(String Filename) throws IOException
	{
		Date d = new Date();
		String d1 = d.toString().replace(":","-");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"/OpenCartV001/screenshots"+Filename+"_"+d1;
		File perm = new File(targetFilePath);
		FileHandler.copy(temp, perm);
		return targetFilePath;
	}
}
