package com.restapitestingframework.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
@author Stavan S. Kodolikar
*
*
*/
public class ExtentReportHelper {

	 static ExtentReports extentReports;

	 static Date date = new Date();
	 static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
	 static String strDate = formatter.format(date);

	 static String FileName = "\\ExtentAutomationReport_";

	static String FilePath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\restapitestingframework\\reports" + FileName + strDate + ".html";

	public static ExtentReports getReport() {
		if (extentReports == null) {
			extentReports = new ExtentReports();
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(FilePath);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle(FileName);
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName(FileName);
			extentReports.attachReporter(htmlReporter);
			return extentReports;
		} else {
			return extentReports;
		}
	}

}
