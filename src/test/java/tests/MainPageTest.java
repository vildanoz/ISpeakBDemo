package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import pages.MainPage;
import util.ElementUtil;

public class MainPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	MainPage mainPage;
	ElementUtil elementUtil;
	
	@BeforeMethod
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		mainPage=new MainPage(driver);
		
	}
	@Test(priority=1, enabled=true, description="flexible package")
	public void flexiblePackage() {
		Assert.assertEquals(mainPage.duration(), "60");
		Assert.assertEquals(mainPage.subscribed(), "2 weeks");
		Assert.assertEquals(mainPage.weeklyClass(),"2 Classes");
		Assert.assertEquals(mainPage.programs(),"Conversational English");
	}
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}
