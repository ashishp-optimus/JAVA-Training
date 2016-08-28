package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.Table;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is for Edit Quotes and Policy page
 * 
 * @author Optimus
 */

public class EditQuotesOrPolicyPage {
	Logger logger;
	Browser browser;
	
	DataBaseConnection dataBaseConnection = new DataBaseConnection();
	private Map<String, String> editQuotesPolicyPage = dataBaseConnection.getDatabase()
			.getPageCollectionsAsMap("EDITQUOTESORPOLICYPAGE");

	public EditQuotesOrPolicyPage() {
		logger = Logger.getLogger(EditQuotesOrPolicyPage.class);
		browser = new Browser();
	}
	

	private final static String EDIT_QUOTE_POLICY_TEXT_KEY = "editquotepolicyheading";
	private final static String COMMIT_QUOTE_SUCCESS_MESSAGE_KEY = "commitquotesuccessmessage";
	private final static String ISSUE_POLICY_SUCCESS_MESSGE_KEY = "issuepolicysuccessmessage";
	private final static String POLICY_OPEN_MESSAGE_KEY = "policyopenmessage";
	private final static String ENDORSE_POLICY_MESSAGE_KEY = "endorsepolicymessage";
	private final static String INSURED_SUCCESS_MESSAGE_KEY = "insuredsuccessmessage";
	
	private final static String INSURED_DELETED = "Policy Insured has been deleted successfully.";
	private final static String BUSINESS_SUCCESS_MESSAGE = "Policy Home Asset was saved successfully.";
	private final static String REINSTATE_STATUS = "Active Policy - Reinstate";
	private final static String INSURED_ADDED_SUCESS_MESSAGE = "Policy Member has been added successfully. ";
	private final static String EXISTING_HOME_ASSETS = "Single family Principal - 4567 Canada Way, Burnaby";
	private final static String DRAFT_SUCCESS_MESSAGE = "Draft Quote has been successfully created.";
	private static final String LIABILITY_COVERAGE_MESSAGE = "Please ensure all locations have the same liability coverage";
	private final static String BCAA_MEMBER_DISCOUNT_MESSAGE="Added option Discount - BCAA Member";
	private final static String NON_BCAA_MESSAGE="Added option Discount - Concrete Construction ";
	private final static String REMOVED_BCAA_MESSAGE="Removed option Discount - BCAA Member";

	private By assetsTabId = By.id("AssetTab_lnk");
	private By editBtnId = By.id("btnAssetsTabEditId");
	private By claimsTabId = By.id("ClaimsTab_lnk");
	private By insuredTabId = By.id("InsuredsTab_lnk");
	private By optionsTabId = By.id("OptionsTab_lnk");
	private By remarksTabId = By.id("RemarksTab");
	private By noteTabId = By.id("NotesTab");
	private By quoteNumberId = By.id("policyNumberAndVersion");
	private By searchResultQuoteId = By.id("insuranceQuotePolicy_1_3");
	private By editQuotePolicyTextXpath = By
			.xpath("//*[@id='policy_detail']/h2/span");
	private By editQuotePolicyBtnId = By.id("btnFindPolicyEditId");
	private By commitQuoteBtnId = By.id("btnEditPolicyCommitQuoteId");
	private By successMessageId = By.id("msgbox");
	private By UnsuccessMessageId = By.id("errbox");
	private By continueWithoutOpportunityBtnId = By
			.id("btnCreateOpportunityContinueWithoutId");
	private By yesPopupId = By.id("yui-gen12-button");
	private By showAllBtnXpath = By
			.xpath("//*[@id='OptionsTabPanel']/div[1]/span[6]/input");
	private By submitBtnId = By.id("yui-gen0-button");
	private By issuePolicyBtnId = By.id("btnEditPolicyIssuePolicyId");
	private By declarationPageCopyDropdownId = By.id("printIssueDecCopyCount");
	private By printApplicationDropdownId = By.id("printIssueAppCopyCount");
	private By cancelPolicyBtnXpath = By
			.xpath("//div[@id='policy_detail']/div/input[contains(@value,'Cancel Policy')]");
	private By voidPolicyBtnXpath = By
			.xpath(".//*[@id='policy_detail']/div/input[contains(@value,'Void Policy')]");
	private By policyStageDescriptionId = By.id("policyStageDescription");
	private By btnEditPolicyFindPolicyBtnId = By
			.id("btnEditPolicyFindPolicyId");
	private By homeInAssetTableXpath = By
			.xpath("//div[@id='AssetTabPanel']/div/table/tbody/tr");
	private By discountBCAAMemberMsgXpath=By.xpath(".//*[@id='msgbox']/ul/li[2]");
	private By discountNonBCAAMemberMsgXpath=By.xpath(".//*[@id='msgbox']/ul/li[1]");
	
