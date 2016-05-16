package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;

public class HomeEvaluationTabPage {
	Logger logger = Logger.getLogger(HomeEvaluationTabPage.class);
	Browser browser = new Browser();

	private final String ERROR_MSG = "There are no properties matching your search criteria. Please check the address spelling. If you still cannot locate the address, please provide Year Built, Style, Number of Stories, Finished Living Area and click the \"Populate\" button to load approximate construction details. These details must be verified by the customer.";
	private final String MSB_SUCCESS_MSG = "MSB Values populated successfully.";
	private final String DATA_STATUS = "Verified";
	private final String ASSET_SUCCESS_MSG = "Policy Home Asset was saved successfully.";

	By homeEvaluationTabId = By.id("homeEvaluationTab_lnk");
	By yearBuiltTextboxId = By.id("yearBuiltHomeEval");
	By styleDropdownId = By.id("msbStyle");
	By numberOfStoreysDropdownId = By.id("msbNumberOfStoreys");
	By copyMailingAddressButtonId = By.id("btnAddHomeCopyMailingAddressId");
	By findPropertyButtonId = By.id("findPropertyButton");
	By noPropertyErrorMessageXpath = By.xpath("//*[@id='errorMsgBox']/span/ul/li");
	By finishedLivingAreaTextboxId = By.id("msbFinishedLivingArea");
	By populateButtonId = By.id("populateButton");
	By constructionDropdownId = By.id("msbConstruction");
	By calculateBuildingValueButtonId = By.id("btnHomeEvaluationTabCalculateBuildingValueId");
	By alertRCTDataStatusButtonId = By.id("yui-gen8-button");
	By verifiedDataStatusXpath = By.xpath("//*[@id='msbReviewdWithUser']/option[2]");
	By saveButtonXpath = By.xpath(".//*[@id='btnHomeEvaluationTabSaveId']");
	By okButtonHomeXpath = By.xpath(".//*[@id='btnAddHomeOkId']");
	By msbSuccessMsgBoxXpath = By.xpath("//*[@id='msgbox']");
	By deleteButtonId = By.id("btnAssetsTabDeleteId");

	PageElement homeEvaluationTab = new PageElement(homeEvaluationTabId, null, InputType.BUTTON);
	PageElement yearBuiltTextbox = new PageElement(yearBuiltTextboxId, PropertiesReader.readProperty("yearBuilt"),
			InputType.TEXT_BOX);
	PageElement styleDropdown = new PageElement(styleDropdownId, PropertiesReader.readProperty("mbStyles"),
			InputType.DROPDOWN);
	PageElement numberOfStoreysDropdown = new PageElement(numberOfStoreysDropdownId,
			PropertiesReader.readProperty("storeyNumber"), InputType.DROPDOWN);
	PageElement copyMailingAddressButton = new PageElement(copyMailingAddressButtonId, null, InputType.BUTTON);
	PageElement findPropertyButton = new PageElement(findPropertyButtonId, null, InputType.BUTTON);
	PageElement noPropertyErrorMessage = new PageElement(noPropertyErrorMessageXpath, ERROR_MSG);
	PageElement finishedLivingAreaTextbox = new PageElement(finishedLivingAreaTextboxId,
			PropertiesReader.readProperty("livingArea"), InputType.TEXT_BOX);
	PageElement populateButtonSelect = new PageElement(populateButtonId, null, InputType.BUTTON);
	PageElement constructionDropdown = new PageElement(constructionDropdownId,
			PropertiesReader.readProperty("selectConcrete"), InputType.DROPDOWN);
	PageElement msbSuccessMsgBox = new PageElement(msbSuccessMsgBoxXpath, MSB_SUCCESS_MSG);
	PageElement populateButton = new PageElement(populateButtonId, null, InputType.BUTTON);
	PageElement calculateBuildingValueButton = new PageElement(calculateBuildingValueButtonId, null, InputType.BUTTON);
	PageElement alertRCTDataStatusButton = new PageElement(alertRCTDataStatusButtonId);
	PageElement alertRCTDataStatusButtonSelect = new PageElement(alertRCTDataStatusButtonId, null, InputType.BUTTON);
	PageElement verifiedDataStatus = new PageElement(verifiedDataStatusXpath, DATA_STATUS);
	PageElement saveButtonSelect = new PageElement(saveButtonXpath, null, InputType.BUTTON);
	PageElement okButtonHomeSelect = new PageElement(okButtonHomeXpath, null, InputType.BUTTON);
	PageElement assetSuccessMsgBox = new PageElement(msbSuccessMsgBoxXpath, ASSET_SUCCESS_MSG);
	PageElement deleteButton = new PageElement(deleteButtonId, null, InputType.BUTTON);
	
	/**
	 * Add a new Home evaluation asset
	 * 
	 */

	public void addHomeEvaluation() {
		logger.info("Inside addHomeEvaluation method in HomeEvaluationTabPage Class");
		browser.setElement(homeEvaluationTab);
		browser.setElement(findPropertyButton);
		browser.verifyText(noPropertyErrorMessage);
		browser.waitTillElementIsClickable(populateButton);
		browser.setElement(yearBuiltTextbox);
		browser.setElement(styleDropdown);
		browser.setElement(numberOfStoreysDropdown);
		browser.setElement(finishedLivingAreaTextbox);
		browser.setElement(populateButtonSelect);
		browser.verifyText(msbSuccessMsgBox);
		browser.setElement(constructionDropdown);
		browser.waitTillElementIsClickable(calculateBuildingValueButton);
		browser.setElement(calculateBuildingValueButton);
		browser.waitTillElementIsClickable(alertRCTDataStatusButton);
		browser.setElement(alertRCTDataStatusButtonSelect);
		browser.verifyText(verifiedDataStatus);
		browser.waitTillElementIsClickable(saveButtonSelect);
		browser.setElement(saveButtonSelect);
		browser.verifyText(assetSuccessMsgBox);
		browser.waitTillElementIsClickable(okButtonHomeSelect);
		browser.setElement(okButtonHomeSelect);
		browser.verifyText(assetSuccessMsgBox);
		browser.setElement(deleteButton);
	}
}
