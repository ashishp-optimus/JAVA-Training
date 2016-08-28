package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.Table;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.PropertiesReader;

public class EditInsuredPage {
	Logger logger;
	Browser browser;

	public EditInsuredPage() {
		logger = Logger.getLogger(AddInsuredPage.class);
		browser = new Browser();
	}

	private final static String EDIT_INSURED = "Edit Insured";

	private By editButtonId = By.id("btnInsuredsTabEditId");
	private By selectUserToEditId = By.id("policyInsured_1_2");
	private By editInsuredPageXpath = By.xpath("//*[@id='policy_insured']/h2");
	private By creditInformationDropdownId = By.id("drpdwnEditInsuredCreditInformationConsentId");
	private By hasAnyInsurerCancelledDropdownId = By.id("drpdwnEditInsuredRefusedInsuranceId");
	private By occupationId = By.id("occupationDescription");
	private By okBtnId = By.id("btnEditInsuredOkId");
	private By primaryPolicyHolderXpath = By.xpath(".//input[@name='primaryPolicyHolderFlag']");
	private By verifyPrimaryInsured = By
			.xpath(".//td[contains(.,'-02')]/following-sibling::td/child::input[@checked='']");
	//private By verifyNonPrimaryInsured = By.xpath(".//td[contains(.,'-01')]/following-sibling::td/child::input");
	private By verifyNonPrimaryInsured = By.xpath("//div[@id='policyInsured']/table/tbody/tr");
	


	Button selectUserToEdit = new Button(selectUserToEditId);
	Button editButton = new Button(editButtonId);
	Button okBtn = new Button(okBtnId);

	CheckBox primaryPolicyHolder = new CheckBox(primaryPolicyHolderXpath);
	Table primaryInsured =new Table(verifyNonPrimaryInsured, "-02");
	Table nonPrimaryInsured =new Table(verifyNonPrimaryInsured, "-01");

	DropDown hasAnyInsurerCancelledDropdown = new DropDown(hasAnyInsurerCancelledDropdownId,
			PropertiesReader.readProperty("cancelledInsurer"));
	DropDown creditInformationDropdown = new DropDown(creditInformationDropdownId,
			PropertiesReader.readProperty("consentCreditInformation"));
	
	TextBox occupation = new TextBox(occupationId, PropertiesReader.readProperty("occuptationDescription"));
	TextBox editInsuredPage = new TextBox(editInsuredPageXpath, EDIT_INSURED);

	/**
	 * To edit insured user
	 */
	public void editInsuredDetails() {
		logger.info("Inside editInsured method in InsuredsTabPage Class");

		hasAnyInsurerCancelledDropdown.selectValue();
		occupation.enterTextInField();
		creditInformationDropdown.selectValue();
		okBtn.click();
	}

	/**
	 * To set an insured as a primary holder
	 */

	public void setInsuredAsPrimaryHolder() {
		logger.info("Setting user as Primary holder under InsuredsTabPage Class");

		primaryPolicyHolder.selectCheckbox();
	}

	/**
	 * Verify Edit Insured text in the header
	 */
	public void verifyEditInsuredText() {
		logger.info("Verify Edit Insured header text under InsuredsTabPage Class");

		editInsuredPage.verifyText();
	}

	/**
	 * Verify the primary and non-primary holder of a policy
	 */
	public void verifyPrimaryNonPrimaryHolders() {
		logger.info("Verify primary holder is the edited user under InsuredsTabPage Class");

		if(! primaryInsured.verifyCheckBoxChecked()) {
			Assert.fail();
		}
		if(! nonPrimaryInsured.verifyCheckBoxUnChecked()) {
			Assert.fail();
		}
	}

}