	Button assetsTab = new Button(assetsTabId);
	Button editBtn = new Button(editBtnId);
	Button claimsTab = new Button(claimsTabId);
	Button insuredTab = new Button(insuredTabId);
	Button optionsTab = new Button(optionsTabId);
	Button remarksTab = new Button(remarksTabId);
	Button notesTab = new Button(noteTabId);
	Button searchResultQuote = new Button(searchResultQuoteId);
	Button commitQuoteBtn = new Button(commitQuoteBtnId);
	Button editQuotePolicyBtn = new Button(editQuotePolicyBtnId);
	Button continueWithoutOpportunityBtn = new Button(
			continueWithoutOpportunityBtnId);
	Button yesPopup = new Button(yesPopupId);
	Button showAllBtn = new Button(showAllBtnXpath);
	Button issuePolicyBtn = new Button(issuePolicyBtnId);
	Button submitBtn = new Button(submitBtnId);
	Button cancelPolicyBtn = new Button(cancelPolicyBtnXpath);
	Button voidPolicyBtn = new Button(voidPolicyBtnXpath);
	Button btnEditPolicyFindPolicy = new Button(btnEditPolicyFindPolicyBtnId);

	DropDown declarationPageCopyDropdown = new DropDown(
			declarationPageCopyDropdownId,
			PropertiesReader.readProperty("copiesToPrint"));
	DropDown printApplicationDropdown = new DropDown(
			printApplicationDropdownId,
			PropertiesReader.readProperty("copiesToPrint"));

	Table selectExistingHomeAssets = new Table(homeInAssetTableXpath,
			EXISTING_HOME_ASSETS);
	
	TextBox editQuotePolicyText = new TextBox(editQuotePolicyTextXpath,
			editQuotesPolicyPage.get(EDIT_QUOTE_POLICY_TEXT_KEY));
	TextBox commitSuccessMessage = new TextBox(successMessageId,
			editQuotesPolicyPage.get(COMMIT_QUOTE_SUCCESS_MESSAGE_KEY));
	
	TextBox issuePolicySuccessMessage = new TextBox(successMessageId,
			editQuotesPolicyPage.get(ISSUE_POLICY_SUCCESS_MESSGE_KEY));
	TextBox policyOpenMessage = new TextBox(successMessageId,
			editQuotesPolicyPage.get(POLICY_OPEN_MESSAGE_KEY));
	TextBox endorsePolicyMessage = new TextBox(successMessageId,
			editQuotesPolicyPage.get(ENDORSE_POLICY_MESSAGE_KEY));
	TextBox insuredSuccessMessage = new TextBox(successMessageId,
			editQuotesPolicyPage.get(INSURED_SUCCESS_MESSAGE_KEY));
	TextBox quoteNumber = new TextBox(quoteNumberId);
	TextBox verifyInsuredDeleted = new TextBox(successMessageId,
			INSURED_DELETED);
	TextBox businessSucessMessage = new TextBox(successMessageId,
			BUSINESS_SUCCESS_MESSAGE);
	TextBox draftSuccessMessage = new TextBox(successMessageId,
			DRAFT_SUCCESS_MESSAGE);
	TextBox verifyReinstateStatus = new TextBox(policyStageDescriptionId,
			REINSTATE_STATUS);
	TextBox verifyInsuredSucessMessage = new TextBox(successMessageId,
			INSURED_ADDED_SUCESS_MESSAGE);
	TextBox commitErrorMessage = new TextBox(UnsuccessMessageId,
			LIABILITY_COVERAGE_MESSAGE);
	TextBox verifyDiscountMessage=new TextBox(discountBCAAMemberMsgXpath, BCAA_MEMBER_DISCOUNT_MESSAGE);
	TextBox verifyDiscountNonBCAAMemberMessage=new TextBox(discountNonBCAAMemberMsgXpath, NON_BCAA_MESSAGE);
	TextBox verifyRemovedBCAAMemberMessage=new TextBox(discountBCAAMemberMsgXpath, REMOVED_BCAA_MESSAGE);

	/**
	 * Navigational methods
	 */
	public void goToAssetsTab() {
		logger.info("Navigating to Asset tab");

		assetsTab.click();
	}

	public void goToClaimsTab() {
		logger.info("Navigating to Claims tab");

		claimsTab.click();
	}

	public void goToInsuredsTab() {
		logger.info("Navigating to Insureds tab");

		insuredTab.click();
	}

	public void goToOptionsTab() {
		logger.info("Navigating to Options tab");

		optionsTab.click();
		browser.waitForProcessingRequestBoxToDisappear();
	}

	public void goToRemarksTab() {
		logger.info("Navigating to Remarks tab");

		remarksTab.click();
	}

	public void goToNotesTab() {
		logger.info("Navigating to Notes tab");

		notesTab.click();
	}

	/**
	 * 
	 * To retrieve the Quote/Policy number from a draft policy
	 * 
	 * @return actualQuoteNumber[0] Quote Number
	 */
	public TextBox retrieveQuoteNumber() {
		logger.info("Inside retrieveQuoteNumber method in EditQuotesOrPolicyPage Class");

		TextBox quoteNo;

		quoteNo = browser.retreiveQuote(quoteNumber);
		return quoteNo;
	}

