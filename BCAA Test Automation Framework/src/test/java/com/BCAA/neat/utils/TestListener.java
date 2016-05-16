package com.BCAA.neat.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.BCAA.neat.executor.Browser;

/**
 * @author Optimus
 */
public class TestListener extends TestListenerAdapter {

	Logger logger = Logger.getLogger(TestListener.class);
	private String SCREENSHOTPATH = System.getProperty("user.dir") + "\\Screenshot\\";
	private String DUMPSFILEPATH= System.getProperty("user.dir") +"\\log\\htmlDumps.txt";

	/**
	 * Capture Screenshot on test failure
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		String methodName = result.getName().toString().trim();
		captureScreenshot(methodName);
		// to generate report in the browser Reporter Output
		Reporter.log("<div style='width: 100px; float: left;'>" + "<a style='padding:20px' href='" + SCREENSHOTPATH
				+ "'>" + "<img src='" + SCREENSHOTPATH + "' width='200px' /> " + "</a>" + "</div>" + "</div>");
		storeHtmlDumps(Browser.driver.getPageSource());
	}

	/**
	 * 
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Starting test case " + result.getName() + "*****");
		System.out.println("Priority of this method is " + result.getMethod().getPriority() + "*****");
	}

	/**
	 * 
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test '" + result.getName() + "'SKIPPED" + "*****");
	}

	/**
	 * This method capture the screenshot and save with the method Name
	 * 
	 * @param methodName
	 */
	public void captureScreenshot(String methodName) {
		logger.info("Capture the Screen shot");
		try {
			File scrFile = new File(SCREENSHOTPATH);
			// to clean directory
			FileUtils.cleanDirectory(scrFile);
			// to delete directory
			FileUtils.forceDelete(scrFile);
			// to create directory
			FileUtils.forceMkdir(scrFile);
			scrFile = ((TakesScreenshot) Browser.driver).getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(Calendar.getInstance().getTime());
			SCREENSHOTPATH = SCREENSHOTPATH + methodName + "_" + timeStamp + ".png";
			FileUtils.copyFile(scrFile, new File(SCREENSHOTPATH));

		} catch (Exception exception) {
			logger.warn(exception);
		}
	}

	/**
	 * This method store the html dumps file in the text file
	 * 
	 * @param methodName
	 */
	public void storeHtmlDumps(String pagesource) {
		try {
			Browser.driver.getPageSource();
			File dumps = new File(DUMPSFILEPATH);
			FileUtils.writeStringToFile(dumps, pagesource);
		} catch (Exception exception) {
			logger.warn(exception);
		}
	}
}
