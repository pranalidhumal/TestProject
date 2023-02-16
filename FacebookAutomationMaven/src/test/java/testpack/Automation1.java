package testpack;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Automation1 {

	@BeforeSuite
    public void beforeSuite()
   {
	       System.out.println("Before Suite - Automation");
    }
  @BeforeTest
    public void beforeTest()
		{
			System.out.println("Before Test - Automation");
		}
		
		@BeforeClass
		public void beforeClass()
		{
			System.out.println("Before Class - Automation");
		}
		@BeforeMethod
		public void beforeMethod()
		{
			System.out.println("Before Method - Automation");
		}
		@Test
		public void test1()
		{
			System.out.println("Test - 1 - Automation");
			
			String actualsTitle = "log in or sign up";
			String expectedTitle = "Facebook - log in or sign up";
			
			String actualUrl="https://www.facebook.com/";
			String expectedUrl = "https://www.facebook.com/home";
			
			String actualButtonText = "Cancel";
			String expectedButtonText = "Cancel";
			

			SoftAssert soft = new SoftAssert();
			
			soft.assertEquals(actualUrl,expectedUrl,"URL is wrong");

			soft.assertEquals(actualsTitle,expectedTitle,"Title is wrong");
			
			soft.assertEquals(actualButtonText,expectedButtonText,"Cancel Button Text is wrong");
	  
			soft.assertAll();
			
		}
		
		@Test
		public void test2()
		{
			System.out.println("Test - 2 - Automation"); 
		}
		@Test
		public void test3()
		{
			System.out.println("Test - 3 - Automation"); 
		}
		@Test
		public void test4()
		{
			System.out.println("Test - 4 - Automation"); 
		}
		
		@AfterMethod
		public void afterMethod()
		{
			System.out.println("After Method - Automation");
		}
		@AfterClass
		public void afterClass()
		{
			System.out.println("After Class - Automation");
		}
		@AfterTest
		public void afterTest()
		{
			System.out.println("After Test - Automation");
		}
		@AfterSuite
		public void afterSuite()
		{
			System.out.println("After Suite -Automation");
		}
	}




