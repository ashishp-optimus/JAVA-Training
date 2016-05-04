package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;
import com.BCAA.utils.InputType;

public class EditInsured {

	private WebDriver driver;

	BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * 
	 * @param locDriver
	 */
	public EditInsured(WebDriver locDriver) {
		this.driver = locDriver;
	}
	
	By creditInformation = By.id("drpdwnEditInsuredCreditInformationConsentId");
	By hasAnyInsurerCancelled = By.id("drpdwnEditInsuredRefusedInsuranceId");
	By occupation = By.id("occupationDescription");
	By ok = By.id("btnEditInsuredOkId");
    
	
	public void editInsuredTab() {

		driver = browserFactory.setElement(driver, creditInformation, "No - Consent was not provided",
				InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, hasAnyInsurerCancelled, "No", InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, occupation, "Economist", InputType.TEXT_BOX.getValue());
		driver = browserFactory.setElement(driver, ok, null, InputType.BUTTON.getValue());

	}
}
