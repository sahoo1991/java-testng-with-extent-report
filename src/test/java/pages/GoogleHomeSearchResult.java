package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomeSearchResult {
	
	protected WebDriver driver;
	
	public GoogleHomeSearchResult(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(name = "q")
	private WebElement googleSearchField; 
	
	@FindBy(id = "result-stats")
	private WebElement searchResults;
	
	public void seachGoogleWithSpecifText(String text) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(googleSearchField));
		Actions action = new Actions(driver);
		action.click(searchField).sendKeys(text).sendKeys(Keys.ENTER).build().perform();
		
	}
	
	public void verifySeachedResults() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean found = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(searchResults));
			found = true;
		}
		catch(TimeoutException e) {
			found = false;
		}
		assertEquals(found, true, "No search results displayed");
	}
}
