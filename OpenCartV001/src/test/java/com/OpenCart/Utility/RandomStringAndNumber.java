package com.OpenCart.Utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringAndNumber 
{
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;	
	}
	public String randomAlphaNumeric()
	{
		String generatedAlpha = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return (generatedAlpha+""+generatedNumber);
	}
}
