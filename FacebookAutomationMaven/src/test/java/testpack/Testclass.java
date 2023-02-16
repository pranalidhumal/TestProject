package testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pomClasses.ForgotPasswordPage;
import pomClasses.LoginOrSignupPage;

public class Testclass {



	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aksha\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driverTest = new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		driverTest.get("https://www.facebook.com/");
		
		LoginOrSignupPage loginOrSignUpPage = new LoginOrSignupPage(driverTest);
		//String user to user
		loginOrSignUpPage.sendUserName("Pranali");
		loginOrSignUpPage.sendPassword("7675");
		//loginOrSignUpPage.clickOnloginButton();
		loginOrSignUpPage.clickOnForgotPasswordLink();
		
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverTest);
		forgotPasswordPage.getTextMessage();
		forgotPasswordPage.sendEmailOrPhoneNumber();
		forgotPasswordPage.clickOnSearchButton();
		
		//Alert popup
		driverTest.switchTo().alert().accept();
		driverTest.switchTo().alert().dismiss();

	}
}
		
