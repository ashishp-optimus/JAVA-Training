package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for Add Or Edit Asset Page
 * 
 * @author Optimus
 */
public class AddOrEditAssetPage {

	Logger logger;
	Browser browser;

	public AddOrEditAssetPage() {
		logger = Logger.getLogger(AddOrEditAssetPage.class);
		browser = new Browser();
	}

	private final static String ADD_HOME_ASSETS = "Add Home";
	private final static String HOUSE_NUMBER = "4567";
	private final static String ATTRIBUTE_TYPE_VALUE = "value";
	private final static String CITY = "Burnaby";
	private final static String ADDRESS = "Canada Way";
	private final static String POSTALCODE = "V5G4T1";
	private final static String PROVINCE = "British Columbia";
	private final static String COUNTRY = "Canada";
	private final static String GO_TO_HOME_EVALUATION_TAB_INFO = "Navigating to Home Evaluation tab";
	private final static String GO_TO_RISK_TAB_INFO = "Navigating to Risk Details tab";
	private final static String Go_TO_SAFE_HOME_INFO = "Navigating to Safe Home tab";
	private final static String BUSINESS_TAB_INFO = "Navigating to Business tab";
	private final static String HOME_ASSET_INFO = "Inside addAsset method in AssetsTabPage Class";
	private final static String CONDO_INFO = "Inside addCondoAsset method in AssetsTabPage Class";
	private final static String TENANT_INFO = "Inside addTenantAsset method in AssetsTabPage Class";
	private final static String ADDRESS_INFO = "Inside verifyUpdatedAddress method in AssetsTabPage Class";
	private final static String CLICK_OK = "Inside clickOnOkButton method in AssetsTabPage Class";
	private final static String SELECT_FIREHALL_INFO = "Inside selectFirehallDistance method in AssetsTabPage Class";
	private final static String EDIT_ASSET_PLAN = "Inside editAssetPlan method in AssetsTabPage Class";

	private By addHomeAssetTextXpath = By
			.xpath("//*[@id='homeForm']/div[@id='home_asset_detail']/h2");
	private By homeLocationCheckboxId = By.id("chkbxAddHomeLocation1Id");
	private By planDropdownId = By.id("productId");
	private By copyMailingAddressBtnId = By
			.id("btnAddHomeCopyMailingAddressId");
	private By validHouseNumberId = By.id("houseNumber");
	private By cityId = By.id("city");
	private By addressId = By.id("addressLine1Id");
	private By postalCodeId = By.id("postalCodeId");
	private By provinceXpath = By.xpath("//*[@id='provinceIdSel']");
	private By countryXpath = By.xpath("//*[@id='countryCodeField']");
	private By safeTabId = By.id("safeHomeTab_lnk");
	private By homeEvaluationTabId = By.id("homeEvaluationTab_lnk");
	private By riskDetailsTabId = By.id("riskDetailsTab_lnk");
	private By businessTabId = By.id("businessTab_lnk");
	private By addHomeOkId = By.id("btnAddHomeOkId");
	private By firehallDistanceLookupCodeId = By
			.id("firehallDistanceLookupCode");

	private Button homeEvaluationTab = new Button(homeEvaluationTabId);
	private Button riskDetailsTab = new Button(riskDetailsTabId);
	private Button safeHomeTab = new Button(safeTabId);
	private Button copyMailingAddressBtn = new Button(copyMailingAddressBtnId);
	private Button businessTab = new Button(businessTabId);
	private Button addHomeOk = new Button(addHomeOkId);

	private CheckBox homeLocationCheckbox = new CheckBox(homeLocationCheckboxId);

	private DropDown planDropdown = new DropDown(planDropdownId);
	private DropDown firehallDistanceLookupCode = new DropDown(
			firehallDistanceLookupCodeId);

