package pomClasses;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignUPPopup {

	
	@FindBy(xpath = "(//a[text()='Terms'])[2]")
	private WebElement Terms;
	
	@FindBy(xpath = "(//a[text()='Privacy Policy'])[2]")
	private WebElement PrivacyPolicy;
	
	@FindBy(xpath = "//a[text()='Cookies Policy']")
	private WebElement CookiesPolicy;
	
	public SignUPPopup(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	//methods - public - WebElements action
	
	public void clickOnTerms() {
		Terms.click();
	}
	
	public void clickOnPrivacyPolicy() {
		PrivacyPolicy.click();
	}
	
	public void clickOnCookiesPolicy() {
		CookiesPolicy.click();
	}
}	