package alcumusqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class ThirdTest extends Base {
	
	public ThirdTest() {
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
	public void openBrowser() throws InterruptedException {

		driver = initializeBrowserAndVisitUrl(prop.getProperty("browser"));
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@name='DontShowAgain']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@AfterMethod
	public void closeDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void createClinetAccount() throws InterruptedException {

		System.out.println(driver.getTitle());
		driver.switchTo().frame("AppLandingPage");
		driver.findElement(By.xpath("//div[@title='Sales Hub']")).click();
		driver.switchTo().defaultContent();

		System.out.println(driver.getTitle());

		// creating an client account
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@title='Accounts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='New']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@aria-label='Account Name']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Account Name']")).sendKeys(clientAccountName);
		driver.findElement(By.xpath("//input[@aria-label='Address 1: Street 1']")).sendKeys("Bond street");
		driver.findElement(By.xpath("//input[@aria-label='Address 1: Street 1']")).sendKeys(Keys.ARROW_DOWN,
				Keys.ENTER);
		driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")).click();
		Thread.sleep(10000);

		// code for quick search
		driver.findElement(By.xpath("//div[@title='Accounts']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Quick find']")).sendKeys(clientAccountName);
		driver.findElement(By.xpath("//button[@title='Start search']")).click();
		Thread.sleep(8000);
		Actions act = new Actions(driver);
		WebElement result = driver.findElement(By.xpath("//div[@role='gridcell'][3]"));
		act.doubleClick(result).perform();
		Thread.sleep(3000);
//		
		// code for contact creation
		driver.findElement(By.cssSelector("li[title='Contacts'][aria-label='Contacts'][role='tab']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[contains(@title,'Add New Contact')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[contains(@aria-label,'First Name')]")).click();
		driver.findElement(By.xpath("//input[contains(@aria-label,'First Name')]")).sendKeys(clientFirtsName);
		driver.findElement(By.xpath("//input[@aria-label='Last Name']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Last Name']")).sendKeys(clientLastName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Provide an email']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Provide an email']")).sendKeys(clientEmail);
		driver.findElement(By.xpath("//input[@placeholder='Provide an email']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//button[@aria-label='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-label='Save and Close']")).click();
		Thread.sleep(10000);

		// account profile creation
		driver.findElement(By.xpath("//li[@title='Summary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@title,'More commands for Account Profile')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'New Account Profile')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Brand, Lookup']")).sendKeys("Safe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@aria-label='SafeSupplier, 28/01/2021 09:44']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Profile, Lookup']")).sendKeys("client");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@aria-label='Client']")).click();

		driver.findElement(By.xpath("//input[@aria-label='AX Account Number']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")).click();

		Thread.sleep(8000);

		driver.findElement(By.xpath("//div[@title='Accounts']")).click();
		System.out.println(driver.getTitle());

		// creating an account
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@title='Accounts']")).click();
		driver.findElement(By.xpath("//button[@aria-label='New']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@aria-label='Account Name']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Account Name']")).sendKeys(supplierAccountName);
		driver.findElement(By.xpath("//input[@aria-label='Address 1: Street 1']")).sendKeys("Bond street");
		driver.findElement(By.xpath("//input[@aria-label='Address 1: Street 1']")).sendKeys(Keys.ARROW_DOWN,
				Keys.ENTER);
		driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")).click();
		Thread.sleep(10000);

		// code for quick search
		driver.findElement(By.xpath("//div[@title='Accounts']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Quick find']")).sendKeys(supplierAccountName);
		driver.findElement(By.xpath("//button[@title='Start search']")).click();
		Thread.sleep(5000);
		Actions actOnGrid = new Actions(driver);
		WebElement resultofGrid = driver.findElement(By.xpath("//div[@role='gridcell'][3]"));
		actOnGrid.doubleClick(resultofGrid).perform();
		Thread.sleep(5000);

		// contact creation
		driver.findElement(By.cssSelector("li[title='Contacts'][aria-label='Contacts'][role='tab']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(@title,'Add New Contact')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[contains(@aria-label,'First Name')]")).click();
		driver.findElement(By.xpath("//input[contains(@aria-label,'First Name')]")).sendKeys(supplierFirtsName);
		driver.findElement(By.xpath("//input[@aria-label='Last Name']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Last Name']")).sendKeys(supplierLastName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Provide an email']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Provide an email']")).sendKeys(supplierEmail);
		driver.findElement(By.xpath("//input[@placeholder='Provide an email']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//button[@aria-label='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-label='Save and Close']")).click();
		Thread.sleep(10000);

		// account profile creation
		driver.findElement(By.xpath("//li[@title='Summary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@title,'More commands for Account Profile')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'New Account Profile')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Brand, Lookup']")).sendKeys("Safe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@aria-label='SafeSupplier, 28/01/2021 09:44']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Profile, Lookup']")).sendKeys("Supplier");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@aria-label='Supplier']")).click();

		driver.findElement(By.xpath("//input[@aria-label='AX Account Number']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")).click();

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
		driver.findElement(By.xpath("//button[@aria-label='23, September, 2023']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Brand, Lookup']")).sendKeys("Safe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@aria-label='SafeSupplier, 28/01/2021 09:44']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")).click();
		Thread.sleep(10000);

	}

	@Test(priority = 2)
	public void createSupplierAccount() throws InterruptedException {

		driver.switchTo().frame("AppLandingPage");
		driver.findElement(By.xpath("//div[@title='Sales Hub']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[@title='Accounts']")).click();
		System.out.println(driver.getTitle());

		// creating an account
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@title='Accounts']")).click();
		driver.findElement(By.xpath("//button[@aria-label='New']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@aria-label='Account Name']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Account Name']")).sendKeys(supplierAccountName);
		driver.findElement(By.xpath("//input[@aria-label='Address 1: Street 1']")).sendKeys("Bond street");
		driver.findElement(By.xpath("//input[@aria-label='Address 1: Street 1']")).sendKeys(Keys.ARROW_DOWN,
				Keys.ENTER);
		driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")).click();
		Thread.sleep(10000);

		// code for quick search
		driver.findElement(By.xpath("//div[@title='Accounts']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Quick find']")).sendKeys(supplierAccountName);
		driver.findElement(By.xpath("//button[@title='Start search']")).click();
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		WebElement result = driver.findElement(By.xpath("//div[@role='gridcell'][3]"));
		act.doubleClick(result).perform();
		Thread.sleep(5000);

		// contact creation
		driver.findElement(By.cssSelector("li[title='Contacts'][aria-label='Contacts'][role='tab']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(@title,'Add New Contact')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[contains(@aria-label,'First Name')]")).click();
		driver.findElement(By.xpath("//input[contains(@aria-label,'First Name')]")).sendKeys(supplierFirtsName);
		driver.findElement(By.xpath("//input[@aria-label='Last Name']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Last Name']")).sendKeys(supplierLastName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Provide an email']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Provide an email']")).sendKeys(supplierEmail);
		driver.findElement(By.xpath("//input[@placeholder='Provide an email']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//button[@aria-label='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-label='Save and Close']")).click();
		Thread.sleep(10000);

		// account profile creation
		driver.findElement(By.xpath("//li[@title='Summary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@title,'More commands for Account Profile')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'New Account Profile')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Brand, Lookup']")).sendKeys("Safe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@aria-label='SafeSupplier, 28/01/2021 09:44']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Profile, Lookup']")).sendKeys("Supplier");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@aria-label='Supplier']")).click();

		driver.findElement(By.xpath("//input[@aria-label='AX Account Number']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")).click();
		Thread.sleep(8000);

	}

	@Test(priority = 3)
	public void createCampaign() throws InterruptedException {

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
		driver.findElement(By.xpath("//button[@aria-label='23, September, 2023']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Brand, Lookup']")).sendKeys("Safe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@aria-label='SafeSupplier, 28/01/2021 09:44']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")).click();

	}

	public long creationTime() {
		long currentTime = System.currentTimeMillis() / 10000;
		return currentTime;
	}
}
