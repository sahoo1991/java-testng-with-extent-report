package com.test.sbs.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.GoogleHome;
import reports.ExtentLogging;
import reports.ExtentReport;
import utils.CommonBroserActions;
import utils.GetBrowser;

public class GoogleHomePageTest extends GetBrowser{
	
	public GoogleHome ghome;
	public ExtentLogging eLog;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeMethod
	public void beforeMethod() {
		eLog = new ExtentLogging();
		report = ExtentReport.getReportObject();
		String testCaseName = this.getClass().getName();
		driver = new GetBrowser().getBrowser();
		logger = report.createTest(testCaseName);
		eLog.infoLog(testCaseName, report, logger);
	}
  
	
	  @Test
	  public void f() throws InterruptedException {
		  
		  CommonBroserActions caa = new CommonBroserActions();
		  caa.set_driver(driver);
		  caa.maximizeWindow();
		  caa.visitURL();
		  eLog.passLog("Visisted the site", report, logger);
		  ghome = PageFactory.initElements(driver, GoogleHome.class);
		  ghome.verifyGoogleHomepage();
		  eLog.passLog("Verify success on home page", report, logger);
		  
	  }
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
		  eLog.infoLog("Finished execution", report, logger);
	  }
}