	private TextBox city = new TextBox(cityId, CITY, ATTRIBUTE_TYPE_VALUE);
	private TextBox address = new TextBox(addressId, ADDRESS,
			ATTRIBUTE_TYPE_VALUE);
	private TextBox postalCode = new TextBox(postalCodeId, POSTALCODE,
			ATTRIBUTE_TYPE_VALUE);
	private TextBox validHouseNumber = new TextBox(validHouseNumberId,
			HOUSE_NUMBER, ATTRIBUTE_TYPE_VALUE);
	private TextBox province = new TextBox(provinceXpath, PROVINCE);
	private TextBox country = new TextBox(countryXpath, COUNTRY);
	private TextBox addHomeAssetText = new TextBox(addHomeAssetTextXpath,
			ADD_HOME_ASSETS);

	public void goToHomeEvaluationTab() {
		logger.info(GO_TO_HOME_EVALUATION_TAB_INFO);

		homeEvaluationTab.click();
	}

	public void goToRiskDetailsTab() {
		logger.info(GO_TO_RISK_TAB_INFO);

		riskDetailsTab.click();
	}

	public void goToSafeHomeTab() {
		logger.info(Go_TO_SAFE_HOME_INFO);

		safeHomeTab.click();
	}

	public void goToBusinessTab() {
		logger.info(BUSINESS_TAB_INFO);
		businessTab.click();
	}

	/**
	 * Add a new home asset
	 */
	public void addHomeAsset(String dropDownValue) {
		logger.info(HOME_ASSET_INFO);

		addHomeAssetText.verifyText();

		homeLocationCheckbox.selectCheckbox();

		editAssetPlan(dropDownValue);

		copyMailingAddressBtn.click();

		validHouseNumber.verifyTextByAttributeValue();
		city.verifyTextByAttributeValue();
		address.verifyTextByAttributeValue();
		postalCode.verifyTextByAttributeValue();

		province.verifyFirstSelectedOption();
		country.verifyFirstSelectedOption();
	}

	/**
	 * Add a new Condo asset
	 */
	public void addCondoAsset(String dropDownValue) {
		logger.info(CONDO_INFO);

		addHomeAssetText.verifyText();

		homeLocationCheckbox.selectCheckbox();

		editAssetPlan(dropDownValue);

		copyMailingAddressBtn.click();

		validHouseNumber.verifyTextByAttributeValue();
		city.verifyTextByAttributeValue();
		address.verifyTextByAttributeValue();
		postalCode.verifyTextByAttributeValue();

		province.verifyFirstSelectedOption();
		country.verifyFirstSelectedOption();
	}

	/**
	 * Add a new Tenant asset
	 */
	public void addTenantAsset(String dropDownValue) {
		logger.info(TENANT_INFO);

		addHomeAssetText.verifyText();

		homeLocationCheckbox.selectCheckbox();

		editAssetPlan(dropDownValue);

		copyMailingAddressBtn.click();

		validHouseNumber.verifyTextByAttributeValue();
		city.verifyTextByAttributeValue();
		address.verifyTextByAttributeValue();
		postalCode.verifyTextByAttributeValue();

		province.verifyFirstSelectedOption();
		country.verifyFirstSelectedOption();
	}

	/**
	 * Select DropDown Value From H1 to H5
	 */
	public void editAssetPlan(String dropDownValue) {
		logger.info(EDIT_ASSET_PLAN);

		planDropdown.setInValue(dropDownValue);
		planDropdown.selectValue();
	}

	/**
	 * To verify the updated address once an asset is added
	 */
	public void verifyUpdatedAddress() {
		logger.info(ADDRESS_INFO);

		validHouseNumber.verifyTextByAttributeValue();
	}

	public void clickOnOkButton() {
		logger.info(CLICK_OK);
		addHomeOk.click();
	}

	/**
	 * To Select firehall DropDown
	 */
	public void selectFirehallDistance() {
		logger.info(SELECT_FIREHALL_INFO);		
		firehallDistanceLookupCode.selectValue();
	}

}
