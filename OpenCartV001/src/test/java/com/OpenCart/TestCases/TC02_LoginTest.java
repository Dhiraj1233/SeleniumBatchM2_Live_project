package com.OpenCart.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCart.PageObjectModel.HomePagePom;
import com.OpenCart.PageObjectModel.LoginPagePom;
import com.OpenCart.PageObjectModel.MyAccountPagePom;
import com.OpenCart.testbase.BaseClass;

public class TC02_LoginTest extends BaseClass
{
	@Test(groups = {"Regression","Master"})
	public void LoginTc() throws IOException
	{
		try {
		//Homepage
		HomePagePom hp= new HomePagePom(driver);
		hp.myAccount();
		hp.loginClickBtn();

		//Loginpage
		LoginPagePom lp = new LoginPagePom(driver);
		lp.enterEmail().sendKeys(prop.getData("email"));
		lp.enterPass().sendKeys(prop.getData("password"));
		lp.clickLogin();

		//My account page
		MyAccountPagePom myacc= new MyAccountPagePom(driver);
		boolean targetPage = myacc.isMyAccPageExist();

		Assert.assertTrue(targetPage);
		myacc.logoutBtn();
//		Assert.assertEquals(targetPage,true);
		}catch(Exception e)
		{
			Assert.fail();
		}
	}


}


