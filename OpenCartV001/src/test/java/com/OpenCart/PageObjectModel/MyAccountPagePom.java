package com.OpenCart.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPagePom extends BasePage
{
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement msgHeading;
	
	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	private WebElement logoutButton;

	public MyAccountPagePom(WebDriver driver)
	{
		super(driver);
	}
	public boolean isMyAccPageExist()
	{
		try {
			return(msgHeading.isDisplayed());
		}catch(Exception e)
		{
			return false;
		}
	}
	public void logoutBtn()
	{
		logoutButton.click();
	}
}
