package support;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Support {
	
	WebDriver driver;
	
	public Support(WebDriver driver) {
		
		this.driver = driver;
	}

	public void waitForElementToLoad(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

}
