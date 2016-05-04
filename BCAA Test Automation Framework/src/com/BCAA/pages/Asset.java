package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;
import com.BCAA.utils.InputType;

public class Asset {

	private WebDriver driver;
	private final String PRODUCT_ID = "H1 ADVANTAGE HOME";
	BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * @param locDriver
	 */

	public Asset(WebDriver locDriver) {
		this.driver = locDriver;
	}

	By assetsTab = By.id("AssetTab_lnk");
	By selectHome = By.id("policyAsset_1_1");
	By addElement = By.id("btnAssetsTabAddId");
	By location = By.id("chkbxAddHomeLocation1Id");
	By plan = By.id("productId");

	/**
	 * Navigate to Assets Tab
	 */
	public void Assets() {
		driver = browserFactory.setElement(driver, assetsTab, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, addElement, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, selectHome, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, location, null, InputType.CHECK_CHECKBOX.getValue());
		driver = browserFactory.setElement(driver, plan, PRODUCT_ID, InputType.DROPDOWN.getValue());

	}
}
