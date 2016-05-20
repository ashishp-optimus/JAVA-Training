package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.pageObjects.navigation.HomePage;
import com.BCAA.neat.pageObjects.navigation.InsurancePage;
import com.BCAA.neat.utils.PropertiesReader;

public class FindQuotesOrPolicyPage {
	Logger logger = Logger.getLogger(FindQuotesOrPolicyPage.class);

	private final static String SELECT_INSURANCE_PLAN_TEXT = "Select Insurance Plan";
	private final static String COPY_QUOTE_SUCESS_MESSAGE = "Successfully copied the quote.";
	private final static String CANCELLED_SUCESS_MESSAGE = "Policy is cancelled successfully. The following list shows the cancelled version.";
	private final static String VOID_POLICY_STATUS = "Void Policy - New";
	private String quotePolicyNo;

	private By memberNumberTextboxId = By.id("txtbxFindPolicyMemberNumberId");
	private By associateNumberTextboxId = By.id("txtbxFindPolicyAssociateNumberId");
	private By searchBtnId = By.id("btnFindPolicySearchId");
	private By createQuoteBtnId = By.id("btnFindPolicyCreateQuoteId");
	private By selectInsurancePlanTextXpath = By.xpath("//*[@id='selectInsurancePlan']/h2/span");
	private By searchQuotePolicyFieldId = By.id("txtbxFindPolicyQuoteOrPolicyNumberId");
	private By quotePolicyResultId = By.id("insuranceQuotePolicy_1_3");
	private By editQuoteBtnId = By.id("btnFindPolicyEditId");
	private By selectActivePolicyXpath = By.xpath("//td[contains(.,'Active Policy')]");
	private By endorsePolicyBtnId = By.id("btnFindPolicyEndorsePolicyId");
	private By copyQuotePolicyNumberId = By.id("insuranceQuotePolicy_1_2");
	private By copyQuoteBtnId = By.id("btnFindPolicyCopyQuoteId");
	private By msbSucessBoxID = By.id("msgbox");
	private By quotePolicyNumberAndVersionId = By.id("policyNumberAndVersion");
	private By selectInsurancePlanOkBtnId = By.id("btnSelectInsurancePlanOkId");
	private By voidPolicyStatusId = By.id("insuranceQuotePolicy_1_9");

	Button searchBtn = new Button(searchBtnId);
	Button createQuoteBtn = new Button(createQuoteBtnId);
	Button editQuoteBtn = new Button(editQuoteBtnId);
	Button selectActiveStatus = new Button(selectActivePolicyXpath);
	Button endorsePolicyBtn = new Button(endorsePolicyBtnId);
	Button policyNumberPage = new Button(copyQuotePolicyNumberId);
	Button copyQuoteTab = new Button(copyQuoteBtnId);
	Button selectInsurancePlanBtn = new Button(selectInsurancePlanOkBtnId);

	PageElement selectInsurancePlanText = new PageElement(selectInsurancePlanTextXpath, SELECT_INSURANCE_PLAN_TEXT);
	PageElement assetSuccessMsgBox = new PageElement(msbSucessBoxID, COPY_QUOTE_SUCESS_MESSAGE);
	PageElement retreivePolicy = new PageElement(quotePolicyNumberAndVersionId);
	PageElement cancelMsgBox = new PageElement(msbSucessBoxID, CANCELLED_SUCESS_MESSAGE);
	PageElement voidStatus = new PageElement(voidPolicyStatusId, VOID_POLICY_STATUS);
	PageElement quotePolicyResult;

	TextBox memberNumberTextbox = new TextBox(memberNumberTextboxId, PropertiesReader.readProperty("memberNumber"));
	TextBox associateNumberTextbox = new TextBox(associateNumberTextboxId,
			PropertiesReader.readProperty("associateNumber"));

	/**
	 * 
	 * To create a new Quote
	 */
	public void createQuote() {
		logger.info("Inside createQuote method in FindQuotesOrPolicyPage Class");

		Browser browser = new Browser();

		memberNumberTextbox.enterTextInField();
		associateNumberTextbox.enterTextInField();

		createQuoteBtn.click();

		browser.verifyText(selectInsurancePlanText);
	}

