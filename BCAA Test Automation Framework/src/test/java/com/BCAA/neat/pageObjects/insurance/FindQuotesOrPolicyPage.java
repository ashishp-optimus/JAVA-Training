package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.pageObjects.navigation.HomePage;
import com.BCAA.neat.pageObjects.navigation.InsurancePage;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;

public class FindQuotesOrPolicyPage {
	Logger logger = Logger.getLogger(FindQuotesOrPolicyPage.class);
	Browser browser = new Browser();

	private final String SELECT_INSURANCE_PLAN_PAGE_TEXT = "Select Insurance Plan";
	private String quotePolicyNo;
	private final String COPY_QUOTE_SUCESS_MESSAGE="Successfully copied the quote.";
	private final String CANCELLED_SUCESS_MESSAGE="Policy is cancelled successfully. The following list shows the cancelled version.";
	private final String VOID_POLICY_STATUS="Void Policy - New";

	By memberNumberFieldId = By.id("txtbxFindPolicyMemberNumberId");
	By associateNumberFieldId = By.id("txtbxFindPolicyAssociateNumberId");
	By searchButtonId = By.id("btnFindPolicySearchId");
	By createQuoteButtonId = By.id("btnFindPolicyCreateQuoteId");
	By selectInsurancePlanTextXpath = By.xpath("//*[@id='selectInsurancePlan']/h2/span");
	By searchQuotePolicyFieldId = By.id("txtbxFindPolicyQuoteOrPolicyNumberId");
	By quotePolicyResultId = By.id("insuranceQuotePolicy_1_3");
	By editQuoteButtonId = By.id("btnFindPolicyEditId");
	By selectActivePolicy = By.xpath("//td[contains(.,'Active Policy')]");
	By endorsePolicy = By.id("btnFindPolicyEndorsePolicyId");
	By copyQuotePolicyNumber=By.id("insuranceQuotePolicy_1_2");
	By copyQuoteTabID=By.id("btnFindPolicyCopyQuoteId");
	By msbsucessboxID=By.id("msgbox");
	By quotePolicyNumberAndVersion =By.id("policyNumberAndVersion");
	By selectInsurancePlanOkId=By.id("btnSelectInsurancePlanOkId");
	By voidPolicyStatus = By.id("insuranceQuotePolicy_1_9");



	PageElement memberNumber = new PageElement(memberNumberFieldId, PropertiesReader.readProperty("memberNumber"),
			InputType.TEXT_BOX);
	PageElement associateNumber = new PageElement(associateNumberFieldId,
			PropertiesReader.readProperty("associateNumber"), InputType.TEXT_BOX);
	PageElement searchButton = new PageElement(searchButtonId, null, InputType.BUTTON);
	PageElement createQuoteButton = new PageElement(createQuoteButtonId, null, InputType.BUTTON);
	PageElement selectInsurancePlanText = new PageElement(selectInsurancePlanTextXpath,
			SELECT_INSURANCE_PLAN_PAGE_TEXT);
	PageElement searchQuotePolicyField;
	PageElement quotePolicyResult;
	PageElement editQuoteButton = new PageElement(editQuoteButtonId, null, InputType.BUTTON);
	PageElement selectActiveStatus = new PageElement(selectActivePolicy, null, InputType.BUTTON);
	PageElement endorsePolicyBtn = new PageElement(endorsePolicy, null, InputType.BUTTON);
	PageElement policyNumberPage = new PageElement(copyQuotePolicyNumber, null, InputType.BUTTON);
	PageElement copyQuoteTab = new PageElement(copyQuoteTabID, null, InputType.BUTTON);
	PageElement assetSuccessMsgBox = new PageElement(msbsucessboxID, COPY_QUOTE_SUCESS_MESSAGE);
	PageElement retreivePolicy=new PageElement(quotePolicyNumberAndVersion);
	PageElement selectInsurancePlan=new PageElement(selectInsurancePlanOkId, null, InputType.BUTTON);
	PageElement cancelMsgBox = new PageElement(msbsucessboxID, CANCELLED_SUCESS_MESSAGE);
	PageElement voidStatus = new PageElement(voidPolicyStatus, VOID_POLICY_STATUS);


