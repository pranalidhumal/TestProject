package testpack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomClasses.LoginOrSignupPage;
import pomClasses.SignUPPopup;
import utils.Utility;

public class TestClassfacebook {

	WebDriver driver;
	private Assert softAssert;
	private Object signUPPopup;
	@BeforeClass
	public void openBrowser() {
		System.out.println("Before Class");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aksha\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         driver.manage().window().maximize();
	}
	@BeforeMethod
	public void openSignUpPage() {
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		LoginOrSignupPage loginOrSignUpPage = new LoginOrSignupPage(driver);
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
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(actualTitle,expectedTitle);
		
		soft.assertEquals(actualText,expectedText);
		
	    soft.assertAll();
	}


		
//		if(actualURL.equals(expectedURL)&& actualTitle.equals(expectedTitle))
//		{
//			System.out.println("PASSED");
//		}
//		else
//		{
//			System.out.println("FAILED"); 
//		}
	
	@Test
	public void verifyPrivacyPolicyLink() {
		testID = "T12301";
		System.out.println("Test - 2");
//	    SignUPPopup signUPPopup = new SignUPPopup(driver);
//		signUPPopup.clickOnPrivacyPolicy();
//		
//		ArrayList<String>addr = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(addr.get(1));
//		
//		String actualURL= driver.getCurrentUrl();
//		String actualTitle= driver.getTitle();
//		
//		String expectedURL = "https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0";
//		String expectedTitle = "Meta Privacy Policy - How Meta collects and uses user data policy redirect & entry";
		//
//		String actualText = driver.findElement(By.xpath("//div[@class='x78zum5 xdt5ytf']//span")).getText();
//		String expectedText = "Privacy Policy";
//		
//		Assert.assertEquals(actualURL,expectedURL);
//		
//		SoftAssert soft = new SoftAssert();
//		
//		soft.assertEquals(actualTitle,expectedTitle);
//		
//		soft.assertEquals(actualText,expectedText);
//		
//	    soft.assertAll();
//	}
		if(actualURL.equals(expectedURL)&& actualTitle.equals(expectedTitle))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED"); 
		}
	
	@Test
	public void verifyCookiesPolicyLink() {
		System.out.println("Test - 3");
	    SignUPPopup signUPPopup = new SignUPPopup(driver);
		signUPPopup.clickOnCookiesPolicy();
		
		ArrayList<String>addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
	String actualURL= driver.getCurrentUrl();
	String actualTitle= driver.getTitle();
	
	String expectedURL ="https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0";
	String expectedTitle = "Meta Cookies Policy";
	
	String actualText = driver.findElement(By.xpath("//div[@class='x78zum5 xdt5ytf']//span")).getText();
	String expectedText = "Cookies Policy";
	
	Assert.assertEquals(actualURL,expectedURL);
	
	SoftAssert soft = new SoftAssert();
	
	soft.assertEquals(actualTitle,expectedTitle);
	
	soft.assertEquals(actualText,expectedText);
	
    soft.assertAll();
}
//	if(actualURL.equals(expectedURL)&& actualTitle.equals(expectedTitle))
//	{
//		System.out.println("PASSED");
//	}
//	else
//	{
//		System.out.println("FAILED"); 
//	}

@AfterMethod
public void closedCurrentTab(ITestResult result) {
//	System.out.println("After method");
//	//driver.close();
//	ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
//	driver.switchTo().window(addr.get(0));	
//	}
	if (ITestResult.FAILURE==result.getStatus())
	{
		Utility.captureScreenshot(testID);
	}

@AfterClass
public void afterClass() {
	System.out.println("After Class");
	driver.quit();
}


}




