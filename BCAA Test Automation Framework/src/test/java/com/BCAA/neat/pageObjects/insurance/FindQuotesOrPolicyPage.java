package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.Table;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is for Find Quotes and Policy page
 * 
 * @author Optimus
 */

public class FindQuotesOrPolicyPage {
	Logger logger;
	Browser browser;

	DataBaseConnection databaseConnection = new DataBaseConnection();;
	private Map<String, String> findQuotesPolicyData = databaseConnection.getDatabase().getPageCollectionsAsMap("FINDQUOTESORPOLICYPAGE");


	public FindQuotesOrPolicyPage() {
		logger = Logger.getLogger(FindQuotesOrPolicyPage.class);
		browser = new Browser();
	}
	
	private final static String VOID_POLICY_STATUS_KEY = "voidpolicystatus";
	private final static String MEMBER_NUMBER_KEY = "membernumber";
	private final static String ACTIVE_NEW_STATUS_KEY = "activepolicynewstatus";
	private final static String ASSOCIATE_NUMBER_KEY = "associatenumber";
	private final static String CANCELLED_SUCESS_MESSAGE_KEY = "cancelledsuccessmessage";
	private final static String ACTIVE_ENDORSED_STATUS_KEY = "activepolicyendorsestatus";
	
	private final static String ACTIVE_RENEWAL_POLICY ="Active Policy - Renewal";
	private final static String DRAFT_QUOTE_RENEWAL ="Draft Quote - Renewal";
	private final static String CANCELLED_POLICY = "Cancelled Policy - Cancelled";
	private final static String ACTIVE_POLICY_ENDORSE = "Active Policy - Endorsement";
	private final static String STR_CONTAINS_OPEN_BRACE = "(//tr/td[contains(.,'";
	private final static String CLOSE_BRACES = "')])[1]";
	private final static String FIRST_NAME = "firstName";
	private final static String LAST_NAME = "lastName";
	private final static String ASSOCIATE_NUMBER = "associateNumber";
	private final static String MEMBER_NUMBER = "memberNumber";
	private final static String POLICY_NUMBER="9416789-01";
	private String quotePolicyNo;

	private By memberNumberTextboxId = By.id("txtbxFindPolicyMemberNumberId");
	private By numberTextboxId = By.id("txtbxFindPolicyAssociateNumberId");
	private By searchBtnId = By.id("btnFindPolicySearchId");
	private By createQuoteBtnId = By.id("btnFindPolicyCreateQuoteId");
	private By searchQuotePolicyFieldId = By.id("txtbxFindPolicyQuoteOrPolicyNumberId");
	private By quotePolicyResultId = By.id("insuranceQuotePolicy_1_3");
	private By editQuoteBtnId = By.id("btnFindPolicyEditId");
	private By findResultTableXpath = By.xpath("//div[@id='dg_search_find_quote_policy_list']/div/table/tbody/tr");
	private By endorsePolicyBtnId = By.id("btnFindPolicyEndorsePolicyId");
	private By copyQuotePolicyNumberXpath=By.xpath("//div[@id='insuranceQuotePolicy']/table/tbody/tr");
	private By copyQuoteBtnId = By.id("btnFindPolicyCopyQuoteId");
	private By msbSucessBoxID = By.id("msgbox");
	private By quotePolicyNumberAndVersionId = By.id("policyNumberAndVersion");
	private By reinstatePolicy = By.xpath("//input[contains(@value,'Reinstate Policy')]");	
	private By lastNameXpath=By.xpath(".//input[@name='lastName']");
	private By firstNameXpath=By.xpath(".//input[@name='firstName']");
	private By firstAndLastNameId=By.id("insuranceQuotePolicy_1_2");
	private By searchPolicyMemberID=By.id("insuranceQuotePolicy_1_1");
	private By quoteNumberId = By.id("policyNumberAndVersion");
	private By activeRenewalXpath = By.xpath("//input[contains(@value,'Renew Policy')]");

	
	private Button searchBtn = new Button(searchBtnId);
	private Button createQuoteBtn = new Button(createQuoteBtnId);
	private Button editQuoteBtn = new Button(editQuoteBtnId);
	private Button endorsePolicyBtn = new Button(endorsePolicyBtnId);
	private Button copyQuoteTab = new Button(copyQuoteBtnId);
	private Button quotePolicySearchResult = new Button(quotePolicyResultId);
	private Button reinstatePolicyBtn = new Button(reinstatePolicy);
	private Button activeRenewalBtn = new Button(activeRenewalXpath);
	

