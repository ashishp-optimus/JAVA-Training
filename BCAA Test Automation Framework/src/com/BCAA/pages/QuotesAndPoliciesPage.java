package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;
import com.BCAA.utils.InputType;
import com.BCAA.utils.PropertiesReader;

public class QuotesAndPoliciesPage {
	private WebDriver driver;
	private final String SELECT_INSURANCE_PLAN = "Select Insurance Plan";
	
	By memberNumber = By.id("txtbxFindPolicyMemberNumberId");
	By associateNumber = By.id("txtbxFindPolicyAssociateNumberId");
	By searchButton = By.id("btnFindPolicySearchId");
	By createQuote = By.id("btnFindPolicyCreateQuoteId");
	By selectInsurancePlanText = By.id("selectInsurancePlan");

	BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * 
	 * @param locDriver
	 */

	public QuotesAndPoliciesPage(WebDriver locDriver) {
		this.driver = locDriver;
	}

	/**
	 * 
	 * To create a new Quote on TNEAT
	 */
	public void createQuote() {
		driver = browserFactory.setElement(driver, memberNumber, PropertiesReader.readProperty("memberNumber"),
				InputType.TEXT_BOX.getValue());
		driver = browserFactory.setElement(driver, associateNumber, PropertiesReader.readProperty("associateNumber"),
				InputType.TEXT_BOX.getValue());
		driver = browserFactory.setElement(driver, createQuote, null, InputType.BUTTON.getValue());
		driver = browserFactory.getText(driver, selectInsurancePlanText, SELECT_INSURANCE_PLAN);

	}

}
