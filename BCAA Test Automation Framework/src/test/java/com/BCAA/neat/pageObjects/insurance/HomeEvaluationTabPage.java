package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.PropertiesReader;

public class HomeEvaluationTabPage {
	Logger logger = Logger.getLogger(HomeEvaluationTabPage.class);

	private final static String ERROR_MSG = "There are no properties matching your search criteria. Please check the address spelling. If you still cannot locate the address, please provide Year Built, Style, Number of Stories, Finished Living Area and click the \"Populate\" button to load approximate construction details. These details must be verified by the customer.";
	private final static String MSB_SUCCESS_MSG = "MSB Values populated successfully.";
	private final static String DATA_STATUS = "Verified";
	private final static String ASSET_SUCCESS_MSG = "Policy Home Asset was saved successfully.";
	private final static String EDIT_QUOTE_POLICY_TEXT = "Edit Quote/Policy";

	
	private By yearBuiltTextboxId = By.id("yearBuiltHomeEval");
	private By styleDropdownId = By.id("msbStyle");
	private By numberOfStoreysDropdownId = By.id("msbNumberOfStoreys");
	private By copyMailingAddressBtnId = By.id("btnAddHomeCopyMailingAddressId");
	private By findPropertyBtnId = By.id("findPropertyButton");
	private By noPropertyErrorMessageXpath = By.xpath("//*[@id='errorMsgBox']/span/ul/li");
	private By finishedLivingAreaTextboxId = By.id("msbFinishedLivingArea");
	private By populateBtnId = By.id("populateButton");
	private By constructionDropdownId = By.id("msbConstruction");
	private By calculateBuildingValueBtnId = By.id("btnHomeEvaluationTabCalculateBuildingValueId");
	private By alertRctDataStatusBtnId = By.id("yui-gen8-button");
	private By verifiedDataStatusXpath = By.xpath("//*[@id='msbReviewdWithUser']/option[2]");
	private By saveBtnXpath = By.xpath(".//*[@id='btnHomeEvaluationTabSaveId']");
	private By okButtonHomeXpath = By.xpath(".//*[@id='btnAddHomeOkId']");
	private By msbSuccessMsgBoxXpath = By.xpath("//*[@id='msgbox']");
	private By deleteBtnId = By.id("btnAssetsTabDeleteId");
	private By bathTypeValue1DropdownId = By.id("msbBathTypeValue1");
	private By msbBathType2DropdownId = By.id("msbBathType2");
	private By msbBathCode2DropDownId = By.id("msbBathCode2");
	private By msbBathTypeValue2DropdownId = By.id("msbBathTypeValue2");
	private By msbPoolType1DropdownId = By.id("msbPoolType1");
	private By msbPoolTypeValue1DropdownId = By.id("msbPoolTypeValue1");
	private By msbCentralFireAlarmCheckedId = By.id("msbCentralFireAlarm");
	private By msbSecurityCameraCheckedId = By.id("msbSecurityCamera");
	private By msbElevatorCheckedId = By.id("msbElevator");
	private By msbCentralAcCheckedId = By.id("msbCentralAc");
	private By verifyEditQuoteOrPolicyTextXpath = By.xpath(".//*[@id='policy_detail']/h2/span");

	Button copyMailingAddressBtn = new Button(copyMailingAddressBtnId);
	Button findPropertyBtn = new Button(findPropertyBtnId);
	Button populateBtnSelect = new Button(populateBtnId);
	Button populateBtn = new Button(populateBtnId);
	Button calculateBuildingValueBtn = new Button(calculateBuildingValueBtnId);
	Button alertRCTDataStatusBtnSelect = new Button(alertRctDataStatusBtnId);
	Button saveBtnSelect = new Button(saveBtnXpath);
	Button okBtnHomeSelect = new Button(okButtonHomeXpath);
	Button deleteBtn = new Button(deleteBtnId);

	CheckBox msbCentralFireAlarmChecked = new CheckBox(msbCentralFireAlarmCheckedId);
	CheckBox msbSecurityCameraChecked = new CheckBox(msbSecurityCameraCheckedId);
	CheckBox msbElevatorChecked = new CheckBox(msbElevatorCheckedId);
	CheckBox msbCentralAcChecked = new CheckBox(msbCentralAcCheckedId);