	/**
	 * 
	 * To search a newly created draft quote with Policy/Quote ID
	 */
	public void searchQuotePolicy() {
		logger.info("Inside searchQuotePolicy method in FindQuotesOrPolicyPage Class");

		Browser browser = new Browser();
		HomePage homePage = new HomePage();
		InsurancePage insurancePage = new InsurancePage();
		SelectInsurancePlanPage selectInsurancePlan = new SelectInsurancePlanPage();
		EditQuotesOrPolicyPage quotePolicyNumber = new EditQuotesOrPolicyPage();

		homePage.selectInsuranceTab();
		insurancePage.navigateToQuotesAndPoliciesTab();
		createQuote();
		selectInsurancePlan.selectInsurancePlan();
		quotePolicyNo = quotePolicyNumber.retrieveQuoteNumber().toString();
		homePage.selectInsuranceTab();
		insurancePage.navigateToQuotesAndPoliciesTab();

		TextBox searchQuotePolicyField = new TextBox(searchQuotePolicyFieldId, quotePolicyNo);
		quotePolicyResult = new PageElement(quotePolicyResultId, quotePolicyNo);

		searchQuotePolicyField.enterTextInField();
		searchBtn.click();
		browser.waitForVisibility(quotePolicyResult);
	}

	/**
	 * 
	 * To search an quote with Policy/Quote ID
	 * 
	 * @param quoteNumber
	 *            The quote number to be searched
	 */

	public void searchQuotePolicywithQuoteNumber(PageElement pageElementObj) {
		logger.info("Inside searchQuotePolicywithQuoteNumber method in FindQuotesOrPolicyPage Class");

		TextBox searchQuotePolicyField = new TextBox(searchQuotePolicyFieldId, pageElementObj.getOutValue());
		searchQuotePolicyField.enterTextInField();
		searchBtn.click();
		// browser.waitForVisibility(selectActiveStatus);
		// browser.setElement(selectActiveStatus);
		// browser.setElement(endorsePolicyBtn);
	}

	/**
	 * 
	 */
	public void selectActivePolicy() {
		logger.info("Inside selectActivePolicy method in FindQuotesOrPolicyPage Class");

		Browser browser = new Browser();

		browser.waitForVisibility(selectActiveStatus);
		selectActiveStatus.click();
	}

	/**
	 * Click on Endorse Policy Button, when you have already selected Active
	 * policy
	 */
	public void clickOnEndorsePolicyBtn() {
		logger.info("Inside clickOnEndorsePolicyBtn method in FindQuotesOrPolicyPage Class");

		endorsePolicyBtn.click();
	}

	/**
	 * Click on Edit Button, when you have already selected Find Results
	 */
	public void clickEditBtn() {
		logger.info("Inside clickEditBtn method in FindQuotesOrPolicyPage Class");

		editQuoteBtn.click();
	}

	/**
	 * To search an quote with Policy for Copy Quote The Quote number for
	 * committed quote to be searched
	 */
	public void searchCopiedPolicy() {
		logger.info("Inside searchCopiedPolicy method in FindQuotesOrPolicyPage Class");

		Browser browser = new Browser();

		PageElement pageElementObj = browser.retreiveQuote(retreivePolicy);
		searchQuotePolicywithQuoteNumber(pageElementObj);
	}

	/**
	 * To select the Copy Quote option for a policy
	 * 
	 */
	public void copyQuote() {
		logger.info("Inside copy quote method in FindQuotesOrPolicyPage Class");

		Browser browser = new Browser();

		policyNumberPage.click();
		copyQuoteTab.click();
		browser.verifyText(assetSuccessMsgBox);
		selectInsurancePlanBtn.click();
	}

	/**
	 * To verify message when cancelling a policy
	 */
	public void verifyCancelledMessage() {
		logger.info("Inside verifyCancelledMessage method in FindQuotesOrPolicyPage Class");
		Browser browser = new Browser();

		browser.verifyText(cancelMsgBox);
	}

	/**
	 * To verify status of a voided policy
	 */
	public void verifyVoidPolicyStatus() {
		logger.info("Inside verifyVoidPolicyStatus method in FindQuotesOrPolicyPage Class");
		Browser browser = new Browser();

		browser.verifyText(voidStatus);
	}

}
