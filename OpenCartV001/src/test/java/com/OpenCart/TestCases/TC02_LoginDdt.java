package com.OpenCart.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCart.PageObjectModel.HomePagePom;
import com.OpenCart.PageObjectModel.LoginPagePom;
import com.OpenCart.PageObjectModel.MyAccountPagePom;
import com.OpenCart.Utility.DataProviderUtility;
import com.OpenCart.testbase.BaseClass;

public class TC02_LoginDdt extends BaseClass
{
	@Test( dataProvider = "LoginData",dataProviderClass = DataProviderUtility.class,groups = "DataDriven")
	public void LoginTc(String email,String pwd,String res) throws IOException
	{
		HomePagePom hp =new HomePagePom(driver);
		hp.myAccount();
		hp.loginClickBtn();

		LoginPagePom lp = new LoginPagePom(driver);
		lp.enterEmail().sendKeys(email);
		lp.enterPass().sendKeys(pwd);
		lp.clickLogin();

		MyAccountPagePom myacc = new MyAccountPagePom(driver);
		boolean targetPage = myacc.isMyAccPageExist();
		if(res.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				myacc.logoutBtn();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(res.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				myacc.logoutBtn();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
	}


}


