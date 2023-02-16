package pomClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignupPage {

	
	//variable - private -WebElements
	@FindBy(xpath = "//input[@type='text']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@type = 'password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[text() = 'Log in']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[text()='Forgotten password?']")
	private WebElement ForgotPasswordLink;
	
	
	@FindBy(xpath = "//a[text()='Create new account']")
	private WebElement creatNewAccount;
	
	@FindBy(xpath = "//a[text() = 'Create a page']")
	private WebElement creatPage;
	
	
	//constructor - public - WebElement Initialization(find)
	public LoginOrSignupPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	//methods - public - WebElements action
	//String user to user important
	public void sendUserName(String user) {
		userName.sendKeys(user);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
		
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void clickOnForgotPasswordLink() {
		ForgotPasswordLink.click();
	}
	
	
	public void openSignUpForm() {
		creatNewAccount.click();
		
}
}