	private Table selectActiveStatus = new Table(findResultTableXpath, findQuotesPolicyData.get(ACTIVE_NEW_STATUS_KEY));
	private Table selectCancelledStatus = new Table(findResultTableXpath, CANCELLED_POLICY);
	private Table selectActiveEndorse = new Table(findResultTableXpath, findQuotesPolicyData.get(ACTIVE_ENDORSED_STATUS_KEY));
	private Table selectActiveRenewal = new Table(findResultTableXpath, ACTIVE_RENEWAL_POLICY);
	private Table selectDraftQuoteRenewal = new Table(findResultTableXpath, DRAFT_QUOTE_RENEWAL);
	private Table voidStatus = new Table(findResultTableXpath, findQuotesPolicyData.get(VOID_POLICY_STATUS_KEY));
	private Table verifyCancelledStatus = new Table(findResultTableXpath, CANCELLED_POLICY);
	private Table activePolicyEndorsement = new Table(findResultTableXpath, ACTIVE_POLICY_ENDORSE);
	private Table selectPolicyMember=new Table(copyQuotePolicyNumberXpath, POLICY_NUMBER);
	
	private TextBox retreivePolicy = new TextBox(quotePolicyNumberAndVersionId);
	private TextBox quotePolicyResult;
	private TextBox fullName=new TextBox(firstAndLastNameId);
	private TextBox insuranceQuotePolicy=new TextBox(searchPolicyMemberID);
	private TextBox quoteNumber = new TextBox(quoteNumberId);	
	private TextBox memberNumberTextbox = new TextBox(memberNumberTextboxId, findQuotesPolicyData.get(MEMBER_NUMBER_KEY));
	private TextBox associateNumberTextbox = new TextBox(numberTextboxId, findQuotesPolicyData.get(ASSOCIATE_NUMBER_KEY));
	private TextBox nonAssociateNumberTextbox = new TextBox(numberTextboxId,
			PropertiesReader.readProperty("nonAssociateNumber"));	
	private TextBox cancelMsgBox = new TextBox(msbSucessBoxID, CANCELLED_SUCESS_MESSAGE_KEY);


	/**
	 * 
	 * To create a new Quote
	 */
	public void createQuote() {
		logger.info("Inside createQuote method in FindQuotesOrPolicyPage Class");

		memberNumberTextbox.enterTextInField();
		associateNumberTextbox.enterTextInField();

		createQuoteBtn.click();
	}
	
	public void nonAssociateNumberCreateQuote()
	{
		logger.info("Inside nonAssociateNumberCreateQuote method in FindQuotesOrPolicyPage Class");
		
		memberNumberTextbox.enterTextInField();
		nonAssociateNumberTextbox.enterTextInField();
		
		createQuoteBtn.click();
	}
	
	/**
	 * To search a find policy
	 */
	public void clickSearchBtn() {
		logger.info("Clicking the search button FindQuotesOrPolicyPage Class");
		searchBtn.click();
	}

	/**
	 * 
	 * To search a newly created draft quote with Policy/Quote ID
	 */
	public void searchQuotePolicy() {
		logger.info("Inside searchQuotePolicy method in FindQuotesOrPolicyPage Class");

		TextBox searchQuotePolicyField = new TextBox(searchQuotePolicyFieldId, quotePolicyNo);
		
		quotePolicyResult = new TextBox(quotePolicyResultId, quotePolicyNo);

		searchQuotePolicyField.enterTextInField();

		searchBtn.clickAndWaitForVisibilityOf(quotePolicyResult);
	}

