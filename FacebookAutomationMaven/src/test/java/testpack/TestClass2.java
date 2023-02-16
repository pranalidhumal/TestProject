package testpack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browser.Browser;
import pomClasses.LoginOrSignupPage;
import pomClasses.SignUPPopup;
import utils.Utility;

public class TestClass2 extends Browser {
     WebDriver driver;
	private SignUPPopup signUPPopup;
	private LoginOrSignupPage loginOrSignUpPage;
	private SoftAssert softAssert;

	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		
		if(browserName.equals("Chrome")) {
		//change to setproperty
	         driver = Browser.openChromeBrowser();
	         
			}  
			if(browserName.equals("Firefox")) {
					
			         driver = Browser. openFirefoxBrowser();
			         
			} 
//		if(browserName.equals("Chrome")) {
//	
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\aksha\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
//         driver = new ChromeDriver();
//         
//		}  
//		if(browserName.equals("Firefox")) {
//			
//			System.setProperty("webdriver.gecko.driver","C:\\Users\\aksha\\Downloads\\geckodriver-v0.32.1-win32\\geckodriver.exe");
//	         driver = new FirefoxDriver();
//	         
//			} 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	//SoftAssert
	@BeforeClass
	public void createPomObjects() {
		loginOrSignUpPage = new LoginOrSignupPage(driver);
		signUPPopup = new SignUPPopup(driver);
	}
	@BeforeMethod
	public void openSignUpPage1() {
		 softAssert = new SoftAssert();
		System.out.println("Before Method");
		
		//String user = Utility.getDataFromExcel("TestData",1,0);
		loginOrSignUpPage.sendUserName(getDataFromExcel("TestData",1,0));
		
		//String pass = Utility.getDataFromExcel("TestData",1,1);
		loginOrSignUpPage.sendPassword(getDataFromExcel("TestData",1,1));
		
		driver.get("https://www.facebook.com/");
		
		//LoginOrSignupPage loginOrSignUpPage = new LoginOrSignupPage(driver);
		loginOrSignUpPage.openSignUpForm();
	}
	
	
	
	@Test
	public  void verifyTermsLink() throws InterruptedException {
		System.out.println("Test - 1");
	   SignUPPopup signUPPopup = new SignUPPopup(driver);
		 signUPPopup.clickOnTerms();
		Thread.sleep(2000);
		
		ArrayList<String>addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String actualURL= driver.getCurrentUrl();
		String actualTitle= driver.getTitle();
		
		String expectedURL = "https://www.facebook.com/legal/terms/update";
		String expectedTitle = "Facebook - log in or sign up";
		//SOFT ASSERT
		String actualText = driver.findElement(By.xpath("//div[@class='_1rf2']//h2[2]")).getText();
		String expectedText = "Terms of Service";
		
		Assert.assertEquals(actualURL,expectedURL);
		
		
		softAssert.assertEquals(actualTitle,expectedTitle);
		
		softAssert.assertEquals(actualText,expectedText);
		
	    softAssert.assertAll();
	}
	@BeforeMethod
	public void openSignUpPage() {
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		LoginOrSignupPage loginOrSignUpPage = new LoginOrSignupPage(driver);
		loginOrSignUpPage.openSignUpForm();
	}
}
