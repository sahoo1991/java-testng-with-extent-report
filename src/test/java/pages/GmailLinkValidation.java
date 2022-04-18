package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLinkValidation {
	
	private WebDriver driver;
	
	public GmailLinkValidation(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//a[text()='Gmail']")
	private WebElement gmailLink;
	
	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailInput;
	
	public void clickGmailLink() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement link = wait.until(ExpectedConditions.elementToBeClickable(gmailLink));
		link.click();
	}
	
	public void verifyGmailEmailInput() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean found = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(emailInput));
			found = true;
		}
		catch(TimeoutException e) {
			found = false;
		}
		assertEquals(found, false, "google email field not displayed");
	}
}

