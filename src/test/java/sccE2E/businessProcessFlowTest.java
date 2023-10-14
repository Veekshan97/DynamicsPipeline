package sccE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import dynamicsPageObjects.AccountsPageObjects;
import dynamicsPageObjects.AppsPage;
import dynamicsPageObjects.CampaignsPageObjects;
import dynamicsPageObjects.LoginPage;

public class businessProcessFlowTest extends Base {
	
	public businessProcessFlowTest() 
	{
		super();
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException 
{

		driver = initializeBrowserAndVisitUrl(prop.getProperty("browser"));
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmail().sendKeys(prop.getProperty("email"));
		loginPage.clickOnNext();
		loginPage.enterPassword().sendKeys(prop.getProperty("password"));
		loginPage.clickOnNext();
		loginPage.clickOnDoNotShowAgain();
		loginPage.clickOnNext();
		
	}

	@AfterMethod
	public void closeDown() 
	{
		
		driver.quit();
	}
	@Test(priority = 1)
	public void businessProcessFlowCheck() throws InterruptedException {
		
		AppsPage appspage = new AppsPage(driver);
		AccountsPageObjects accountsPage = new AccountsPageObjects(driver);
		CampaignsPageObjects campaignsPage = new CampaignsPageObjects(driver);
		
		//Select salesHub App
		appspage.clickOnSCC();
	
		
		//creating a Lead
		driver.findElement(By.xpath("//div[@title='Sales']")).click();
		Thread.sleep(1000);
		// updated with some comment - renamed
		
		//campaignsPage.clickOnLeadsTab();
	//	campaignsPage.clickOnNewLeadButton();
	//	campaignsPage.enterTopic();
	//	campaignsPage.enterLeadFirstName().sendKeys(leadFirstName);
	//	campaignsPage.enterLeadLastName().sendKeys(leadLastName);
	//	accountsPage.clickOnSaveAndClose();
		
		
	}
	
	public long creationTime() {
		long currentTime = System.currentTimeMillis() / 10000;
		return currentTime;
	}
}
