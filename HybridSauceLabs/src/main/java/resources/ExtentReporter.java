package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports extent;
	
	public static ExtentReports ExtentRep()
	{
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		extent=new ExtentReports();
		reporter.config().setDocumentTitle("Live Project Sauce Labs");
		reporter.config().setReportName("SauceDemo Report");
		extent.attachReporter(reporter);
		extent.setSystemInfo("TesterName", "Sharath");
		return extent;
		
	}

}
