package com.OpenCart.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesGeneric 
{
	public String getData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		Properties pro= new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
}
