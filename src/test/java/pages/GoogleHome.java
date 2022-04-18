package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHome {
	
	protected WebDriver driver;
	
	public GoogleHome(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//img[@alt='Google']")
	private WebElement googleLogo;
	
	public void verifyGoogleHomepage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean found = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(googleLogo));
			found = true;
		}
		catch(TimeoutException e) {
			found = false;
		}
		assertEquals(found, true, "google home page not displayed");
	}

}
