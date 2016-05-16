package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;


/**
 * This class is for EDit Quotes and Policy page
 * @author Optimus
 */

public class EditQuotesOrPolicyPage {
	Logger logger = Logger.getLogger(EditQuotesOrPolicyPage.class);
	Browser browser = new Browser();
	FindQuotesOrPolicyPage findQuotesOrPolicy;

	private final String EDIT_QUOTE_POLICY_TEXT = "Edit Quote/Policy";
	private final String COMMIT_QUOTE_SUCCESS_MESSAGE = "Quote has been committed successfully.";
	private final String ISSUE_POLICY_SUCCESS_MESSGE = "The documents have been printed successfully.";

	By quoteNumberId = By.id("policyNumberAndVersion");
	By searchResultQuoteId = By.id("insuranceQuotePolicy_1_3");
	By editQuotePolicyTextXpath = By.xpath("//*[@id='policy_detail']/h2/span");
	By editQuotePolicyButtonId = By.id("btnFindPolicyEditId");
	By commitQuoteButtonId = By.id("btnEditPolicyCommitQuoteId");
	By successMessageId = By.id("msgbox");
	By continueWithoutOpportunityButtonId = By.id("btnCreateOpportunityContinueWithoutId");
	By yesPopupId = By.id("yui-gen12-button");
	//TODO :: change to dynamic 
	By showAllButtonXpath = By.xpath("//*[@id='OptionsTabPanel']/div[1]/span[6]/input");
	By submitButtonId = By.id("yui-gen0-button");
	By issuePolicyButtonId = By.id("btnEditPolicyIssuePolicyId");
	By declarationPageCopyDropdownId = By.id("printIssueDecCopyCount");
	By printApplicationDropdownId = By.id("printIssueAppCopyCount");

	PageElement quoteNumber = new PageElement(quoteNumberId);
	PageElement searchResultQuote = new PageElement(searchResultQuoteId, null, InputType.BUTTON);
	PageElement editQuotePolicyButton = new PageElement(editQuotePolicyButtonId, null, InputType.BUTTON);
	PageElement editQuotePolicyText = new PageElement(editQuotePolicyTextXpath, EDIT_QUOTE_POLICY_TEXT);
	PageElement commitQuoteButton = new PageElement(commitQuoteButtonId, null, InputType.BUTTON);
	PageElement successMessage = new PageElement(successMessageId, COMMIT_QUOTE_SUCCESS_MESSAGE);
	PageElement continueWithoutOpportunityButton = new PageElement(continueWithoutOpportunityButtonId, null,
			InputType.BUTTON);
	PageElement yesPopup = new PageElement(yesPopupId, null, InputType.BUTTON);
	PageElement showAllButton = new PageElement(showAllButtonXpath, null, InputType.BUTTON);
	PageElement issuePolicyButton = new PageElement(issuePolicyButtonId,null,InputType.BUTTON);
	PageElement declarationPageCopyDropdown = new PageElement(declarationPageCopyDropdownId,PropertiesReader.readProperty("copiesToPrint"),InputType.DROPDOWN);
	PageElement printApplicationDropdown = new PageElement(printApplicationDropdownId,PropertiesReader.readProperty("copiesToPrint"),InputType.DROPDOWN);
	PageElement issuePolicySuccessMessage = new PageElement(successMessageId, ISSUE_POLICY_SUCCESS_MESSGE);
	PageElement submitButton = new PageElement(submitButtonId,null,InputType.BUTTON);

	
	public void searchAndEditAPolicy() {
		logger.info("Inside searchAndEditAPolicy method in EditQuotesOrPolicyPage Class");
		
		findQuotesOrPolicy = new FindQuotesOrPolicyPage();
		findQuotesOrPolicy.searchQuotePolicy();
		browser.setElement(searchResultQuote);
		browser.setElement(editQuotePolicyButton);
		browser.verifyText(editQuotePolicyText);
	}

	/**
	 * 
	 * To retrieve the Quote/Policy number from a draft policy
	 * 
	 * @return actualQuoteNumber[0] Quote Number
	 */
	public String retrieveQuoteNumber() {
		logger.info("Inside retrieveQuoteNumber method in EditQuotesOrPolicyPage Class");
		
		PageElement object;
		String[] actualQuoteNumber = null;
		object = browser.getText(quoteNumber);
		actualQuoteNumber = object.getOutValue().split(" ");
		System.out.println("Actual quote number is: " + actualQuoteNumber[0]);
		return actualQuoteNumber[0];
	}

	/**
	 * To select the Commit Quote option for a policy
	 * 
	 */

	public void commitQuote() {
		logger.info("Inside commitQuote method in EditQuotesOrPolicyPage Class");
		
		browser.setElement(commitQuoteButton);
		browser.setElement(yesPopup);
		browser.verifyText(successMessage);
		browser.setElement(continueWithoutOpportunityButton);
		browser.verifyText(editQuotePolicyText);
		browser.verifyElementDisabled(commitQuoteButton);
		browser.setElement(showAllButton);
	}
	
	/**
	 * To issue a commited policy
	 * 
	 */

	public void issuePolicy(){
		logger.info("Inside issuePolicy method in EditQuotesOrPolicyPage Class");
		
		browser.setElement(issuePolicyButton);
		browser.setElement(declarationPageCopyDropdown);
		browser.setElement(printApplicationDropdown);
		browser.setElement(submitButton);
		browser.waitUntilTextIsPresent(issuePolicySuccessMessage);
	}

}
