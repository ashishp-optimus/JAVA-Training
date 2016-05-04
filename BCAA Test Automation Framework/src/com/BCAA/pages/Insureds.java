package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;
import com.BCAA.utils.InputType;

public class Insureds {

	private WebDriver driver;
	BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * @param locDriver
	 */
	public Insureds(WebDriver locDriver) {
		this.driver = locDriver;
	}

	By insuredTab = By.id("InsuredsTab_lnk");
	By selectEditElement = By.id("policyInsured_1_2");
	By editElement = By.id("btnInsuredsTabEditId");

	/**
	 * Navigate to Insured Tab 
	 */
	public void insuredTab() {
		
		// setting to the browserFactory instance.
		driver = browserFactory.setElement(driver, insuredTab, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, selectEditElement, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, editElement, null, InputType.BUTTON.getValue());

	}
}
