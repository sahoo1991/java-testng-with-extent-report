package reports;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotsFactory {
	
	public String takeScreenPrintAndReturnPath(WebDriver driver, String stepName) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-mm-yyyy HH-mm-ss");
		String formattedDate = now.format(format);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+formattedDate.toString()+stepName+".png"));
		return System.getProperty("user.dir")+"\\screenshots\\"+formattedDate.toString()+stepName+".png";
		
	}

}
