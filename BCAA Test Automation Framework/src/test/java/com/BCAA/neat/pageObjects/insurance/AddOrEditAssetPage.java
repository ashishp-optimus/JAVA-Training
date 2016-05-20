package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is for Add Or Edit Asset Page
 * 
 * @author Optimus
 */
public class AddOrEditAssetPage {

	Logger logger = Logger.getLogger(AddOrEditAssetPage.class);

	private final static String ADD_HOME_ASSETS = "Add Home";
	private final static String HOUSE_NUMBER = "4567";
	private final static String ATTRIBUTE_TYPE_VALUE = "value";
	private final static String CITY = "Burnaby";
	private final static String ADDRESS = "Canada Way";
	private final static String POSTALCODE = "V5G4T1";
	private final static String PROVINCE = "British Columbia";
	private final static String COUNTRY = "Canada";

	private By addHomeAssetTextXpath = By.xpath("//*[@id='homeForm']/div[@id='home_asset_detail']/h2");
	private By homeLocationCheckboxId = By.id("chkbxAddHomeLocation1Id");
	private By planDropdownId = By.id("productId");
	private By copyMailingAddressBtnId = By.id("btnAddHomeCopyMailingAddressId");
	private By validHouseNumberId = By.id("houseNumber");
	private By cityId = By.id("city");
	private By addressId = By.id("addressLine1Id");
	private By postalCodeId = By.id("postalCodeId");
	private By provinceXpath = By.xpath("//*[@id='provinceIdSel']");
	private By countryXpath = By.xpath("//*[@id='countryCodeField']");

	private By assetsTabId = By.id("AssetTab");
	Button assetsTab = new Button(assetsTabId);
	

	private By homeEvaluationTabId = By.id("homeEvaluationTab_lnk");
	private By riskDetailsTabId = By.id("riskDetailsTab_lnk");
	
	Button homeEvaluationTab = new Button(homeEvaluationTabId);
	Button riskDetailsTab = new Button(riskDetailsTabId);

	Button copyMailingAddressBtn = new Button(copyMailingAddressBtnId);
	CheckBox homeLocationCheckbox = new CheckBox(homeLocationCheckboxId);
	DropDown planDropdown = new DropDown(planDropdownId, PropertiesReader.readProperty("productId"));
	PageElement addHomeAssetText = new PageElement(addHomeAssetTextXpath, ADD_HOME_ASSETS);
	PageElement city = new PageElement(cityId, CITY, ATTRIBUTE_TYPE_VALUE);
	PageElement address = new PageElement(addressId, ADDRESS, ATTRIBUTE_TYPE_VALUE);
	PageElement postalCode = new PageElement(postalCodeId, POSTALCODE, ATTRIBUTE_TYPE_VALUE);
	PageElement province = new PageElement(provinceXpath, PROVINCE);
	PageElement country = new PageElement(countryXpath, COUNTRY);
	PageElement validHouseNumber = new PageElement(validHouseNumberId, HOUSE_NUMBER, ATTRIBUTE_TYPE_VALUE);

	/**
	 * Navigational methods
	 */
	public void navigateToHomeEvaluationTab(){
		logger.info("Navigating to Home Evaluation tab");
		homeEvaluationTab.click();
	}
	
	public void navigateToRiskDetailsTab(){
		logger.info("Navigating to Risk Details tab");
		riskDetailsTab.click();
	}
	
	
	/**
	 * Add a new home asset
	 */
	public void addAsset() {
		
		logger.info("Inside addAsset method in AssetsTabPage Class");
		Browser browser = new Browser();

		browser.verifyText(addHomeAssetText);
		homeLocationCheckbox.selectCheckbox();
		planDropdown.selectValue();
		copyMailingAddressBtn.click();
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

		Browser browser = new Browser();
		browser.verifyTextByAttributeValue(validHouseNumber);
	}
}
