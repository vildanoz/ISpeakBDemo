package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import util.Constants;
import util.ElementUtil;
import util.JavaScriptUtil;

public class MainPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	public MainPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	By duration = By.xpath("//span[@id='select2-class_duration-container']");
	By list = By.className("select2-results__option");
	By subscribed=By.id("select2-package_length-container");
	By weeklyClass = By.xpath("//span[@id='select2-per_week_class_number-container']");
	By program=By.xpath("//span[@id='select2-course_program-container']");
	
	public String getPageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE_STRING);
		
		
	}
	public String duration() {
		JavaScriptUtil.scrollDownSpecific(driver);
		elementUtil.waitForElementPresentBy(duration);
		elementUtil.doClick(duration);
		return elementUtil.selectSingleValue(driver, list, "60");
		
	}
	public String subscribed() {
		elementUtil.waitForElementPresentBy(subscribed);
		elementUtil.doClick(subscribed);
		return elementUtil.selectSingleValue(driver,list , "2 weeks");
	}
	public String weeklyClass() {
		elementUtil.waitForElementPresentBy(weeklyClass);
		elementUtil.doClick(weeklyClass);
		return elementUtil.selectSingleValue(driver, list, "2 Classes");
	}
	public String programs() {
		elementUtil.waitForElementPresentBy(program);
		elementUtil.doClick(program);
		return elementUtil.selectSingleValue(driver, list, "Conversational English");
	}
	
}
