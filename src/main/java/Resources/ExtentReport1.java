package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport1 {
	
	public static ExtentReports getReportObject() {
		String file ="D:\\Selenium\\Scripts\\PracticeTestingFrameWork\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		reporter.config().setReportName("Test Submit Order");
		reporter.config().setDocumentTitle("Test Submit Order");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Diksha Kamdi");
		return extent;
	}

}
