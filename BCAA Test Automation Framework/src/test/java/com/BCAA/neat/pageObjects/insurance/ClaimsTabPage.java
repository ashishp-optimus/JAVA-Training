package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is for Claims Tab Page
 * 
 * @author Optimus
 */

public class ClaimsTabPage {
	Logger logger = Logger.getLogger(ClaimsTabPage.class);

	private final String ADD_EXTERNAL_CLAIM = "Add External Claim";
	private final String EXTERNAL_CLAIMS_SUCCESS_MSG = "External Policy Claim has been added successfully.";
	private final String CLAIM_DELETE_SUCCESS_MSG = "Claim has been deleted successfully.";

	By claimsTabId = By.id("ClaimsTab_lnk");
	By addExternalClaimBtnId = By.id("btnClaimsTabAddExternalClaimId");
	By verifyAddExternalClaimXpath = By.xpath("//*[@id='External_Claim']/h2/span");
	By policyNumberTextboxId = By.id("txtbxAddExternalClaimPolicyNumberId");
	By insurerTextboxId = By.id("txtbxAddExternalClaimInsurerId");
	By showlossDateId = By.id("showlossDate");
	By showcalenderXpath = By.xpath("//td[contains(@class,'today selectable')]");
	By addExternalClaimLossTypeDropdownId = By.id("drpdwnAddExternalClaimLossTypeId");
	By addExternalClientClaimEstimateTextboxId = By.id("txtbxAddExternalClaimClientEstimateId");
	By claimStatusLookUpCodeDropdownId = By.id("claimStatusLookupCodeField");
	By insurerBcaaTypeCodeDropdownId = By.id("insBcaaTypeCodeField");
	By hbbLossTypeCodeDropdownId = By.id("hbbLossTypeCodeField");
	By addExternalClaimBtnOkId = By.id("btnAddExternalClaimOKId");
	By addExternalClaimSummaryTextboxId = By.id("txtbxAddExternalClaimSummaryId");
	By claimsMessageBoxId = By.id("msgbox");
	By selectpolicyClaimId = By.id("policyClaim_1_1");
	By deleteExternalClaimsBtnId = By.id("btnClaimsTabDeleteExternalClaimId");

	PageElement claimsTab = new PageElement(claimsTabId, null, InputType.BUTTON);
	PageElement addExternalClaimBtn = new PageElement(addExternalClaimBtnId, null, InputType.BUTTON);
	PageElement verifyAddExternalClaim = new PageElement(verifyAddExternalClaimXpath, ADD_EXTERNAL_CLAIM);
	PageElement policyNumberTextbox = new PageElement(policyNumberTextboxId,
			PropertiesReader.readProperty("policyNumber"), InputType.TEXT_BOX);
	PageElement insurerTextbox = new PageElement(insurerTextboxId, PropertiesReader.readProperty("insurer"),
			InputType.TEXT_BOX);
	PageElement showLossDate = new PageElement(showlossDateId, null, InputType.BUTTON);
	PageElement currentDateInCalendar = new PageElement(showcalenderXpath, null, InputType.BUTTON);
	PageElement externalLossTypeDropdown = new PageElement(addExternalClaimLossTypeDropdownId,
			PropertiesReader.readProperty("selectLossType"), InputType.DROPDOWN);
	PageElement externalClaimClientEstimateTextbox = new PageElement(addExternalClientClaimEstimateTextboxId,
			PropertiesReader.readProperty("externalClaimClientEstimate"), InputType.TEXT_BOX);
	PageElement claimStatusLookUpCodeDropdown = new PageElement(claimStatusLookUpCodeDropdownId,
			PropertiesReader.readProperty("selectClaimStatusLookUpField"), InputType.DROPDOWN);
	PageElement insurerBcaaTypeCodeDropdown = new PageElement(insurerBcaaTypeCodeDropdownId,
			PropertiesReader.readProperty("selectInsurerBcaaTypeCodeField"), InputType.DROPDOWN);
	PageElement hbbLossTypeCodeDropdown = new PageElement(hbbLossTypeCodeDropdownId,
			PropertiesReader.readProperty("selectHbbLossTypeCodeField"), InputType.DROPDOWN);
	PageElement addExternalClaimSummaryTextbox = new PageElement(addExternalClaimSummaryTextboxId,
			PropertiesReader.readProperty("AddExternalClaimSummary"), InputType.TEXT_BOX);
	PageElement addExternalClaimBtnOk = new PageElement(addExternalClaimBtnOkId, null, InputType.BUTTON);
	PageElement verifyExternalClaimsMessage = new PageElement(claimsMessageBoxId, EXTERNAL_CLAIMS_SUCCESS_MSG);
	PageElement selectpolicyClaim = new PageElement(selectpolicyClaimId, null, InputType.BUTTON);
	PageElement deleteExternalClaims = new PageElement(deleteExternalClaimsBtnId, null, InputType.BUTTON);
	PageElement verifyClaimDeleteMessage = new PageElement(claimsMessageBoxId, CLAIM_DELETE_SUCCESS_MSG);

	/**
	 * Navigate to Claims tab
	 */

	public void claimsTab() {
		logger.info("Inside claims Tab method in ClaimsTabPage Class");

		Button button = new Button();
		button.click(claimsTab);
	}

	/**
	 * To create an external claim
	 */

	public void createExternalClaim() {
		logger.info("Create External Claim method in ClaimsTabPage Class");

		Button button = new Button();
		TextBox textbox = new TextBox();
		DropDown dropdown = new DropDown();
		Browser browser = new Browser();

		button.click(addExternalClaimBtn);
		browser.verifyText(verifyAddExternalClaim);

		textbox.enterTextInField(policyNumberTextbox);
		textbox.enterTextInField(insurerTextbox);

		button.click(showLossDate);
		button.click(currentDateInCalendar);

		dropdown.selectValue(externalLossTypeDropdown);

		textbox.enterTextInField(externalClaimClientEstimateTextbox);

		dropdown.selectValue(claimStatusLookUpCodeDropdown);
		dropdown.selectValue(insurerBcaaTypeCodeDropdown);
		dropdown.selectValue(hbbLossTypeCodeDropdown);

		textbox.enterTextInField(addExternalClaimSummaryTextbox);

		button.click(addExternalClaimBtnOk);
		browser.verifyText(verifyExternalClaimsMessage);

	}

	/**
	 * To delete an external claim
	 */
	
	public void deleteExternalClaim() {
		logger.info("Delete External Claims in ClaimsTabPage Class");

		Button button = new Button();
		Browser browser = new Browser();

		button.click(selectpolicyClaim);
		button.click(deleteExternalClaims);

		browser.acceptAlertButton();
		browser.verifyText(verifyClaimDeleteMessage);
	}
}
