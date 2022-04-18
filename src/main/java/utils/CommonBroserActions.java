package utils;

import org.openqa.selenium.WebDriver;

public class CommonBroserActions {
	
	private WebDriver driver;
	
	public void set_driver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void maximizeWindow() {
		this.driver.manage().window().maximize();
	}
	
	public void visitURL() {
		this.driver.get(new GetBrowserProperty().getSiteToVisit());
		
	}

}
