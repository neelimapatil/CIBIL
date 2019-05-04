package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import dataProvider.JsonDataReader;
import managers.PageObjectManager;
import pages.HomePage;
import pages.LoginPage;
import testDataTypes.Users;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
//	PageObjectManager pageObjectManager;
	//TestBase objTestBase;
	public LoginPageTest() {
		super();   //it will call base/super class constructor(TestBase class)
		}
		
	@BeforeTest
	public void setupBeforeTest()
	{
		Initialization(); //create new driver instance and launch url
		loginPage = getPageObjectManager().getLoginPage();
		homePage = getPageObjectManager().getHomePage();
	}

	@Test
	//@Parameters({"username","password","role"})
	public void Tata() {
		loginPage.doUserLoginByRole("dummyfm","passw0rd","cfo");
		homePage.userIsOnHomePage();
	}

	
	public void loginMultipleUsersTest() throws IOException {
		Object objUsers1=JsonDataReader.getJsonData("src/test/resources/testData/Users.json","Users");
		Users[] objUsers= (Users[])objUsers1;
		int intNoofUsers=objUsers.length;
		for (int intIndex =0;intIndex<intNoofUsers;intIndex++)
		{
		String strUserName = objUsers[intIndex].username;
		String strPassword = objUsers[intIndex].password;
		String strRole = objUsers[intIndex].userrole;
		
		loginPage.doUserLoginByRole(strUserName,strPassword,strRole);
		System.out.println("intIndex:"+intIndex);
		if(objUsers[intIndex].status.equalsIgnoreCase("valid"))
		{
			homePage.userIsOnHomePage();	
			homePage.logout();
		}
		else
		{
			loginPage.verifyLoginErrorMessage(objUsers[intIndex].errormessage);
		}
		}
	}
	@AfterTest
	public void tearDown()
	{ 
		driver.quit();
	}
}
