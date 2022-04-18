package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetBrowser {
	
	public static WebDriver driver;
	
	
	public WebDriver getBrowser() {
		GetBrowserProperty gp = new GetBrowserProperty();
		
		String browserToInvoke = gp.getBroserName();
		System.out.println("got the name as :"+ browserToInvoke);
		if (browserToInvoke.equalsIgnoreCase("chrome")) {
			return getChrome();
		}
		else {
			return null;
		}

	}

	private WebDriver getChrome() {
		
		 ChromeOptions options = new ChromeOptions();
		 WebDriverManager.chromedriver().driverVersion("100.0.4896.60").setup();
		 driver = new ChromeDriver(options);
		return driver;
	}
	
	

}
