package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import dataProvider.JsonDataReader;
import managers.PageObjectManager;
import pages.HomePage;
import pages.LoginPage;
import testDataTypes.Users;
import utils.TestUtil;
import utils.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	static Properties properties;
	private final String propertyFilePath= "src//test//resources//Properties//Config.properties";
	LoginPage loginpage;
	HomePage objHomePage;
	public PageObjectManager pageObjectManager;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	
	//reading config properties
	public TestBase() {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}		
			
	}
	public void Initialization()
		{
		String browserName = properties.getProperty("browser");
		if(browserName.equals("chrome"))
			{
			System.setProperty("webdriver.chrome.driver","E:/selenium/Workspace/WS_TestNG/CIBIL/chromedriver.exe");
			driver=new ChromeDriver();
			}
		if(browserName.equals("firefox"))
			{
			System.setProperty("webdriver.chrome.driver","chromedriver_win32_worksforversion73");
			driver=new FirefoxDriver();
			}
		if(browserName.equals("IE"))
			{
			System.setProperty("webdriver.chrome.driver","chromedriver_win32_worksforversion73");
			driver=new InternetExplorerDriver();
			}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
		pageObjectManager = new PageObjectManager();
	//	loginpage = getPageObjectManager().getLoginPage();
	//	objHomePage = getPageObjectManager().getHomePage();
		}

	/*@BeforeTest
	public void setupBeforeTest()
	{
		//Initialize objects of managers
		pageObjectManager = new PageObjectManager();
		Initialization(); //create new driver instance and launch url
	}
	@AfterTest
	public void tearDown()
	{ 
		driver.quit();
	}
	@Test
	@Parameters({"username","password","role"})
	public void loginForSinglesUser(String strUserName,String strPassword,String strRole) {
		loginpage.doUserLoginByRole(strUserName,strPassword,strRole);
	}*/
	public void loginMultipleUsersTest1() throws IOException {
		Object objUsers1=JsonDataReader.getJsonData("src/test/resources/testData/Users.json","Users");
		Users[] objUsers= (Users[])objUsers1;
		int intNoofUsers=objUsers.length;
		for (int intIndex =0;intIndex<intNoofUsers;intIndex++)
		{
		String strUserName = objUsers[intIndex].username;
		String strPassword = objUsers[intIndex].password;
		String strRole = objUsers[intIndex].userrole;
		
		loginpage.doUserLoginByRole(strUserName,strPassword,strRole);
		if(objUsers[intIndex].status.equalsIgnoreCase("valid"))
		{
			objHomePage.userIsOnHomePage();	
		}
		else
		{
			loginpage.verifyLoginErrorMessage(objUsers[intIndex].errormessage);
		}
		}
	}
//returns manager object
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	}
