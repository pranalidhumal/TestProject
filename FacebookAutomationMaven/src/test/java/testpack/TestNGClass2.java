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

public class TestNGClass2 {

	@BeforeSuite
    public void beforeSuite() {
   
	       System.out.println("Before Suite - TestNGClass");
    }
    @BeforeTest
    public void beforeTest()
		{
			System.out.println("Before Test - TestNGClass");
		}
		
		@BeforeClass
		public void beforeClass()
		{
			System.out.println("Before Class - TestNGClass");
		}
		@BeforeMethod
		public void beforeMethod()
		{
			System.out.println("Before Method - TestNGClass");
		}
	//Hard assert
	@Test
	public void testA()
	{
		System.out.println("Test - A - TestNGClass");
		
		String actualsTitle = "log in or sign up";
		String expectedTitle = "Facebook - log in or sign up";
		
		Assert.assertEquals(actualsTitle,expectedTitle);
		Assert.assertEquals(actualsTitle,expectedTitle,"Login page title id wrong");
		
		Assert.assertNotEquals(actualsTitle,expectedTitle,"Login page title id wrong");

		boolean result = actualsTitle.equals(expectedTitle);
		
		Assert.assertTrue(result);
		
		Assert.assertFalse(result);
		Assert.fail();
//		if(actualsTitle.equals(expectedTitle));
//		{
//			
//		}
//		else
//		{
//			Assert.fail();
//		}
		//or
		if(actualsTitle.equals(expectedTitle));
		{
			Assert.fail();

		}

	}
	@Test
	public void testB()
	{
		System.out.println("Test - B - TestNGClass"); 
	}
	@Test
	public void testC()
	{
		System.out.println("Test - C - TestNGClass"); 
	}
	@Test
	public void testD()
	{
		System.out.println("Test - D - TestNGClass"); 
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method - TestNGClass");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class - TestNGClass");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test - TestNGClass");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite - TestNGClass");
	}
}
