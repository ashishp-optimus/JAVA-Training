package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;

public class HomePage {
	private WebDriver driver;
	private final String HOME_TAB_TEXT = "Home";

	By insuranceTab = By.id("tabInsuranceId");
	By homeTab = By.xpath("//li[@class='current']/a[contains(.,'Home')]");
	By houseHoldInfo = By.id("householdInfoLi");
	BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * 
	 * @param locDriver
	 */

	public HomePage(WebDriver locDriver) {

		this.driver = locDriver;
	}

	/**
	 * To verify successful login on TNEAT
	 */

	public WebDriver VerifyLogin() {
		browserFactory.waitForVisibility(driver, houseHoldInfo);
		driver = browserFactory.getText(driver, homeTab, HOME_TAB_TEXT);
		return driver;
	}
	
	public void selectInsurance(){
		driver = browserFactory.selectModule(driver, insuranceTab);
	}

}
