package com.OpenCart.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCart.PageObjectModel.Account_Reg_PagePom;
import com.OpenCart.PageObjectModel.HomePagePom;
import com.OpenCart.Utility.RandomStringAndNumber;
import com.OpenCart.testbase.BaseClass;

public class TC01_Account_Registration extends BaseClass
{
	@Test(groups = {"Sanity"})
	public void accountRegistration()
	{
		HomePagePom hp = new HomePagePom(driver);
		hp.myAccount();
		hp.registerClickBtn();
		
		RandomStringAndNumber generated= new RandomStringAndNumber();
		
		regPage.enterFn().sendKeys(generated.randomString());;
		regPage.enterLn().sendKeys(generated.randomString()+"don");;
		regPage.enterMail().sendKeys(generated.randomString()+"@gmail.com");
		regPage.phone().sendKeys(generated.randomNumber());
		regPage.psw().sendKeys("Dhiraj@123456");;
		regPage.cnfpsw().sendKeys("Dhiraj@123456");;
		regPage.PrivacyCheckBox().click();
		regPage.continueBtn().click();
		
		String actualRes = regPage.confirmationMsg().getText();
		String  expectedRes= "Your Account Has Been Created!";
		if (actualRes.contains("Created"))
		{
			Assert.assertEquals(actualRes,expectedRes);
		}
		else 
		{
			System.out.println("invalid ");
		}
	}
}
