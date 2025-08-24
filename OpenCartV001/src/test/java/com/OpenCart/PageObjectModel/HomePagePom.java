package com.OpenCart.PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePom extends BasePage
{
	@FindBy(xpath="//span[text()='My Account']")
	private	WebElement myAccount;
	@FindBy(xpath = "//a[text()='Register']")
	private	WebElement registerBtn;
	@FindBy(xpath="//a[text()='Login']")
	private	WebElement loginBtn;
	
	public HomePagePom(WebDriver driver)
	{
		super(driver);
	}
	public void myAccount()
	{
		myAccount.click();
	}
	public void registerClickBtn()
	{
		registerBtn.click();
	}
	public void loginClickBtn()
	{
		loginBtn.click();
	}
}
