package com.BCAA.neat.pageObjects.navigation;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for Home page
 * 
 * @author Optimus
 */

public class HomePage {
	Logger logger;
	Browser browser;
	
	DataBaseConnection dataBaseConnection = new DataBaseConnection();
	private Map<String, String> homePage = dataBaseConnection.getDatabase().getPageCollectionsAsMap("HOMEPAGE");

	public HomePage() {
		logger = Logger.getLogger(HomePage.class);
		browser = new Browser();
	}

	private final static String VERIFY_LOGIN = "Inside verifyLogin method in HomePage Class";
	private final static String INSURANCE_TAB = "Navigating to Insurance tab";

	private By insuranceTab = By.id("tabInsuranceId");
	private By homeTab = By.xpath("//li[@class='current']/a[contains(.,'Home')]");
	private By houseHoldInfo = By.id("householdInfoLi");
	private By homeNeatHeader = By.xpath("//div[@class='colitem']/h2");

	private Button selectInsuranceTab = new Button(insuranceTab);

	private TextBox waitTillHouseHoldInfoVisible = new TextBox(houseHoldInfo);
	private TextBox verifyHomeTabText = new TextBox(homeTab, homePage.get("hometabtext"));
	private TextBox verifyHomeNeatHeaderText = new TextBox(homeNeatHeader, homePage.get("homeneatheader"));

	/**
	 * To verify successful login on TNEAT
	 */
	public void verifyLogin() {
		logger.info(VERIFY_LOGIN);

		waitTillHouseHoldInfoVisible.waitForVisibilityOfElement();

		verifyHomeTabText.verifyText();
		verifyHomeNeatHeaderText.verifyText();

	}
	
	public void waitTillHouseHoldInfoToAppear() {
		waitTillHouseHoldInfoVisible.waitForVisibilityOfElement();
	}

	/**
	 * This Method Select the Insurance tab
	 */
	public void selectInsuranceTab() {
		logger.info(INSURANCE_TAB);
		
		selectInsuranceTab.click();

	}
}
