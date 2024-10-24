package com.Utilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.BaseClass.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Listeners implements the certains interfaces to track the flow of execution.
 * It is used to perform specific actions and also to get log information and can be used 
 * track test case execution start, Finish, Skip, Failure, Pass etc., 
 * 
 *@author PraneethReddy
 */

public class ListenersClass extends BaseTest implements ITestListener {

	// onTestStart method will invokes when the first test exceuton is started
	public void onTestStart(ITestResult result) {
		test.log(Status.INFO, MarkupHelper.createLabel("Test Start", ExtentColor.PURPLE));
		Reporter.log("Start-" + result.getName(), true);
	}

	// onTestSuccess method will invokes when ever the test is Passed
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		Reporter.log("success-" + result.getName(), true);
	}

	// onTestFailure method will invokes when ever the test is failed
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		Reporter.log("Failure-" + result.getName(), true);
		srcUtil.captureScreenshot(driver, result.getTestName());
	}

	// OnTestSkipped method will invokes when ever the test is skipped
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		Reporter.log("Skip-" + result.getName(), true);
	}

	// onStart method invokes and executes when the execution start
	public void onStart(ITestContext context) {
		ExtentSparkReporter	sparkReports = new ExtentSparkReporter(reportPath);
		ExtentReports	reports = new ExtentReports();
		reports.attachReporter(sparkReports);
		ExtentTest test = reports.createTest("Flipkart Functionalities");
		sparkReports.config().setDocumentTitle("Flipkart Reports");
		sparkReports.config().setReportName("Extent Report");
		sparkReports.config().setTheme(Theme.DARK);
		test.log(Status.INFO, "Extent Reports file is loaded and ready to generate reports");
		

	}

	// onFinish method will invokes when test execution is completed
	public void onFinish(ITestContext context) {
		Reporter.log("Task is completed-" + context.getName(), true);
		test.log(Status.INFO, MarkupHelper.createLabel("Finish", ExtentColor.WHITE));
		reports.flush();
	}
}
