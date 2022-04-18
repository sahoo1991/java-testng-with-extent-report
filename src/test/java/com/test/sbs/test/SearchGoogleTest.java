package com.test.sbs.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.GoogleHomeSearchResult;
import reports.ExtentLogging;
import reports.ExtentReport;
import utils.CommonBroserActions;
import utils.GetBrowser;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class SearchGoogleTest extends GetBrowser{
	
	public GoogleHomeSearchResult ghsr;
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
  public void f() {
	  CommonBroserActions caa = new CommonBroserActions();
	  caa.set_driver(driver);
	  caa.maximizeWindow();
	  caa.visitURL();
	  eLog.passLog("Visisted the site", report, logger);
	  ghsr = PageFactory.initElements(driver, GoogleHomeSearchResult.class);
	  ghsr.seachGoogleWithSpecifText("testing");
	  eLog.passLog("Searched with text Testing", report, logger);
	  ghsr.verifySeachedResults();
	  eLog.passLog("Result Found for searched results", report, logger);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  eLog.infoLog("Finished execution", report, logger);
  }

}
