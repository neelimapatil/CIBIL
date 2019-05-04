package testCases;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCompanyPage;

public class ManageCompanyPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ManageCompanyPage companyPage;

	public ManageCompanyPageTest() {
		super();   //it will call base/super class constructor(TestBase class)
		}
		
	@BeforeTest
	public void setupBeforeTest() throws Exception, InterruptedException
	{
		Initialization(); //create new driver instance and launch url
		loginPage = getPageObjectManager().getLoginPage();
		loginPage.doUserLoginByRole("dummyfm","passw0rd","cfo");
		homePage = getPageObjectManager().getHomePage();
		homePage.ClickonFinAnaLink();
		homePage.ClickonCompanyLink();
		homePage.ClickonManageCompanyLink();
		companyPage = getPageObjectManager().getManageCompanyPage();
		
		System.out.println("executed from managecompanypagetest");
	}

@Test(priority=1)
public void createNewCompany(ITestContext context) throws Exception
{
	//Thread.sleep(4000);
	companyPage.ClickonNewButton();
	companyPage.EnterComName("Tester609");
	String Company_Name="Tester609";
	context.setAttribute("CompanyName", Company_Name);
	companyPage.SelectComType("IT");
	companyPage.SelectCComSubType("Service");
	companyPage.EnterAddress("Nageshwar society");
	companyPage.EnterPhone("2043001223");
	companyPage.EnterEmail("patilneelima@gmail.com");
	companyPage.EnterPan("ABHGF7654K");
	companyPage.EnterTin("ABHGF7654H");
	companyPage.EnterMobile("9881176544");
	companyPage.EnterWebsite("testing.com");
	companyPage.SelectCountry("INDIA");
	companyPage.SelectState("MAHARASHTRA");
	companyPage.SelectCity("PUNE");
	companyPage.EnterTotalEmp("76");
	companyPage.ClickOnSaveButton();
}
@Test(priority=2)
public void editCompany(ITestContext context) throws Exception
{
	Thread.sleep(6000);
	System.out.println(context.getAttribute("CompanyName"));
	companyPage.ClickOnEditButton();
	companyPage.EnterEmail("neelima@yahoo.com");
	companyPage.ClickOnSaveButton();
}
}
