package com.test.sbs.test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.GmailLinkValidation;
import reports.ExtentLogging;
import reports.ExtentReport;
import utils.CommonBroserActions;
import utils.GetBrowser;

public class GmailLinkTest extends GetBrowser{
	
	public GmailLinkValidation glt;
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
	  public void f() throws IOException {
		  CommonBroserActions caa = new CommonBroserActions();
		  caa.set_driver(driver);
		  caa.maximizeWindow();
		  caa.visitURL();
		  eLog.passLog("Visisted the site", report, logger);
		  glt = PageFactory.initElements(driver, GmailLinkValidation.class);
		  glt.clickGmailLink();
		  eLog.passLog("clicked the gmail link", report, logger);
		  glt.verifyGmailEmailInput();
		  eLog.failLog("Input email field not found", report, logger);
		  eLog.failLogWithScreenshot("Input email field not found", report, logger, driver);
	  }
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
		  eLog.infoLog("Finished execution", report, logger);
	  }
}
