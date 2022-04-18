package reports;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {
	
	private static ExtentReports report;
	
	private ExtentReport() {
		
	}
	
	public static ExtentReports getReportObject() {
		
		synchronized (ExtentReport.class) {
			if (report == null) {
				ExtentSparkReporter spark = new ExtentSparkReporter("output.html");
				String configFileDir = System.getProperty("user.dir");
				try {
					spark.loadXMLConfig(new File(configFileDir+"\\report-config.xml"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", System.getProperty("os.name"));
				report.setSystemInfo("Laptop Model", "Dell Vostro 3rd Gen");
				report.setSystemInfo("HostName", "sahoo Testing Academy");
				report.setSystemInfo("User Name", "Sangrambadi");
				report.setSystemInfo("Browser Type", "Chrome");
			}
			return report;
		}
		
	}

}
