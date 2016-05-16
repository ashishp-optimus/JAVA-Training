package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;

public class AssetsTabPage {
	Logger logger = Logger.getLogger(AssetsTabPage.class);
	Browser browser = new Browser();

	private final String ADD_HOME_ASSETS = "Add Home";
	private final String HOUSE_NUMBER = "4567";
	private final String ATTRIBUTE_TYPE_VALUE = "value";
	private final String CITY = "Burnaby";
	private final String ADDRESS = "Canada Way";
	private final String POSTALCODE = "V5G4T1";
	private final String PROVINCE = "British Columbia";
	private final String COUNTRY = "Canada";

	By assetsTabId = By.id("AssetTab");
	By selectHomeButtonId = By.id("policyAsset_1_1");
	By addAssetButtonId = By.id("btnAssetsTabAddId");
	By addHomeAssetTextXpath = By.xpath("//*[@id='homeForm']/div[@id='home_asset_detail']/h2");
	By homeLocationCheckBoxId = By.id("chkbxAddHomeLocation1Id");
	By planCheckboxId = By.id("productId");
	By copyMailingAddressButtonId = By.id("btnAddHomeCopyMailingAddressId");
	By validHouseNumberId = By.id("houseNumber");
	By cityId = By.id("city");
	By addressId = By.id("addressLine1Id");
	By postalCodeId = By.id("postalCodeId");
	By provinceXpath = By.xpath("//*[@id='provinceIdSel']");
	By countryXpath = By.xpath("//*[@id='countryCodeField']");
	

	PageElement assetsTab = new PageElement(assetsTabId, null, InputType.BUTTON);
	PageElement selectHome = new PageElement(selectHomeButtonId, null, InputType.BUTTON);
	PageElement addAssetButton = new PageElement(addAssetButtonId, null, InputType.BUTTON);
	PageElement addHomeAssetText = new PageElement(addHomeAssetTextXpath, ADD_HOME_ASSETS);
	PageElement homeLocationCheckbox = new PageElement(homeLocationCheckBoxId, null, InputType.CHECK_CHECKBOX);
	PageElement planCheckbox = new PageElement(planCheckboxId, PropertiesReader.readProperty("productId"),
			InputType.DROPDOWN);
	PageElement copyMailingAddressButton = new PageElement(copyMailingAddressButtonId, null, InputType.BUTTON);
	PageElement city = new PageElement(cityId, CITY, ATTRIBUTE_TYPE_VALUE);
	PageElement address = new PageElement(addressId, ADDRESS, ATTRIBUTE_TYPE_VALUE);
	PageElement postalCode = new PageElement(postalCodeId, POSTALCODE, ATTRIBUTE_TYPE_VALUE);
	PageElement province = new PageElement(provinceXpath, PROVINCE);
	PageElement country = new PageElement(countryXpath, COUNTRY);
	PageElement validHouseNumber = new PageElement(validHouseNumberId, HOUSE_NUMBER, ATTRIBUTE_TYPE_VALUE);
	

	/**
	 * Add a new home asset
	 */
	public void addAsset() {
		logger.info("Inside addAsset method in AssetsTabPage Class");
		browser.setElement(assetsTab);
		browser.setElement(selectHome);
		browser.setElement(addAssetButton);
		browser.verifyText(addHomeAssetText);
		browser.setElement(homeLocationCheckbox);
		browser.setElement(planCheckbox);
		browser.setElement(copyMailingAddressButton);
		browser.verifyTextByAttributeValue(validHouseNumber);
		browser.verifyTextByAttributeValue(city);
		browser.verifyTextByAttributeValue(address);
		browser.verifyTextByAttributeValue(postalCode);
		browser.verifyFirstSelectedOption(province);
		browser.verifyFirstSelectedOption(country);
	}

	/**
	 * To verify the updated address once an asset is added
	 */

	public void verifyUpdatedAddress() {
		logger.info("Inside verifyUpdatedAddress method in AssetsTabPage Class");
		browser.verifyTextByAttributeValue(validHouseNumber);
	
	}
}