	/**
	 * 
	 * To create a new Quote
	 */
	public void createQuote() {
		logger.info("Inside createQuote method in FindQuotesOrPolicyPage Class");
		
		browser.setElement(memberNumber);
		browser.setElement(associateNumber);
		browser.setElement(createQuoteButton);
		
		browser.verifyText(selectInsurancePlanText);
	}

	/**
	 * 
	 * To search a newly created draft quote with Policy/Quote ID
	 */
	public void searchQuotePolicy() {
		logger.info("Inside searchQuotePolicy method in FindQuotesOrPolicyPage Class");
		
		HomePage homePage = new HomePage();
		InsurancePage insurancePage = new InsurancePage();
		SelectInsurancePlanPage selectInsurancePlan = new SelectInsurancePlanPage();
		EditQuotesOrPolicyPage quotePolicyNumber = new EditQuotesOrPolicyPage();

		homePage.selectInsurance();
		insurancePage.quotesAndPoliciesTab();
		
		createQuote();
		
		selectInsurancePlan.selectInsurancePlan();
		quotePolicyNo = quotePolicyNumber.retrieveQuoteNumber();
		homePage.selectInsurance();
		insurancePage.quotesAndPoliciesTab();
		
		searchQuotePolicyField = new PageElement(searchQuotePolicyFieldId, quotePolicyNo, InputType.TEXT_BOX);
		quotePolicyResult = new PageElement(quotePolicyResultId, quotePolicyNo);
		
		browser.setElement(searchQuotePolicyField);
		browser.setElement(searchButton);
		browser.waitForVisibility(quotePolicyResult);
		//browser.verifyText(quotePolicyResult);
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
		HomePage homePage = new HomePage();
		InsurancePage insurancePage = new InsurancePage();
		homePage.selectInsurance();
		insurancePage.quotesAndPoliciesTab();
		
		searchQuotePolicyField = new PageElement(searchQuotePolicyFieldId, pageElementObj.getOutValue(), InputType.TEXT_BOX);
		browser.setElement(searchQuotePolicyField);
		browser.setElement(searchButton);
		//browser.waitForVisibility(selectActiveStatus);
		//browser.setElement(selectActiveStatus);
		//browser.setElement(endorsePolicyBtn);
	}
	/**
	 * 
	 */
	public void selectActivePolicy() {
		browser.waitForVisibility(selectActiveStatus);
		browser.setElement(selectActiveStatus);
	}
	
	/**
	 * Click on Endorse Policy Button, when you have already selected Active policy
	 */
	public void clickOnEndorsePolicyBtn() {
		browser.setElement(endorsePolicyBtn);
	}
	
	/**
	 * Click on Edit Button, when you have already selected Find Results
	 */
	public void clickEditBtn() {
		browser.setElement(editQuoteButton);
	}
	
	
	
	/**
	 * To search an quote with Policy for Copy Quote
	 *   The Quote number for committed quote to be searched
	 */
	public void searchCopiedPolicy()
	{
		logger.info("Inside searchCopiedPolicy method in FindQuotesOrPolicyPage Class");
		PageElement pageElementObj = browser.retreiveQuote(retreivePolicy);
		searchQuotePolicywithQuoteNumber(pageElementObj);
	}
	
	/**
	 * To select the Copy Quote option for a policy
	 * 
	 */
	public void copyQuote()
	{
		logger.info("Inside copy quote method in FindQuotesOrPolicyPage Class");
		
		browser.setElement(policyNumberPage);
		browser.setElement(copyQuoteTab);
		browser.verifyText(assetSuccessMsgBox);
		browser.setElement(selectInsurancePlan);
	}
	
	/**
	 * 
	 */
	public void verifyCancelledMessage() {
		browser.verifyText(cancelMsgBox);
	}
	
	/**
	 * 
	 */
	public void verifyVoidPolicyStatus() {
		browser.verifyText(voidStatus);
	}

}
