package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is for Add Or Delete External Claim
 * 
 * @author Optimus
 */
public class AddOrDeleteExternalClaimPage {

	Logger logger = Logger.getLogger(AddOrDeleteExternalClaimPage.class);

	private final static String ADD_EXTERNAL_CLAIM = "Add External Claim";
	private final static String EXTERNAL_CLAIMS_SUCCESS_MSG = "External Policy Claim has been added successfully.";
	private By verifyAddExternalClaimXpath = By.xpath("//*[@id='External_Claim']/h2/span");
	private By policyNumberTextboxId = By.id("txtbxAddExternalClaimPolicyNumberId");
	private By insurerTextboxId = By.id("txtbxAddExternalClaimInsurerId");
	private By showlossDateId = By.id("showlossDate");
	private By showcalenderXpath = By.xpath("//td[contains(@class,'today selectable')]");
	private By addExternalClaimLossTypeDropdownId = By.id("drpdwnAddExternalClaimLossTypeId");
	private By addExternalClientClaimEstimateTextboxId = By.id("txtbxAddExternalClaimClientEstimateId");
	private By claimStatusLookUpCodeDropdownId = By.id("claimStatusLookupCodeField");
	private By insurerBcaaTypeCodeDropdownId = By.id("insBcaaTypeCodeField");
	private By hbbLossTypeCodeDropdownId = By.id("hbbLossTypeCodeField");
	private By addExternalClaimBtnOkId = By.id("btnAddExternalClaimOKId");
	private By addExternalClaimSummaryTextboxId = By.id("txtbxAddExternalClaimSummaryId");
	private By claimsMessageBoxId = By.id("msgbox");
	

	
	Button showLossDate = new Button(showlossDateId);
	Button currentDateInCalendar = new Button(showcalenderXpath);
	Button addExternalClaimBtnOk = new Button(addExternalClaimBtnOkId);
	
	DropDown externalLossTypeDropdown = new DropDown(addExternalClaimLossTypeDropdownId,
			PropertiesReader.readProperty("selectLossType"));
	DropDown claimStatusLookUpCodeDropdown = new DropDown(claimStatusLookUpCodeDropdownId,
			PropertiesReader.readProperty("selectClaimStatusLookUpField"));
	DropDown insurerBcaaTypeCodeDropdown = new DropDown(insurerBcaaTypeCodeDropdownId,
			PropertiesReader.readProperty("selectInsurerBcaaTypeCodeField"));
	DropDown hbbLossTypeCodeDropdown = new DropDown(hbbLossTypeCodeDropdownId,
			PropertiesReader.readProperty("selectHbbLossTypeCodeField"));

	PageElement verifyAddExternalClaim = new PageElement(verifyAddExternalClaimXpath, ADD_EXTERNAL_CLAIM);
	PageElement verifyExternalClaimsMessage = new PageElement(claimsMessageBoxId, EXTERNAL_CLAIMS_SUCCESS_MSG);
	
	TextBox policyNumberTextbox = new TextBox(policyNumberTextboxId, PropertiesReader.readProperty("policyNumber"));
	TextBox insurerTextbox = new TextBox(insurerTextboxId, PropertiesReader.readProperty("insurer"));
	TextBox externalClaimClientEstimateTextbox = new TextBox(addExternalClientClaimEstimateTextboxId,
			PropertiesReader.readProperty("externalClaimClientEstimate"));
	TextBox addExternalClaimSummaryTextbox = new TextBox(addExternalClaimSummaryTextboxId,
			PropertiesReader.readProperty("AddExternalClaimSummary"));
	

	/**
	 * To create an external claim
	 */
	public void createExternalClaim() {
		logger.info("Create External Claim method in ClaimsTabPage Class");
		Browser browser = new Browser();
		browser.verifyText(verifyAddExternalClaim);
		policyNumberTextbox.enterTextInField();
		insurerTextbox.enterTextInField();
		showLossDate.click();
		currentDateInCalendar.click();
		externalLossTypeDropdown.selectValue();
		externalClaimClientEstimateTextbox.enterTextInField();
		claimStatusLookUpCodeDropdown.selectValue();
		insurerBcaaTypeCodeDropdown.selectValue();
		hbbLossTypeCodeDropdown.selectValue();
		addExternalClaimSummaryTextbox.enterTextInField();
		addExternalClaimBtnOk.click();
		browser.verifyText(verifyExternalClaimsMessage);
	}
}
