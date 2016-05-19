package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;


/**
 * This class is for Edit Quotes and Policy page
 * @author Optimus
 */

public class EditQuotesOrPolicyPage {
	Logger logger = Logger.getLogger(EditQuotesOrPolicyPage.class);


	private final String EDIT_QUOTE_POLICY_TEXT = "Edit Quote/Policy";
	private final String COMMIT_QUOTE_SUCCESS_MESSAGE = "Quote has been committed successfully.";
	private final String ISSUE_POLICY_SUCCESS_MESSGE = "The documents have been printed successfully.";
	private final String POLICY_OPEN_MESSAGE = "The new payment plan is successfully opened. ";

	By quoteNumberId = By.id("policyNumberAndVersion");
	By searchResultQuoteId = By.id("insuranceQuotePolicy_1_3");
	By editQuotePolicyTextXpath = By.xpath("//*[@id='policy_detail']/h2/span");
	By editQuotePolicyBtnId = By.id("btnFindPolicyEditId");
	By commitQuoteBtnId = By.id("btnEditPolicyCommitQuoteId");
	By successMessageId = By.id("msgbox");
	By continueWithoutOpportunityBtnId = By.id("btnCreateOpportunityContinueWithoutId");
	By yesPopupId = By.id("yui-gen12-button");
	//TODO :: change to dynamic 
	By showAllBtnXpath = By.xpath("//*[@id='OptionsTabPanel']/div[1]/span[6]/input");
	By submitBtnId = By.id("yui-gen0-button");
	By issuePolicyBtnId = By.id("btnEditPolicyIssuePolicyId");
	By declarationPageCopyDropdownId = By.id("printIssueDecCopyCount");
	By printApplicationDropdownId = By.id("printIssueAppCopyCount");
	By cancelPolicyBtnXpath = By.xpath("//div[@id='policy_detail']/div/input[contains(@value,'Cancel Policy')]");
	By voidPolicyBtnXpath = By.xpath(".//*[@id='policy_detail']/div/input[contains(@value,'Void Policy')]");

	PageElement quoteNumber = new PageElement(quoteNumberId);
	PageElement searchResultQuote = new PageElement(searchResultQuoteId, null, InputType.BUTTON);
	PageElement editQuotePolicyBtn = new PageElement(editQuotePolicyBtnId, null, InputType.BUTTON);
	PageElement editQuotePolicyText = new PageElement(editQuotePolicyTextXpath, EDIT_QUOTE_POLICY_TEXT);
	PageElement commitQuoteBtn = new PageElement(commitQuoteBtnId, null, InputType.BUTTON);
	PageElement successMessage = new PageElement(successMessageId, COMMIT_QUOTE_SUCCESS_MESSAGE);
	PageElement continueWithoutOpportunityBtn = new PageElement(continueWithoutOpportunityBtnId, null,
			InputType.BUTTON);
	PageElement yesPopup = new PageElement(yesPopupId, null, InputType.BUTTON);
	PageElement showAllBtn = new PageElement(showAllBtnXpath, null, InputType.BUTTON);
	PageElement issuePolicyBtn = new PageElement(issuePolicyBtnId,null,InputType.BUTTON);
	PageElement declarationPageCopyDropdown = new PageElement(declarationPageCopyDropdownId,PropertiesReader.readProperty("copiesToPrint"),InputType.DROPDOWN);
	PageElement printApplicationDropdown = new PageElement(printApplicationDropdownId,PropertiesReader.readProperty("copiesToPrint"),InputType.DROPDOWN);
	PageElement issuePolicySuccessMessage = new PageElement(successMessageId, ISSUE_POLICY_SUCCESS_MESSGE);
	PageElement submitBtn = new PageElement(submitBtnId,null,InputType.BUTTON);
	PageElement policyOpenMessage = new PageElement(successMessageId,POLICY_OPEN_MESSAGE);
	PageElement cancelPolicyBtn = new PageElement(cancelPolicyBtnXpath,null,InputType.BUTTON);
	PageElement voidPolicyBtn = new PageElement(voidPolicyBtnXpath,null,InputType.BUTTON);

	/**
	 * To search and edit a policy
	 */
	
	public void searchAndEditAPolicy() {
		logger.info("Inside searchAndEditAPolicy method in EditQuotesOrPolicyPage Class");
		
		FindQuotesOrPolicyPage findQuotesOrPolicy = new FindQuotesOrPolicyPage();
		Browser browser = new Browser();
		Button button = new Button();
	
		findQuotesOrPolicy.searchQuotePolicy();
		
		button.click(searchResultQuote);		
		button.click(editQuotePolicyBtn);
		
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
		
		Browser browser = new Browser();
		
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
		Browser browser = new Browser();
		Button button = new Button();
		
		button.click(commitQuoteBtn);
		button.click(yesPopup);
		browser.verifyText(successMessage);
		button.click(continueWithoutOpportunityBtn);
		browser.verifyText(editQuotePolicyText);
		browser.verifyElementDisabled(commitQuoteBtn);
		button.click(showAllBtn);
	}
	
	/**
	 * To issue a commited policy
	 * 
	 */

	public void issuePolicy(){
		logger.info("Inside issuePolicy method in EditQuotesOrPolicyPage Class");
		
		Browser browser = new Browser();
		Button button = new Button();
		DropDown dropdown = new DropDown();
		
		button.click(issuePolicyBtn);
		dropdown.selectValue(declarationPageCopyDropdown);
		dropdown.selectValue(printApplicationDropdown);
		button.click(submitBtn);
		browser.waitUntilTextIsPresent(issuePolicySuccessMessage);
	}
	
	/**
	 * 
	 */
	public void verifyPolicyOpenSuccessMessage(){
		logger.info("Verifying policy open message");
		
		Browser browser = new Browser();		
		browser.waitUntilTextIsPresent(policyOpenMessage);
	}
	
	/**
	 * 
	 * @param pageElementObj
	 */
	
	public void verifyRetrivedQuote(PageElement pageElementObj) {
		logger.info("Verifying retrieved quote number");
		
		Browser browser = new Browser();
		
		PageElement PageObj = browser.retreiveQuote(quoteNumber);
		
		logger.info(pageElementObj.getOutValue());
		logger.info(PageObj.getOutValue());
	}
	
	
	
	public void verifyEditQuotePolicyHeader() {
		logger.info("Verifying retrieved quote number");
		Browser browser = new Browser();
		
		browser.verifyText(editQuotePolicyText);	
	}
	

	public void clickOnCancelPolicyBtn() {
		logger.info("Clicking on cancel Policy button");
		
		Button button = new Button();
		button.click(cancelPolicyBtn);
	}
	

	public void clickOnVoidPolicyBtn() {
		Button button = new Button();
		button.click(voidPolicyBtn);
	}

}
