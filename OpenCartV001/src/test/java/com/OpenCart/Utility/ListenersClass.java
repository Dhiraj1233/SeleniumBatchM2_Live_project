package com.OpenCart.Utility;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersClass  implements ITestListener
{
	ExtentSparkReporter sparkreporter;
	ExtentReports extent;
	ExtentTest test;
	//
	public  void onStart(ITestContext context)
	{
		Date d = new Date();
		String d1 = d.toString().replace(":","-");
		sparkreporter=new ExtentSparkReporter("./reports/"+d1+" .html");//genrate the report
		sparkreporter.config().setDocumentTitle("Automation Report");//title of the report
		sparkreporter.config().setReportName("Positive testing");//name of the report
		sparkreporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();

		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Application","OpenCart");
		extent.setSystemInfo("User name",System.getProperty("user.name"));

		String os = context.getCurrentXmlTest().getParameter("Os");
		extent.setSystemInfo("Operating System", os);

		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) 
		{
			extent.setSystemInfo("Groups",includedGroups.toString());
		}	
	}
	public void onTestSuccess(ITestResult result) 
	{
		test=extent.createTest(result.getTestClass().getName());//create a new entry in report
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,"Test case passed is"+result.getName());//update status
	}
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " Got failed");
		test.log(Status.INFO, "Test case is Failed cause is: " + result.getThrowable().getMessage());

		try {
			String imgPath = ScreenshotUility.getDefect(result.getName()); 
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) 
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,"Test case skipped is"+result.getName()); 
		test.log(Status.INFO,"Test case skipped cause is"+result.getThrowable().getMessage()); 
	} 
	public void onFinish(ITestContext context)
	{ 
		extent.flush(); 
	}




}