	DropDown styleDropdown = new DropDown(styleDropdownId, PropertiesReader.readProperty("mbStyles"));
	DropDown numberOfStoreysDropdown = new DropDown(numberOfStoreysDropdownId,
			PropertiesReader.readProperty("storeyNumber"));
	DropDown constructionDropdown = new DropDown(constructionDropdownId,
			PropertiesReader.readProperty("selectConcrete"));
	DropDown bathTypeValue = new DropDown(bathTypeValue1DropdownId, PropertiesReader.readProperty("selectBathType"));
	DropDown msbBathType = new DropDown(msbBathType2DropdownId, PropertiesReader.readProperty("selectmsbBathType"));
	DropDown msbBathCode = new DropDown(msbBathCode2DropDownId, PropertiesReader.readProperty("selectmsbBathCode"));
	DropDown msbBathTypeValue = new DropDown(msbBathTypeValue2DropdownId,
			PropertiesReader.readProperty("selectmsbBathTypeValue"));
	DropDown msbPoolType = new DropDown(msbPoolType1DropdownId, PropertiesReader.readProperty("selectmsbPoolType1"));
	DropDown msbPoolTypeValue = new DropDown(msbPoolTypeValue1DropdownId,
			PropertiesReader.readProperty("selectmsbPoolTypeValue1"));

	PageElement noPropertyErrorMessage = new PageElement(noPropertyErrorMessageXpath, ERROR_MSG);
	PageElement msbSuccessMsgBox = new PageElement(msbSuccessMsgBoxXpath, MSB_SUCCESS_MSG);
	PageElement alertRCTDataStatusButton = new PageElement(alertRctDataStatusBtnId);
	PageElement verifiedDataStatus = new PageElement(verifiedDataStatusXpath, DATA_STATUS);
	PageElement assetSuccessMsgBox = new PageElement(msbSuccessMsgBoxXpath, ASSET_SUCCESS_MSG);
	PageElement VerifyEditQuotePolicyText = new PageElement(verifyEditQuoteOrPolicyTextXpath, EDIT_QUOTE_POLICY_TEXT);

	TextBox yearBuiltTextbox = new TextBox(yearBuiltTextboxId, PropertiesReader.readProperty("yearBuilt"));
	TextBox finishedLivingAreaTextbox = new TextBox(finishedLivingAreaTextboxId,
			PropertiesReader.readProperty("livingArea"));

	/**
	 * Add a new Home evaluation asset
	 * 
	 */

	public void addHomeEvaluation() {
		logger.info("Inside addHomeEvaluation method in HomeEvaluationTabPage Class");

		Browser browser = new Browser();

		
		findPropertyBtn.click();

		browser.verifyText(noPropertyErrorMessage);
		browser.waitTillElementIsClickable(populateBtn);

		yearBuiltTextbox.enterTextInField();

		styleDropdown.selectValue();
		numberOfStoreysDropdown.selectValue();

		finishedLivingAreaTextbox.enterTextInField();

		populateBtnSelect.click();

		browser.verifyText(msbSuccessMsgBox);

		constructionDropdown.selectValue();

		browser.waitTillElementIsClickable(calculateBuildingValueBtn);

		calculateBuildingValueBtn.click();

		browser.waitTillElementIsClickable(alertRCTDataStatusButton);

		alertRCTDataStatusBtnSelect.click();

		browser.verifyText(verifiedDataStatus);

		browser.waitTillElementIsClickable(saveBtnSelect);

		saveBtnSelect.click();

		browser.verifyText(assetSuccessMsgBox);

		browser.waitTillElementIsClickable(okBtnHomeSelect);

		okBtnHomeSelect.click();

		browser.verifyText(assetSuccessMsgBox);

		deleteBtn.click();
	}

	/**
	 * Edit an existing Home evaluation asset
	 * 
	 */
	public void editHomeEvaluation() {
		logger.info("Inside editHomeEvaluation method in HomeEvaluationTabPage Class");

		Browser browser = new Browser();

		bathTypeValue.selectValue();
		msbBathType.selectValue();
		msbBathCode.selectValue();
		msbBathTypeValue.selectValue();
		msbPoolType.selectValue();
		msbPoolTypeValue.selectValue();

		msbCentralFireAlarmChecked.selectCheckbox();
		msbSecurityCameraChecked.selectCheckbox();
		msbElevatorChecked.selectCheckbox();
		msbCentralFireAlarmChecked.selectCheckbox();
		msbCentralAcChecked.selectCheckbox();

		browser.waitTillElementIsClickable(calculateBuildingValueBtn);

		calculateBuildingValueBtn.click();

		browser.waitTillElementIsClickable(okBtnHomeSelect);

		okBtnHomeSelect.click();

		browser.verifyText(VerifyEditQuotePolicyText);

	}
}
