package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;

public class AssetsTabPage {
	Logger logger = Logger.getLogger(AssetsTabPage.class);

	private final String ADD_HOME_ASSETS = "Add Home";
	private final String HOUSE_NUMBER = "4567";
	private final String ATTRIBUTE_TYPE_VALUE = "value";
	private final String CITY = "Burnaby";
	private final String ADDRESS = "Canada Way";
	private final String POSTALCODE = "V5G4T1";
	private final String PROVINCE = "British Columbia";
	private final String COUNTRY = "Canada";
	private final String EDIT_HOME = "Edit Home";

	By assetsTabId = By.id("AssetTab");
	By selectHomeBtnId = By.id("policyAsset_1_1");
	By addAssetBtnId = By.id("btnAssetsTabAddId");
	By addHomeAssetTextXpath = By.xpath("//*[@id='homeForm']/div[@id='home_asset_detail']/h2");
	By homeLocationCheckboxId = By.id("chkbxAddHomeLocation1Id");
	By planDropdownId = By.id("productId");
	By copyMailingAddressBtnId = By.id("btnAddHomeCopyMailingAddressId");
	By validHouseNumberId = By.id("houseNumber");
	By cityId = By.id("city");
	By addressId = By.id("addressLine1Id");
	By postalCodeId = By.id("postalCodeId");
	By provinceXpath = By.xpath("//*[@id='provinceIdSel']");
	By countryXpath = By.xpath("//*[@id='countryCodeField']");
	By homePolicyAssetId = By.id("policyAsset_2_2");
	By editAssetsTabId = By.id("btnAssetsTabEditId");
	By verifyEditHomeId = By.xpath(".//*[@id='home_asset_detail']/h2/span");

	PageElement assetsTab = new PageElement(assetsTabId, null, InputType.BUTTON);
	PageElement selectHomeBtn = new PageElement(selectHomeBtnId, null, InputType.BUTTON);
	PageElement addAssetBtn = new PageElement(addAssetBtnId, null, InputType.BUTTON);
	PageElement addHomeAssetText = new PageElement(addHomeAssetTextXpath, ADD_HOME_ASSETS);
	PageElement homeLocationCheckbox = new PageElement(homeLocationCheckboxId, null, InputType.CHECK_CHECKBOX);
	PageElement planDropdown = new PageElement(planDropdownId, PropertiesReader.readProperty("productId"),
			InputType.DROPDOWN);
	PageElement copyMailingAddressBtn = new PageElement(copyMailingAddressBtnId, null, InputType.BUTTON);
	PageElement city = new PageElement(cityId, CITY, ATTRIBUTE_TYPE_VALUE);
	PageElement address = new PageElement(addressId, ADDRESS, ATTRIBUTE_TYPE_VALUE);
	PageElement postalCode = new PageElement(postalCodeId, POSTALCODE, ATTRIBUTE_TYPE_VALUE);
	PageElement province = new PageElement(provinceXpath, PROVINCE);
	PageElement country = new PageElement(countryXpath, COUNTRY);
	PageElement validHouseNumber = new PageElement(validHouseNumberId, HOUSE_NUMBER, ATTRIBUTE_TYPE_VALUE);
	PageElement homePolicyAsset = new PageElement(homePolicyAssetId, null, InputType.BUTTON);
	PageElement editAssetsTab = new PageElement(editAssetsTabId, null, InputType.BUTTON);
	PageElement verifyEditHome = new PageElement(verifyEditHomeId, EDIT_HOME);

	/**
	 * To navigate to Asset tab
	 */
	public void assetTab() {
		logger.info("Inside assetTab method in InsuredsTabPage Class");
		
		Button button = new Button();				
		button.click(assetsTab);
	}

	/**
	 * Add a new home asset
	 */

	public void addAsset() {
		logger.info("Inside addAsset method in AssetsTabPage Class");
		
		Button button = new Button();
		CheckBox checkbox = new CheckBox();
		DropDown dropdown = new DropDown();
		Browser browser = new Browser();
		
		button.click(assetsTab);
		button.click(selectHomeBtn);
		button.click(addAssetBtn);

		browser.verifyText(addHomeAssetText);
		
		checkbox.selectCheckbox(homeLocationCheckbox);
		
		dropdown.selectValue(planDropdown);
		
		button.click(copyMailingAddressBtn);
		
		browser.verifyTextByAttributeValue(validHouseNumber);
		browser.verifyTextByAttributeValue(city);
		browser.verifyTextByAttributeValue(address);
		browser.verifyTextByAttributeValue(postalCode);
		browser.verifyFirstSelectedOption(province);
		browser.verifyFirstSelectedOption(country);
	}
	/**
	 * Edit a new home asset
	 */
	/**
	 * Edit an existing home asset
	 */

	public void editAsset() {
		logger.info("Inside edit Asset method in AssetsTabPage Class");
		
		Button button = new Button();
		Browser browser = new Browser();

		button.click(homePolicyAsset);
		button.click(editAssetsTab);
		browser.verifyText(verifyEditHome);

	}

	/**
	 * To verify the updated address once an asset is added
	 */
	public void verifyUpdatedAddress() {
		logger.info("Inside verifyUpdatedAddress method in AssetsTabPage Class");
		
		Browser browser = new Browser();
		browser.verifyTextByAttributeValue(validHouseNumber);
	}
}