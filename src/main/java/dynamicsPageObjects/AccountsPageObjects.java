package dynamicsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utilities;

public class AccountsPageObjects extends Utilities {
	
	WebDriver driver;

	public AccountsPageObjects(WebDriver driver) 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@title='Accounts']")
	private WebElement Accounts;
	
	@FindBy(xpath = "//button[@aria-label='New']")
	private WebElement New;
	
	@FindBy(xpath = "//input[@aria-label='Account Name']")
	private WebElement AccountName;
	
	@FindBy(xpath = "//input[@aria-label='Address 1: Street 1']")
	private WebElement addressOneStreetOne;
	
	@FindBy(xpath = "//button[@aria-label='Save (CTRL+S)']")
	private WebElement save;
	
	@FindBy(xpath = "//button[@aria-label='Save and Close']")
	private WebElement saveAndClose;
	
	@FindBy(xpath = "//input[@placeholder='Quick find']")
	private WebElement quickSearch;
	
	@FindBy(xpath = "//button[@title='Start search']")
	private WebElement startSearch;
	
	@FindBy(xpath = "//div[@role='gridcell'][3]")
	private WebElement clickOnResult;
	
	@FindBy(css = "li[title='Contacts'][aria-label='Contacts'][role='tab']")
	private WebElement contactsTab;
	
	@FindBy(xpath = "//button[contains(@title,'Add New Contact')]")
	private WebElement newContact;
	
	@FindBy(xpath = "//input[contains(@aria-label,'First Name')]")
	private WebElement contactsFirstName;
	
	@FindBy(xpath = "//input[@aria-label='Last Name']")
	private WebElement contactsLastName;
	
	@FindBy(xpath = "//input[@placeholder='Provide an email']")
	private WebElement contactsEmailAddress;
	
	@FindBy(xpath = "//button[@aria-label='OK']")
	private WebElement clickOnOkButton;
	
	@FindBy(xpath = "//li[@title='Summary']")
	private WebElement clickOnSummaryTab;
	
	@FindBy(xpath = "//button[contains(@title,'More commands for Account Profile')]")
	private WebElement clickAccountProfileIcon;
	
	@FindBy(xpath = "//span[contains(text(),'New Account Profile')]")
	private WebElement NewAccountProfile;
	
	@FindBy(xpath = "//input[@aria-label='Brand, Lookup']")
	private WebElement brandLookUpValue;
	
	@FindBy(xpath = "//li[@aria-label='SafeSupplier, 28/01/2021 09:44']")
	private WebElement safeSupplierOption;
	
	@FindBy(xpath = "//input[@aria-label='Profile, Lookup']")
	private WebElement profileLookUpValue;
	
	@FindBy(xpath = "//li[@aria-label='Supplier']")
	private WebElement supplierOption;
	
	@FindBy(xpath = "//li[@aria-label='Client']")
	private WebElement clientOption;
	
	@FindBy(xpath = "//input[@aria-label='AX Account Number']")
	private WebElement AXAccountNumber;
	
	
	public void clickOnAccounts() throws InterruptedException
	{
		Accounts.click();
		Thread.sleep(5000);
	}
	
	public void clickOnNew() throws InterruptedException
	{
		New.click();
		Thread.sleep(8000);
	}
	
	public WebElement enterAccountName() 
	{
		AccountName.click();
		return AccountName;
	}
	
	public void enterAddressOneStreetOne() 
	{
		addressOneStreetOne.sendKeys("Bond street");
		addressOneStreetOne.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	}
	
	public void clickOnSave() throws InterruptedException 
	{
		save.click();
		Thread.sleep(10000);
	}
	
	public void clickOnSaveAndClose() throws InterruptedException 
	{
		saveAndClose.click();
		Thread.sleep(10000);
	}
	
	public WebElement enterQuickFind() 
	{
		return quickSearch;
	}
	
	public void startSearch() throws InterruptedException 
	{
		startSearch.click();
		Thread.sleep(10000);
	}
	
	public void clickOnResult() throws InterruptedException 
	{
		Actions act = new Actions(driver);
		WebElement result = clickOnResult;
		act.doubleClick(result).perform();
		Thread.sleep(3000);
	}
	
	public void clickOnContactsTab() throws InterruptedException 
	{
		contactsTab.click();
		Thread.sleep(7000);
	}
	
	public void clickOnNewContact() throws InterruptedException 
	{
		newContact.click();
		Thread.sleep(5000);
	}
	
	public WebElement enterContactsFirstName() 
	{
		contactsFirstName.click();
		return contactsFirstName;
	}
	
	public WebElement enterContactsLastName() 
	{
		contactsLastName.click();
		return contactsLastName;
	}
	
	public WebElement enterContactsEmailAddress() 
	{
		return contactsEmailAddress;
	}
	
	public void clickOnOkButton() throws InterruptedException 
	{
		clickOnOkButton.click();
		Thread.sleep(1000);
	}
	
	public void clickOnSummaryTab() throws InterruptedException 
	{
		clickOnSummaryTab.click();
		Thread.sleep(3000);
	}
	
	public void clickAccountProfileIcon() throws InterruptedException 
	{
		clickAccountProfileIcon.click();
		
	}
	
	public void clickNewAccountProfile() throws InterruptedException 
	{
		NewAccountProfile.click();
		Thread.sleep(3000);
	}
	
	public void enterBrandlookUpValue() throws InterruptedException
	{
		brandLookUpValue.click();
		brandLookUpValue.sendKeys("Safe");
		Thread.sleep(1000);
		
	}
	
	public void selectBrandlookUpValue()
	{
		
		safeSupplierOption.click();
	}
	
	public void enterProfilelookUpValueAsClient() throws InterruptedException
	{
		profileLookUpValue.sendKeys("Client");
		Thread.sleep(1000);
	}
	
	public void enterProfilelookUpValueAsSupplier() throws InterruptedException
	{
		profileLookUpValue.click();
		profileLookUpValue.sendKeys("Supplier");
		Thread.sleep(1000);
	}
	
	public void selectProfilelookUpValueAsClient()
	{
		clientOption.click();
	}
	
	public void selectProfilelookUpValueAsSupplier()
	{
		supplierOption.click();
	}
	
	
	public void onAXAccountNumber()
	{
		AXAccountNumber.click();
	}
	
	
}
