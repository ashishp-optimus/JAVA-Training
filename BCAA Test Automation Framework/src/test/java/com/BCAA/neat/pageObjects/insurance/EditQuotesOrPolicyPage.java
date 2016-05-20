package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is for Edit Quotes and Policy page
 * 
 * @author Optimus
 */

public class EditQuotesOrPolicyPage {
	Logger logger = Logger.getLogger(EditQuotesOrPolicyPage.class);

	private final static String EDIT_QUOTE_POLICY_TEXT = "Edit Quote/Policy";
	private final static String COMMIT_QUOTE_SUCCESS_MESSAGE = "Quote has been committed successfully.";
	private final static String ISSUE_POLICY_SUCCESS_MESSGE = "The documents have been printed successfully.";
	private final static String POLICY_OPEN_MESSAGE = "The new payment plan is successfully opened. ";

	private By assetsTabId = By.id("AssetTab_lnk");
	private By claimsTabId = By.id("ClaimsTab_lnk");
	private By insuredTabId = By.id("InsuredsTab_lnk");
	private By optionsTabId = By.id("OptionsTab");
	private By remarksTabId = By.id("RemarksTab");
	private By noteTabId = By.id("NotesTab");
	private By quoteNumberId = By.id("policyNumberAndVersion");
	private By searchResultQuoteId = By.id("insuranceQuotePolicy_1_3");
	private By editQuotePolicyTextXpath = By.xpath("//*[@id='policy_detail']/h2/span");
	private By editQuotePolicyBtnId = By.id("btnFindPolicyEditId");
	private By commitQuoteBtnId = By.id("btnEditPolicyCommitQuoteId");
	private By successMessageId = By.id("msgbox");
	private By continueWithoutOpportunityBtnId = By.id("btnCreateOpportunityContinueWithoutId");
	private By yesPopupId = By.id("yui-gen12-button");
	// TODO :: change to dynamic
	private By showAllBtnXpath = By.xpath("//*[@id='OptionsTabPanel']/div[1]/span[6]/input");
	private By submitBtnId = By.id("yui-gen0-button");
	private By issuePolicyBtnId = By.id("btnEditPolicyIssuePolicyId");
	private By declarationPageCopyDropdownId = By.id("printIssueDecCopyCount");
	private By printApplicationDropdownId = By.id("printIssueAppCopyCount");
	private By cancelPolicyBtnXpath = By
			.xpath("//div[@id='policy_detail']/div/input[contains(@value,'Cancel Policy')]");
	private By voidPolicyBtnXpath = By.xpath(".//*[@id='policy_detail']/div/input[contains(@value,'Void Policy')]");

	Button assetsTab = new Button(assetsTabId);
	Button claimsTab = new Button(claimsTabId);
	Button insuredTab = new Button(insuredTabId);
	Button optionsTab = new Button(optionsTabId);
	Button remarksTab = new Button(remarksTabId);
	Button notesTab = new Button(noteTabId);
	Button searchResultQuote = new Button(searchResultQuoteId);
	Button commitQuoteBtn = new Button(commitQuoteBtnId);
	Button editQuotePolicyBtn = new Button(editQuotePolicyBtnId);
	Button continueWithoutOpportunityBtn = new Button(continueWithoutOpportunityBtnId);
	Button yesPopup = new Button(yesPopupId);
	Button showAllBtn = new Button(showAllBtnXpath);
	Button issuePolicyBtn = new Button(issuePolicyBtnId);
	Button submitBtn = new Button(submitBtnId);
	Button cancelPolicyBtn = new Button(cancelPolicyBtnXpath);
	Button voidPolicyBtn = new Button(voidPolicyBtnXpath);

	DropDown declarationPageCopyDropdown = new DropDown(declarationPageCopyDropdownId,
			PropertiesReader.readProperty("copiesToPrint"));
	DropDown printApplicationDropdown = new DropDown(printApplicationDropdownId,
			PropertiesReader.readProperty("copiesToPrint"));

	PageElement editQuotePolicyText = new PageElement(editQuotePolicyTextXpath, EDIT_QUOTE_POLICY_TEXT);
	PageElement successMessage = new PageElement(successMessageId, COMMIT_QUOTE_SUCCESS_MESSAGE);
	PageElement issuePolicySuccessMessage = new PageElement(successMessageId, ISSUE_POLICY_SUCCESS_MESSGE);
	PageElement policyOpenMessage = new PageElement(successMessageId, POLICY_OPEN_MESSAGE);
	PageElement quoteNumber = new PageElement(quoteNumberId);

	/**
	 * Navigational methods
	 */
	public void navigateToAssetsTab(){
		logger.info("Navigating to Asset tab");
		assetsTab.click();
	}
	
	public void navigateToClaimsTab(){
		logger.info("Navigating to Claims tab");
		claimsTab.click();
	}
	
	public void navigateToInsuredsTab(){
		logger.info("Navigating to Insureds tab");
		insuredTab.click();
	}
	
	public void navigateToOptionsTab(){
		logger.info("Navigating to Options tab");
		optionsTab.click();
	}
	
	public void navigateToRemarksTab(){
		logger.info("Navigating to Remarks tab");
		remarksTab.click();
	}
	
	public void navigateToNotesTab(){
		logger.info("Navigating to Notes tab");
		notesTab.click();
	}
	
		
	/**
	 * To search and edit a policy
	 */
	
	public void searchAndEditAPolicy() {
		logger.info("Inside searchAndEditAPolicy method in EditQuotesOrPolicyPage Class");
		
		Browser browser = new Browser();
	
		//findQuotesOrPolicy.searchQuotePolicy();		
		searchResultQuote.click();		
		editQuotePolicyBtn.click();
		
		browser.verifyText(editQuotePolicyText);
	}

	/**
	 * 
	 * To retrieve the Quote/Policy number from a draft policy
	 * 
	 * @return actualQuoteNumber[0] Quote Number
	 */
	public PageElement retrieveQuoteNumber() {
		logger.info("Inside retrieveQuoteNumber method in EditQuotesOrPolicyPage Class");

		Browser browser = new Browser();
		PageElement pageElementobj;
		pageElementobj = browser.retreiveQuote(quoteNumber);
		return pageElementobj;
	}

	/**
	 * To select the Commit Quote option for a policy
	 * 
	 */

	public void commitQuote() {
		logger.info("Inside commitQuote method in EditQuotesOrPolicyPage Class");
		Browser browser = new Browser();

		commitQuoteBtn.click();
		yesPopup.click();
		browser.verifyText(successMessage);
		continueWithoutOpportunityBtn.click();
		browser.verifyText(editQuotePolicyText);
		browser.verifyElementDisabled(commitQuoteBtn);
		showAllBtn.click();
	}

	/**
	 * To issue a committed policy
	 * 
	 */

	public void issuePolicy() {
		logger.info("Inside issuePolicy method in EditQuotesOrPolicyPage Class");

		Browser browser = new Browser();

		issuePolicyBtn.click();
		declarationPageCopyDropdown.selectValue();
		printApplicationDropdown.selectValue();
		submitBtn.click();
		browser.waitUntilTextIsPresent(issuePolicySuccessMessage);
	}

	/**
	 * To verify success message when opening a policy
	 */
	public void verifyPolicyOpenSuccessMessage() {
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

		cancelPolicyBtn.click();
	}

	public void clickOnVoidPolicyBtn() {
		logger.info("Clicking on Void Policy button");
		voidPolicyBtn.click();
	}

}
