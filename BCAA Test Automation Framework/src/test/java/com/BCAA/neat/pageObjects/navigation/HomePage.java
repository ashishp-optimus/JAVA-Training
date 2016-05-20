package com.BCAA.neat.pageObjects.navigation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * @author Optimus
 */

public class HomePage {
	Logger logger = Logger.getLogger(HomePage.class);
	Browser browser = new Browser();

	private final static String HOME_TAB_TEXT = "Home";
	private final static String HOME_NEAT_HEADER = "NEAT";

	private By insuranceTab = By.id("tabInsuranceId");
	private By homeTab = By.xpath("//li[@class='current']/a[contains(.,'Home')]");
	private By houseHoldInfo = By.id("householdInfoLi");
	private By homeNeatHeader = By.xpath("//div[@class='colitem']/h2");

	Button selectInsuranceTab = new Button(insuranceTab);

	PageElement waitTillHouseHoldInfoVisible = new PageElement(houseHoldInfo);
	PageElement verifyHomeTabText = new PageElement(homeTab, HOME_TAB_TEXT);
	PageElement verifyHomeNeatHeaderText = new PageElement(homeNeatHeader, HOME_NEAT_HEADER);

	/**
	 * To verify successful login on TNEAT
	 */
	public void verifyLogin() {
		logger.info("Inside verifyLogin method in HomePage Class");

		browser.waitForVisibility(waitTillHouseHoldInfoVisible);

		browser.verifyText(verifyHomeTabText);
		browser.verifyText(verifyHomeNeatHeaderText);

	}

	/**
	 * This Method Select the Insurance tab
	 */
	public void selectInsuranceTab() {
		logger.info("Navigating to Insurance tab");
		selectInsuranceTab.click();

	}
}
