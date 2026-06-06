package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getExtent() {
		if (extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
			reporter.config().setReportName("Automation Practice Report");
			reporter.config().setDocumentTitle("GUI Elements Execution Report");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Project", "Automation Practice");
			extent.setSystemInfo("Tester", "Arpan Jana");
		}
		return extent;
	}

}
