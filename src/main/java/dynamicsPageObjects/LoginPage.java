package dynamicsPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utilities;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		//super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//objects
	@FindBy(xpath = "//input[@type='email']")
	private WebElement Email;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement Password;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Next;
	
	@FindBy(xpath = "//input[@name='DontShowAgain']")
	private WebElement DoNotShowAgain;
	
	
	
//	public void loginWithEmailAndPassword() throws InterruptedException
//	{
//		//userEmail.sendKeys(prop.getProperty("email"));
//		submit.click();
//		Thread.sleep(1000);
//		//userPassword.sendKeys(prop.getProperty("password"));
//		Thread.sleep(1000);
//		submit.click();
//		dontShowAgain.click();
//		submit.click();
//	
//	}
	
	
	//actions
	public WebElement enterEmail()
	{
		return Email;
	}
	public WebElement enterPassword() throws InterruptedException
	{
		Thread.sleep(1000);
		return Password;
	}
	public void clickOnNext() throws InterruptedException
	{
		
		Next.click();
	}
	public void clickOnDoNotShowAgain()
	{
		DoNotShowAgain.click();
	}
	
}
