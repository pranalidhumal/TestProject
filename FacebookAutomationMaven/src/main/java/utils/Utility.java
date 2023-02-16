package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {



public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aksha\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
}
	public static void captureScreenshot(WebDriver driver,String methodName) throws IOException {
		
		TakesScreenshot t = (TakesScreenshot)driver;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy,HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\aksha\\Desktop\\New folder (2)\\test.jpeg");
		FileHandler.copy(src,dest);
	}

	public static String getDataFromExcel(String sheet,int row,int cell) {
	
	//String path = "C:\\Users\\aksha\\Desktop\\Pranali\\task.xlsx";
		
	FileInputStream file = new FileInputStream(file);
	
	String data =WorkbookFactory.create(file).getsheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	
	return data;
}
}
