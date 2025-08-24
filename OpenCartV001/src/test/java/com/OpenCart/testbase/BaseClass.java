package com.OpenCart.testbase;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.OpenCart.PageObjectModel.Account_Reg_PagePom;
import com.OpenCart.PageObjectModel.HomePagePom;
import com.OpenCart.PageObjectModel.LoginPagePom;
import com.OpenCart.PageObjectModel.MyAccountPagePom;
import com.OpenCart.Utility.PropertiesGeneric;
public class BaseClass 
{
	public Account_Reg_PagePom regPage;
//	public MyAccountPagePom myacc;
//	public LoginPagePom lp; 
//	public HomePagePom hp;
	public PropertiesGeneric prop; 
	public static WebDriver driver;
	@Parameters({"browser","Os"})
	@BeforeClass(groups = {"Sanity","Regression","DataDriven","Master"})
	public void setUp(String browser,String Os) throws IOException
	{
		switch (browser.toLowerCase()) 
		{
		case "chrome":driver=new ChromeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:System.out.println("invalid browser");return;
		}
		regPage= new Account_Reg_PagePom(driver);
//		myacc= new MyAccountPagePom(driver);
//		lp= new LoginPagePom(driver);
//		hp= new HomePagePom(driver);
		prop=new PropertiesGeneric();
		driver.manage().window().maximize();
		driver.get(prop.getData("pageUrl"));	
	}
	@AfterClass(groups = {"Sanity","Regression","DataDriven",})
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
