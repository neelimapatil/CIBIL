package managers;

import org.openqa.selenium.WebDriver;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCompanyPage;

	public class PageObjectManager extends TestBase{

		private HomePage objHomePage;
		private LoginPage objLoginPage;
		private ManageCompanyPage companyPage;
	//	private ManageCompanyPage objManageCompanyPage;

		public HomePage getHomePage(){

			return (objHomePage == null) ? objHomePage = new HomePage() : objHomePage;
		}
		public LoginPage getLoginPage(){

			return (objLoginPage == null) ? objLoginPage = new LoginPage() : objLoginPage;
		}
	public ManageCompanyPage getManageCompanyPage(){

			return (companyPage == null) ? companyPage = new ManageCompanyPage() : companyPage;
		}
		}

