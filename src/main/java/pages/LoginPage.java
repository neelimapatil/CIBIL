package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;


public class LoginPage extends TestBase {
		 
		 //page factory or OR
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement txtbx_UserName;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtbx_Password;
	@FindBy(xpath="//*[.='Login']") 
	WebElement btn_Login;
	@FindBy(xpath= "//div[@id='error']") 
	WebElement lbl_LoginError;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void doUserLoginByRole(String strUserName, String strPassword,String strRole)
	{
		try
		{
			Thread.sleep(2000);
			txtbx_UserName.clear();
			txtbx_UserName.sendKeys(strUserName);
			Thread.sleep(2000);
			txtbx_Password.clear();
			txtbx_Password.sendKeys(strPassword);
			Thread.sleep(4000);
			btn_Login.click();
					}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public void verifyLoginErrorMessage(String strErrorMessage) {
		// TODO Auto-generated method stub
		Assert.assertEquals(strErrorMessage, lbl_LoginError.getText());
	}

}