	/**
	 * To search a policy by member number
	 */
	public void searchPolicyByMemberNumber() {
		logger.info("searchPolicyByMemberNumber in FindQuotesOrPolicyPage Class");
		
		TextBox memberNumber = browser.retrieveMemberAndAssociateNumber(insuranceQuotePolicy, MEMBER_NUMBER);
		
		TextBox policyMemberNumber = new TextBox(memberNumberTextboxId, memberNumber.getOutValue());
		
		policyMemberNumber.enterTextInField();
	}
	
	/**
	 * To search a policy by associate number
	 */
	public void searchPolicyByAssociateNumber() {
		logger.info("searchPolicyByAssociateNumber in FindQuotesOrPolicyPage Class");
		
		TextBox associateNo = browser.retrieveMemberAndAssociateNumber(insuranceQuotePolicy, ASSOCIATE_NUMBER);
		
		TextBox associateNumber = new TextBox(numberTextboxId, associateNo.getOutValue());
		
		associateNumber.enterTextInField();
	}
	
	/**
	 * To search policy member number and associate member number
	 */
	public void policyMemberandAssociateNumber(){
		
		logger.info("policyMemberandAssociateNumber in FindQuotesOrPolicyPage Class");
		
		searchPolicyByMemberNumber();
		
		searchPolicyByAssociateNumber();
		
		clickSearchBtn();
	}
	
	/**
	 * To search a policy by  First name
	 */
	public void searchByFirstName(){		
		logger.info("Inside searchByFirstName method in FindQuotesOrPolicyPage Class");

		TextBox retrieveFirstName = browser.retrieveFromFullName(fullName, FIRST_NAME);
			
		TextBox firstName = new TextBox(firstNameXpath, retrieveFirstName.getOutValue());
			
		firstName.enterTextInField();
	}
	
	/**
	 * To search a policy by last name
	 */
	public void searchByLastName(){		
		logger.info("Inside searchByLastName method in FindQuotesOrPolicyPage Class");

		TextBox retrieveLastName = browser.retrieveFromFullName(fullName, LAST_NAME);
			
		TextBox lastName = new TextBox(lastNameXpath, retrieveLastName.getOutValue());
			
		lastName.enterTextInField();	
	}
	
	/**
	 * To search a policy by full name - first + last name
	 */
	public void searchByFullName(){		
		logger.info("firstAndLastName method in FindQuotesOrPolicyPage Class");
		
		searchByFirstName();
		searchByLastName();
		clickSearchBtn();		
	}
	
	/**
	 * 
	 * To search a quote with Policy/Quote ID
	 * 
	 * @param quoteNumber
	 *            The quote number to be searched
	 */
	public void searchQuotePolicywithQuoteNumber(TextBox textBoxObj) {
		logger.info("Inside searchQuotePolicywithQuoteNumber method in FindQuotesOrPolicyPage Class");
		
		TextBox searchQuotePolicyField = new TextBox(searchQuotePolicyFieldId, textBoxObj.getOutValue());
		
		searchQuotePolicyField.enterTextInField();
		
		searchBtn.click();
		//quotePolicySearchResult.click();
	}
	


	/**
	 * To search and edit a policy
	 * 
	 * @param pageElementObj
	 */
	public void selectQuoteOrPolicyToEdit(TextBox TextBoxObj) {
		logger.info("Inside editQuoteOrPolicy method in FindQuotesOrPolicyPage Class");

		searchQuotePolicywithQuoteNumber(TextBoxObj);
		quotePolicySearchResult.click();
		clickEditBtn();
	}

	/**
	 * This method select the Active policy from status column
	 */
	public void selectActivePolicy() {
		logger.info("Inside selectActivePolicy method in FindQuotesOrPolicyPage Class");

		browser.waitForVisibilityOfElement(selectActiveStatus);
		selectActiveStatus.selectRowByUniqueText();

	}
	
	/**
	 * This method select the Active Renewal policy from status column
	 */
	public void selectActiveRenewalPolicy() {
		logger.info("Inside selectActiveRenewalPolicy method in FindQuotesOrPolicyPage Class");

		browser.waitForVisibilityOfElement(selectActiveRenewal);
		selectActiveRenewal.selectRowByUniqueText();

	}
	
