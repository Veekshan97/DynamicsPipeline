package dynamicsPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utilities;

public class AppsPage extends Utilities 
{

	WebDriver driver;

	public AppsPage(WebDriver driver) 
	{

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@title='Sales Hub']")
	WebElement salesHubApp;
	
	@FindBy(xpath = "//div[@title='SCC']")
	WebElement salesSCCApp;
	

	public void clickOnSalesHub() throws InterruptedException {
		driver.switchTo().frame("AppLandingPage");
		salesHubApp.click();
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
	}
	
	public void clickOnSCC() throws InterruptedException {
		driver.switchTo().frame("AppLandingPage");
		salesSCCApp.click();
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
	}

}
