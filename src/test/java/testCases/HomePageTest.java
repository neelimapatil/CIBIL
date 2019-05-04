package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();   //it will call base/super class constructor(TestBase class)
		}
		
	@BeforeTest
	public void setupBeforeTest()
	{
		Initialization(); //create new driver instance and launch url
		loginPage = getPageObjectManager().getLoginPage();
		loginPage.doUserLoginByRole("dummyfm","passw0rd","cfo");
		homePage = getPageObjectManager().getHomePage();
		System.out.println("executed from homepagetest");
	}
@Test(priority=1)
	public void user_clicks_on_Financial_Analysis_link() throws IOException, InterruptedException {
		homePage.ClickonFinAnaLink();
		homePage.ClickonCompanyLink();
		homePage.ClickonManageCompanyLink();
	}

}
