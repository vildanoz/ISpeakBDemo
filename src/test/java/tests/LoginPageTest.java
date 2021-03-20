package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;
import util.Constants;
import util.ElementUtil;

public class LoginPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	ElementUtil elementUtil;
	
	@BeforeMethod
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		loginPage=new LoginPage(driver);
		
	}
	
	@Test(priority=1,enabled=true, description="I Speak Better Main Page Title")
	public void testPageTitle() {
		String expected=loginPage.getPageTitle();
		Assert.assertEquals(Constants.LOGIN_PAGE_TITLE_STRING, expected);
	}
	@Test(priority=3, enabled=false, description="login system in I speak Better")
	public void testLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
