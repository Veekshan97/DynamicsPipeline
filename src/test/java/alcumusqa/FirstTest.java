package alcumusqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import dynamicsPageObjects.AppsPage;
import dynamicsPageObjects.LoginPage;

public class FirstTest extends Base {

	public FirstTest()
	{
		super();
	
	}
	public WebDriver driver;


	long currentTime = System.currentTimeMillis() / 10000;
	long currentTimeMinusOne = currentTime--;

	String clientAccountName = "Auto client " + currentTime;
	String clientFirtsName = "clientFN " + currentTime;
	String clientLastName = "clientLN " + currentTime;
	String clientEmail = "veekshan.poshala+" + currentTime + "@alcumus.com";
	String supplierAccountName = "Auto Supplier " + currentTime;
	String supplierFirtsName = "contactFirst " + currentTime;
	String supplierLastName = "contactLast " + currentTime;
	String supplierEmail = "veekshan.poshala+" + currentTimeMinusOne + "@alcumus.com";
	String campaignName = "campaign" + currentTime;

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
	public void closeDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void leadAccountCreation() throws InterruptedException {

		AppsPage appspage = new AppsPage(driver);
		appspage.clickOnSalesHub();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//li[@title='Leads']")).click();
		driver.findElement(By.xpath("//button[@aria-label='New']")).click();

	}
	
	@Test(priority = 2,dataProvider = "campaignDataSet")
	public void createCampaign(String campaignName, String clientAccountName) throws InterruptedException {

		driver.switchTo().frame("AppLandingPage");
		driver.findElement(By.xpath("//div[@title='Sales Hub']")).click();
		driver.switchTo().defaultContent();

		// create a campaign
		Thread.sleep(10000);
		driver.findElement(By.xpath("//li[@title='Campaigns']")).click();
		driver.findElement(By.xpath("//button[@aria-label='New']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@aria-label='Name']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Name']")).sendKeys(campaignName);
		Select clinetList = new Select(driver.findElement(By.xpath("//select[@title='Advertisement']")));
		clinetList.selectByVisibleText("Client List");
		driver.findElement(By.xpath("//input[@aria-label='Client, Lookup']")).sendKeys(clientAccountName);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//ul[@aria-label='Lookup results']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Campaign Code']")).click();

		driver.findElement(By.xpath("//input[@aria-label='Date of Pre-note Date']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@role='gridcell'])[42]")).click();
		driver.findElement(By.xpath("//input[@aria-label='Brand, Lookup']")).sendKeys(testDataProp.getProperty("brand"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@aria-label='SafeSupplier, 28/01/2021 09:44']")).click();
		//driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")).click();

	}
	
	@DataProvider(name="campaignDataSet")
	public Object[][] campaignTestData()
	{
		Object[][] data = {{"Testcampaign one", "Testclinetname one"},{"Testcampaign two", "Testclinetname two"},
				{"Testcampaign three", "Testclinetname three"}};
		return data;
	}

}