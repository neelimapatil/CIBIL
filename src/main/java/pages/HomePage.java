package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

import utils.Config;
import utils.Results;

public class HomePage extends TestBase {
	
	//WebDriver driver;
	
	public HomePage(){
		 PageFactory.initElements(driver, this);
		 }
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'LOGOUT')]") 
	private WebElement lnk_logout;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Financial Analysis')]/parent::div") 
	private WebElement lnk_FinAnalysis;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Financial Analysis')]/following-sibling::div") 
	private WebElement lnk_FinAnalysis_Sibling;
	@FindBy(how = How.XPATH, using = "//*[@id='_easyui_tree_1']//child::span[1]") 
	private WebElement lnk_Company;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Manage Company')]") 
	private WebElement lnk_ManageCompany;
	
	public void userIsOnHomePage() {
		Assert.assertEquals(true, lnk_logout.isDisplayed());
		System.out.println("User is on home page");
	}
	public void logout()
	{
		lnk_logout.click();
	}
	public void ClickonFinAnaLink() throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		try
		{
			String strVar = lnk_FinAnalysis.getAttribute("class");
				if (strVar.contains("selected"))
			{
				;
			}	
			else
			{
				lnk_FinAnalysis_Sibling.click();
			}
			Config.strOp= "Status:=PASS,Method:=ClickonFinAnaLink,Parmeters:=,Note:Able to click on financial analysis link";
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public void ClickonCompanyLink() throws IOException
	{
		try
		{
	    	String strVar = lnk_Company.getAttribute("class");
	    	if (strVar.contains("expanded"))
	    	{
	    		;
	    	}	
	    	else
	    	{
	    		lnk_Company.click();
	    	}
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public void ClickonManageCompanyLink() throws IOException
	{
		try
		{
			lnk_ManageCompany.click();
			Config.strOp= "Status:=PASS,Method:=ClickonManageCompanyLink,Parmeters:=,Note:Able to click on manage company link";
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

}