	/**
	 * To select the Commit Quote option for a policy
	 * 
	 * @return
	 * 
	 */
	public TextBox commitQuote() {
		logger.info("Inside commitQuote method in EditQuotesOrPolicyPage Class");

		commitQuoteBtn.click();
		yesPopup.click();

		commitSuccessMessage.verifyText();

		continueWithoutOpportunityBtn.click();

		verifyEditQuotePolicyHeader();

		browser.verifyElementDisabled(commitQuoteBtn);

		selectShowAllBtn(); // to reload the page internally so it can proceed
							// with further tab selection
		
		TextBox quoteNumber =retrieveQuoteNumber();
		return quoteNumber;
	}

	public void selectCommitQuoteButtonOnly() {
		logger.info("Inside commitQuote method in EditQuotesOrPolicyPage Class");

		commitQuoteBtn.click();
		yesPopup.click();

		commitSuccessMessage.verifyText();
	}

	public void selectShowAllBtn() {
		logger.info("Selecting the Show All button");

		showAllBtn.click();
	}

	/**
	 * To issue a committed policy
	 */
	public void issuePolicy() {
		logger.info("Inside issuePolicy method in EditQuotesOrPolicyPage Class");

		issuePolicyBtn.click();

		declarationPageCopyDropdown.selectValue();
		printApplicationDropdown.selectValue();

		submitBtn.click();

		issuePolicySuccessMessage.waitUntilTextIsPresent();
	}

	/**
	 * To verify draft quote creation success message
	 */
	public void verifyDraftQuoteSuccessMessage() {
		logger.info("Verifying draft quote creation success message");

		draftSuccessMessage.verifyText();
	}

	/**
	 * To verify success message when opening a policy
	 */
	public void verifyPolicyOpenSuccessMessage() {
		logger.info("Verifying policy open message");

		policyOpenMessage.verifyText();
	}

	/**
	 * To verify success message when editing an insured
	 */
	public void verifyEditInsuredSuccessMessage() {
		logger.info("Verifying edited insured success message");

		insuredSuccessMessage.verifyText();
	}

	/**
	 * To verify success message when endorsing a policy
	 */
	public void verifyEndorsePolicySuccessMessage() {
		logger.info("Verifying endorse policy success message");

		endorsePolicyMessage.verifyText();
	}

	public void verifyEditQuotePolicyHeader() {
		logger.info("Verifying retrieved quote number");

		editQuotePolicyText.verifyText();
	}

	public void clickOnVoidPolicyBtn() {
		logger.info("Clicking on Void Policy button");

		voidPolicyBtn.click();
	}

	/**
	 * TA-3957: Cancel Policy
	 * 
	 */
	public void selectCancelPolicy() {
		logger.info("Clicking on cancel Policy button");

		verifyEditQuotePolicyHeader();
		cancelPolicyBtn.click();
	}

	public void verifyInsuredDeletedSucessMessage() {
		logger.info("Verifying insured deleted");

		verifyInsuredDeleted.verifyText();
	}

	public void activePolicyReinstate() {
		logger.info("Verifying Active Policy Reinstate");

		verifyReinstateStatus.verifyContainsText();
	}

	public void clickFindPolicyBtn() {
		logger.info("click on Find Policy Button");

		btnEditPolicyFindPolicy.click();
	}

	public void verifyBusinessSucessMessage() {
		logger.info("Verifying Business Sucess Message");

		businessSucessMessage.verifyText();
	}

	public void selectExistingAssets() {
		selectExistingHomeAssets.selectRowByUniqueText();
	}

	public void clickOnEditButton() {
		editBtn.click();
	}

	public void verifyInsuredSucessMessage() {
		verifyInsuredSucessMessage.verifyText();
	}

	/**
	 * To Verify Adding a 2nd location asset with a different liability should
	 * result to error
	 * 
	 */

	public void commitQuoteError() {
		logger.info("Inside commitQuoteError method in EditQuotesOrPolicyPage Class");

		commitQuoteBtn.click();
		yesPopup.click();
		browser.waitForInvisibilityOfText(commitErrorMessage);
		commitErrorMessage.verifyContainsText();

	}
	public void verifyBCAADiscountMessage() {
		logger.info("Inside verifyBCAADiscountMessage method in EditQuotesOrPolicyPage Class");
		
		verifyDiscountMessage.verifyContainsText();
	}
	
	public void verifyNonBCAADiscountMessage() {
		logger.info("Inside verifyNonBCAADiscountMessage method in EditQuotesOrPolicyPage Class");
		
		verifyDiscountNonBCAAMemberMessage.verifyContainsText();
	}
	
	public void verifyRemovedBCAAMemberMessage() {
		logger.info("Inside verifyRemovedBCAAMemberMessage method in EditQuotesOrPolicyPage Class");
		
		verifyRemovedBCAAMemberMessage.verifyContainsText();
	}
	
}
