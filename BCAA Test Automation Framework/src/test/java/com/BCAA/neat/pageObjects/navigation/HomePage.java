package com.BCAA.neat.pageObjects.navigation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * @author Optimus
 */

public class HomePage {
	Logger logger = Logger.getLogger(HomePage.class);
	Browser browser = new Browser();

	private final String HOME_TAB_TEXT = "Home";
	private final String HOME_NEAT_HEADER = "NEAT";

	By insuranceTab = By.id("tabInsuranceId");
	By homeTab = By.xpath("//li[@class='current']/a[contains(.,'Home')]");
	By houseHoldInfo = By.id("householdInfoLi");
	By homeNeatHeader = By.xpath("//div[@class='colitem']/h2");

	PageElement waitTillHouseHoldInfoVisible = new PageElement(houseHoldInfo);
	PageElement verifyHomeTabText = new PageElement(homeTab, HOME_TAB_TEXT);
	PageElement verifyHomeNeatHeaderText = new PageElement(homeNeatHeader, HOME_NEAT_HEADER);
	PageElement selectInsuranceTab = new PageElement(insuranceTab, null, InputType.BUTTON);

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
	public void selectInsurance() {
		logger.info("Inside selectInsurance method in HomePage Class");
		
		selectInsuranceTab = new PageElement(insuranceTab, null, InputType.BUTTON);

		browser.setElement(selectInsuranceTab);
	}
}
