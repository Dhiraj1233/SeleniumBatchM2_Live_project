package com.OpenCart.PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_Reg_PagePom extends BasePage
{
	@FindBy(name="firstname")
	private WebElement firstNametxt;
	
	@FindBy(name="lastname")
	private WebElement lastNametxt;
	
	@FindBy(name="email")
	private WebElement mailtxt;
	
	@FindBy(name="telephone")
	private WebElement phonetxt;
	
	@FindBy(name="password")
	private WebElement psw;
	
	@FindBy(name="confirm")
	private WebElement cnfpsw;
	
	@FindBy(name="agree")
	private WebElement Privacy_Policy;
	
	@FindBy(xpath ="//input[@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement verifyTxt; 
	
	public Account_Reg_PagePom(WebDriver driver)
	{
		super(driver);
	}
	public WebElement enterFn()
	{
		return firstNametxt;
	}
	public WebElement enterLn()
	{
		return lastNametxt;
	}
	public WebElement enterMail()
	{
		return mailtxt;
	}
	public WebElement phone()
	{
		return phonetxt;
	}
	public WebElement psw()
	{
		return psw;
	}
	public WebElement cnfpsw()
	{
		return cnfpsw;
	}
	public WebElement PrivacyCheckBox()
	{
		return Privacy_Policy;
	}
	public WebElement continueBtn()
	{
		return continueBtn;
	}
	public WebElement confirmationMsg()
	{
		return verifyTxt;
	}
	
	
}