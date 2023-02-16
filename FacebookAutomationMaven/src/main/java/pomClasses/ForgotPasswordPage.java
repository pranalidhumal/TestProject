package pomClasses;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

	@FindBy(xpath = "//table//tr[1]//td[2]//div")
	private WebElement forgotMessage;
	
	@FindBy(xpath = "(//input[@name ='email'])[2]")
	private WebElement emailOrPhoneNumber;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton;
	
	//forgotten account
	@FindBy(xpath = "//a")
	private List<WebElement>links;

	private WebDriver driver;
	
	//driver - driverTest - new ChromeDriver();
	public ForgotPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
		Actions act = new Actions(driver);
	}
	//fogotten account
	public String getLink(int index) {
		String attributeValue = links.get(index).getAttribute("href");
		return attributeValue;
		
		
	}
	//explicit wait
	public void getTextMessage() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollIntoView(true);", forgotMessage);
		String text = forgotMessage.getText();
		
	}
	//explicit wait
	public void sendEmailOrPhoneNumber() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(emailOrPhoneNumber));
		emailOrPhoneNumber.click();
	}
	//mouse action
	public void clickOnSearchButton() {
		Actions act = new Actions(driver);
		act.moveToElement(searchButton).click().perform();
		//Alert popup
		Alert alt = driver.switchTo().alert();
		String text = alt.getText();
		System.out.println(text);
		alt.accept();
		//alt.dismiss();
	}
	
	public void clickOnCancelButton() {
		Actions act = new Actions(driver);
		act.moveToElement(cancelButton).click().perform();
		//Alert popup
		Alert alt = driver.switchTo().alert();
		String text = alt.getText();
		System.out.println(text);
		alt.accept();
		//alt.dismiss();
	}
	
	

		
}
