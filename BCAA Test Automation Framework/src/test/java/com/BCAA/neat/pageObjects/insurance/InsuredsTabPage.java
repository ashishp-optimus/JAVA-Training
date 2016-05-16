package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;

public class InsuredsTabPage {
	Logger logger = Logger.getLogger(InsuredsTabPage.class);
	Browser browser = new Browser();

	private final String INSURED_SUCCESS_MESSAGE = "Policy Insured has been saved successfully.";
	private final String INSURED_MEMBER_LIST = "Peterson Best, Ervian Shoei Western";
	private final String EDIT_INSURED = "Edit Insured";
	private final String RETREIVE_CLIENTMEMBER = "Retrieve Client/Member";

	By insuredTabId = By.id("InsuredsTab_lnk");
	By selectUserToEditId = By.id("policyInsured_1_2");
	By editButtonId = By.id("btnInsuredsTabEditId");
	By editInsuredPageXpath = By.xpath("//*[@id='policy_insured']/h2");
	By creditInformationDropdownId = By.id("drpdwnEditInsuredCreditInformationConsentId");
	By hasAnyInsurerCancelledDropdownId = By.id("drpdwnEditInsuredRefusedInsuranceId");
	By occupationId = By.id("occupationDescription");
	By okButtonId = By.id("btnEditInsuredOkId");
	By successMsgbox = By.id("msgbox");
	By retrieveClientMemberButtonId = By.id("btnInsuredsTabRetrieveClientOrMemberId");
	By retrieveClientMemberCheckboxId = By.id("chkbxRetrieveClientOrMemberMember1Id");
	By retreiveClientMemberOkButtonId = By.id("btnRetrieveClientOrMemberOKId");
	By retreiveClientMemberPageTextXpath = By.xpath("//*[@id='findPolicyMember']/h2/span");
	By deleteButtonId = By.id("btnInsuredsTabDeleteId");
	By errorMsgBoxId = By.id("errorMsgBox");

	PageElement insuredTab = new PageElement(insuredTabId, null, InputType.BUTTON);
	PageElement selectUserToEdit = new PageElement(selectUserToEditId, null, InputType.BUTTON);
	PageElement editButton = new PageElement(editButtonId, null, InputType.BUTTON);
	PageElement editInsuredPage = new PageElement(editInsuredPageXpath, EDIT_INSURED);
	PageElement hasAnyInsurerCancelledDropdown = new PageElement(hasAnyInsurerCancelledDropdownId,
			PropertiesReader.readProperty("cancelledInsurer"), InputType.DROPDOWN);
	PageElement occupation = new PageElement(occupationId, PropertiesReader.readProperty("occuptationDescription"),
			InputType.TEXT_BOX);
	PageElement creditInformationDropdown = new PageElement(creditInformationDropdownId,
			PropertiesReader.readProperty("consentCreditInformation"), InputType.DROPDOWN);
	PageElement okButton = new PageElement(okButtonId, null, InputType.BUTTON);
	PageElement successMessage = new PageElement(successMsgbox, INSURED_SUCCESS_MESSAGE);
	PageElement deleteButton = new PageElement(deleteButtonId, null, InputType.BUTTON);
	PageElement retrieveClientMemberButton = new PageElement(retrieveClientMemberButtonId, null, InputType.BUTTON);
	PageElement retreiveClientMemberPageText = new PageElement(retreiveClientMemberPageTextXpath,
			RETREIVE_CLIENTMEMBER);
	PageElement checkRetrieveClientMember = new PageElement(retrieveClientMemberCheckboxId, null,
			InputType.CHECK_CHECKBOX);
	PageElement retreiveClientMemberOk=new PageElement(retreiveClientMemberOkButtonId, null, InputType.BUTTON);
	PageElement insuredMember = new PageElement(selectUserToEditId, INSURED_MEMBER_LIST);
	PageElement errorMsgBox = new PageElement(errorMsgBoxId);

	/**
	 * To navigate to Insured tab
	 */

	public void insuredTab() {
		logger.info("Inside insuredTab method in InsuredsTabPage Class");
		browser.setElement(insuredTab);
	}

	/**
	 * To edit an insured user of a policy
	 */


	public void editInsured()  {
		logger.info("Inside editInsured method in InsuredsTabPage Class");
		browser.setElement(selectUserToEdit);
		browser.setElement(editButton);
		browser.verifyText(editInsuredPage);
		browser.setElement(hasAnyInsurerCancelledDropdown);
		browser.setElement(occupation);
		browser.setElement(creditInformationDropdown);
		browser.setElement(okButton);
		browser.verifyText(successMessage);
		browser.setElement(deleteButton);
		browser.waitForVisibility(errorMsgBox);

	}

	/**
	 * To add a new insured user under a policy
	 */
	public void addInsured() {
		logger.info("Inside addInsured method in InsuredsTabPage Class");
		browser.setElement(selectUserToEdit);
		browser.setElement(retrieveClientMemberButton);
		browser.verifyText(retreiveClientMemberPageText);
		browser.setElement(checkRetrieveClientMember);
		browser.setElement(retreiveClientMemberOk);
		browser.verifyText(insuredMember);
	}
}
