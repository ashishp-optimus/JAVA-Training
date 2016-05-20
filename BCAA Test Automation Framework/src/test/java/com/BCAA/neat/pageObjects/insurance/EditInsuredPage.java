package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.PropertiesReader;

public class EditInsuredPage {

	Logger logger = Logger.getLogger(AddInsuredPage.class);
	private final static String INSURED_SUCCESS_MESSAGE = "Policy Insured has been saved successfully.";
	private final static String EDIT_INSURED = "Edit Insured";

	
	
	private By editInsuredPageXpath = By.xpath("//*[@id='policy_insured']/h2");
	private By creditInformationDropdownId = By.id("drpdwnEditInsuredCreditInformationConsentId");
	private By hasAnyInsurerCancelledDropdownId = By.id("drpdwnEditInsuredRefusedInsuranceId");
	private By occupationId = By.id("occupationDescription");
	private By okBtnId = By.id("btnEditInsuredOkId");
	private By successMsgbox = By.id("msgbox");
	private By deleteBtnId = By.id("btnInsuredsTabDeleteId");
	private By errorMsgBoxId = By.id("errorMsgBox");

	
	
	Button okBtn = new Button(okBtnId);
	Button deleteBtn = new Button(deleteBtnId);

	DropDown hasAnyInsurerCancelledDropdown = new DropDown(hasAnyInsurerCancelledDropdownId,
			PropertiesReader.readProperty("cancelledInsurer"));
	DropDown creditInformationDropdown = new DropDown(creditInformationDropdownId,
			PropertiesReader.readProperty("consentCreditInformation"));
	PageElement editInsuredPage = new PageElement(editInsuredPageXpath, EDIT_INSURED);
	PageElement successMessage = new PageElement(successMsgbox, INSURED_SUCCESS_MESSAGE);
	PageElement errorMsgBox = new PageElement(errorMsgBoxId);

	TextBox occupation = new TextBox(occupationId, PropertiesReader.readProperty("occuptationDescription"));

	public void editInsured() {
		logger.info("Inside editInsured method in InsuredsTabPage Class");
		Browser browser = new Browser();
		browser.verifyText(editInsuredPage);
		hasAnyInsurerCancelledDropdown.selectValue();
		occupation.enterTextInField();
		creditInformationDropdown.selectValue();
		okBtn.click();
		browser.verifyText(successMessage);
		deleteBtn.click();
		browser.waitForVisibility(errorMsgBox);

	}
}