	/**
	 * This method select the Draft Quote Renewal from status column
	 */
	public void verifyAndSelectDraftQuoteRenewal() {
		logger.info("Inside selectActiveRenewalPolicy method in FindQuotesOrPolicyPage Class");

		browser.waitForVisibilityOfElement(selectActiveRenewal);
		
		selectDraftQuoteRenewal.verifyTextIsPresent();
		selectDraftQuoteRenewal.selectRowByUniqueText();

	}
	
	/**
	 * This method select the Active Endorse Policy from status column
	 */
	public void selectActiveEndorsePolicy() {
		logger.info("Inside selectActivePolicy method in FindQuotesOrPolicyPage Class");

		browser.waitForVisibilityOfElement(selectActiveEndorse);
		selectActiveEndorse.selectRowByUniqueText();

	}

	/**
	 * This method select the cancelled policy from status column
	 */
	public void selectCancelledPolicy() {
		logger.info("Inside selectCancelledPolicy method in FindQuotesOrPolicyPage Class");

		browser.waitForVisibilityOfElement(selectCancelledStatus);
		selectCancelledStatus.selectRowByUniqueText();
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
	 * This method click on Renew Policy Button
	 */
	public void clickRenewPolicyButton() {
		logger.info("Inside clickEditBtn method in FindQuotesOrPolicyPage Class");

		activeRenewalBtn.clickAndWaitForProcessingBoxToDisappear();
	}


	/**
	 * Click on Reinstate Policy Button, when you have already selected Find
	 * Results
	 */
	public void clickReinstatePolicyBtn() {
		logger.info("Inside clickReinstatePolicyBtn method in FindQuotesOrPolicyPage Class");	
		
		verifyCancelledStatus.verifyTextIsPresent();
	
		reinstatePolicyBtn.click();
	}

	/**
	 * To search an quote with Policy for Copy Quote The Quote number for
	 * committed quote to be searched
	 */
	public void searchCopiedPolicy() {
		logger.info("Inside searchCopiedPolicy method in FindQuotesOrPolicyPage Class");

		browser.retreiveQuote(retreivePolicy);
	}

	/**
	 * To select the Copy Quote option for a policy
	 * 
	 */
	public void copyQuote() {
		logger.info("Inside copy quote method in FindQuotesOrPolicyPage Class");
		selectPolicyMember.selectRowByUniqueText();
		copyQuoteTab.click();
		browser.waitForProcessingRequestBoxToDisappear();
	}

	/**
	 * To verify message when cancelling a policy
	 */
	public void verifyCancelledMessage() {
		logger.info("Inside verifyCancelledMessage method in FindQuotesOrPolicyPage Class");

		cancelMsgBox.verifyText();
	}

	/**
	 * To verify status of a voided policy
	 */
	public void verifyVoidPolicyStatus() {
		logger.info("Inside verifyVoidPolicyStatus method in FindQuotesOrPolicyPage Class");

		voidStatus.verifyTextIsPresent();
	}

	public void verifyActivePolicyEndorsementInStatus() {
		logger.info("Inside verifyActivePolicyEndorsementInStatus method in FindQuotesOrPolicyPage Class");

		activePolicyEndorsement.verifyTextIsPresent();
	}

	/**
	 * Selects the search result on the basis of policy status
	 * 
	 * @param textBoxObj Result status
	 */

	public void selectingResultStatus(TextBox textBoxObj) {
		logger.info("Inside selectingResultStatus method in FindQuotesOrPolicyPage Class");

		String elementResultXpath = new StringBuilder(STR_CONTAINS_OPEN_BRACE).append(textBoxObj.getInValue().trim())
				.append(CLOSE_BRACES).toString();

		By elementResult = By.xpath(elementResultXpath);

		Button selectStatus = new Button(elementResult);
		selectStatus.click();
	}
	
	/**
	 * This method clear the text already present in Member and Associate Number
	 */
	public void clearMemberData() {
		memberNumberTextbox.clearTextBox();
		associateNumberTextbox.clearTextBox();
	}

}