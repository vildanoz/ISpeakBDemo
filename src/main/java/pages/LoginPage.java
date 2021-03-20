package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.yaml.snakeyaml.scanner.Constant;

import base.BasePage;
import util.Constants;
import util.ElementUtil;
import util.JavaScriptUtil;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	By clickLogin=By.id("cmdSiginLink");
	By email=By.id("_email");
	By password= By.xpath("//input[@id='_password']");
	By loginbtn=By.id("cmdSignin");
	By clickSignin=By.id("signin");
	
	
	public String getPageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE_STRING);
		
		
	}
	
	public void doLogin(String userName, String pass) {
		elementUtil.doClick(clickLogin);
		elementUtil.waitForElementPresentBy(clickSignin);
		elementUtil.doClick(clickSignin);
		elementUtil.isElementEnabled(email);
		elementUtil.doSendKeys(email, userName);
		elementUtil.waitForElementPresentBy(password);
		elementUtil.doSendKeys(password, pass);
		elementUtil.waitForElementPresentBy(loginbtn);
		elementUtil.doClick(loginbtn);
		
		
		
	}

}
