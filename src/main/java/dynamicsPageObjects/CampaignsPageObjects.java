package dynamicsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Utilities;

public class CampaignsPageObjects extends Utilities {
	
	WebDriver driver;

	public CampaignsPageObjects(WebDriver driver) 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@title='Campaigns']")
	private WebElement Campaigns;
	
	@FindBy(xpath = "//input[@aria-label='Name']")
	private WebElement campaignName;
	
	@FindBy(xpath = "//select[@title='Advertisement']")
	WebElement campaignType;
	
	@FindBy(xpath = "//input[@aria-label='Client, Lookup']")
	WebElement seacrhClient;
	
	@FindBy(xpath = "//ul[@aria-label='Lookup results']")
	WebElement seacrhResult;
	
	@FindBy(xpath = "//input[@aria-label='Date of Pre-note Date']")
	WebElement preNoteDate;
	
	@FindBy(xpath = "(//td[@role='gridcell'])[42]")
	WebElement date;
	
	@FindBy(css = "li[title='Leads'][aria-label='Leads'][role='tab']")
	WebElement leadsTab;
	
	@FindBy(xpath = "//button[@aria-label='New Lead. Add New Lead']")
	WebElement newLeadButton;
	
	@FindBy(xpath = "//input[@aria-label='Topic']")
	WebElement inputTopic;
	
	@FindBy(xpath = "//input[@aria-label='First Name']")
	WebElement leadFirstName;
	
	@FindBy(xpath = "//input[@aria-label='Last Name']")
	WebElement leadLastName;
	
	@FindBy(xpath = "//select[@aria-label='Lead source']")
	WebElement selectLeadSource;
	
	
	
	public void clickOnCampaigns() throws InterruptedException
	{
		Campaigns.click();
		Thread.sleep(5000);
	}
	
	public WebElement enterCampaignName()
	{
		campaignName.click();
		return campaignName;
	}
	
	public void enterCampaignType()
	{
		Select clinetList = new Select(campaignType);
		clinetList.selectByVisibleText("Client List");
	}
	
	public WebElement seacrhForClient()
	{
		seacrhClient.click();
		return seacrhClient;
	}
	
	public void clickOnResult() throws InterruptedException
	{
		Thread.sleep(2000);
		seacrhResult.click();
	}
	
	public void SelectPreNoteDate() throws InterruptedException
	{
		preNoteDate.click();
		Thread.sleep(1000);
		date.click();
	}

	public void clickOnLeadsTab() throws InterruptedException
	{
		leadsTab.click();
	}
	
	public void clickOnNewLeadButton() throws InterruptedException
	{
		Thread.sleep(2000);
		newLeadButton.click();
	}
	
	public void enterTopic() throws InterruptedException
	{
		Thread.sleep(3000);
		inputTopic.click();
		inputTopic.sendKeys("Topic test data");
	}
	
	public WebElement enterLeadFirstName()
	{
		leadFirstName.click();
		return leadFirstName;
	}
	
	public WebElement enterLeadLastName()
	{
		leadLastName.click();
		return leadLastName;
	}
	
	public void enterLeadSourceType()
	{
		Select LeadList = new Select(selectLeadSource);
		LeadList.selectByVisibleText("SafeSupplier Client List");
	}
	
}