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
 * This class is for defining methods relating to capturing screenshots,
 * HTMLdumps and other logger activites
 * 
 * @author Optimus
 */
public class TestListener extends TestListenerAdapter {

	Logger logger = Logger.getLogger(TestListener.class);

	private String SCREENSHOTPATH = null;
	private String HTMLDUMPS = null;
	/**
	 * Capture Screenshot on test failure
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		SCREENSHOTPATH = System.getProperty("user.dir") + "\\Screenshot\\";
		HTMLDUMPS = System.getProperty("user.dir") + "\\htmlDumps\\";
		
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		
		String methodName = result.getName().toString().trim();
		captureScreenshotOnFailure(methodName);
		// to generate report in the browser Reporter Output
		Reporter.log("<div style='width: 100px; float: left;'>" + "<a style='padding:20px' href='" + SCREENSHOTPATH
				+ "'>" + "<img src='" + SCREENSHOTPATH + "' width='200px' /> " + "</a>" + "</div>" + "</div>");
		storeHtmlDumps();
	}

	/**
	 * 
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Starting test case " + result.getName() + "*****");
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
	public void captureScreenshotOnFailure(String methodName) {
		logger.info("Capturing the screen shot for the failed test");		
		try {			
			File scrFile = new File(SCREENSHOTPATH);

			scrFile = ((TakesScreenshot) Browser.driver).getScreenshotAs(OutputType.FILE);
			SCREENSHOTPATH = SCREENSHOTPATH + methodName + "_" + new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(Calendar.getInstance().getTime()) + ".png";
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
	public void storeHtmlDumps() {
		logger.info("Creating HTML dump file for the failed test");		
		try {
			String pagesource = Browser.driver.getPageSource();
			HTMLDUMPS = HTMLDUMPS + "htmldumps" + "_" + new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(Calendar.getInstance().getTime()) + ".txt";
			
			FileUtils.writeStringToFile(new File(HTMLDUMPS), pagesource);
		} catch (Exception exception) {
			logger.warn(exception);
		}
	}
}
