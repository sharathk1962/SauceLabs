package saucelabs;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseGeneric;
import resources.ExtentReporter;

public class Listeners extends BaseGeneric implements ITestListener {

	ExtentTest test;	
	ExtentReports extent=ExtentReporter.ExtentRep();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Pased");
	}

	public void onTestFailure(ITestResult result) {
	//	WebDriver driver =null;
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		String testcasename=result.getMethod().getMethodName();
		try {
			//this one is usefull to get particular methodname in parallel execution
	//		driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(screenshotmethod(testcasename), result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "This test is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
	extent.flush();
	}
	
	

}
