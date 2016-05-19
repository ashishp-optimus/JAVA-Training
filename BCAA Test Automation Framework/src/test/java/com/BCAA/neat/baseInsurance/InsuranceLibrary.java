package com.BCAA.neat.baseInsurance;

import com.BCAA.neat.pageObjects.POS.PosReceiptPage;
import com.BCAA.neat.pageObjects.epp.OpenPaymentPlanPage;
import com.BCAA.neat.pageObjects.insurance.AssetsTabPage;
import com.BCAA.neat.pageObjects.insurance.ClaimsTabPage;
import com.BCAA.neat.pageObjects.insurance.CreateReceiptPage;
import com.BCAA.neat.pageObjects.insurance.EditQuotesOrPolicyPage;
import com.BCAA.neat.pageObjects.insurance.FindQuotesOrPolicyPage;
import com.BCAA.neat.pageObjects.insurance.HomeEvaluationTabPage;
import com.BCAA.neat.pageObjects.insurance.InsuredsTabPage;
import com.BCAA.neat.pageObjects.insurance.NotesTabPage;
import com.BCAA.neat.pageObjects.insurance.OptionsTabPage;
import com.BCAA.neat.pageObjects.insurance.RemarksTabPage;
import com.BCAA.neat.pageObjects.insurance.RiskDetailsTabPage;
import com.BCAA.neat.pageObjects.insurance.SelectInsurancePlanPage;
import com.BCAA.neat.pageObjects.navigation.HomePage;

/**
 * @author Optimus
 */
public class InsuranceLibrary {

	HomePage homePage;
	SelectInsurancePlanPage selectinsurance;
	FindQuotesOrPolicyPage  findQuotesOrPolicy;
	EditQuotesOrPolicyPage editQuotesOrPolicy;
	InsuredsTabPage insuredsTab;
	AssetsTabPage assets;
	RiskDetailsTabPage riskDetailTab;
	HomeEvaluationTabPage homeEvaluationTab;
	OptionsTabPage optionTab;
	RemarksTabPage remarksTab;
	NotesTabPage notesTab;
	ClaimsTabPage claimsTab;
	CreateReceiptPage createReceipt;
	OpenPaymentPlanPage openPaymentPlan;
	PosReceiptPage posReceipt;
	
	/**
	 * To verify successful login on TNEAT
	 */
	public void verifyLogin()
	{
		homePage = new HomePage();
		homePage.verifyLogin();
	}
	/**
	 * This Method Select the Insurance tab
	 */
	public void selectInsuranceTab()
	{
		homePage = new HomePage();
		homePage.selectInsurance();
	}
	/**
	 * To select an Insurance Plan and create a draft quote
	 */
	public void SelectInsurancePlan()
	{
		selectinsurance = new SelectInsurancePlanPage();
		selectinsurance.selectInsurancePlan();
	}
	
	/**
	 * To create a new Quote
	 */
	public void createQuote()
	{
		findQuotesOrPolicy = new FindQuotesOrPolicyPage();
		findQuotesOrPolicy.createQuote();
	}
	/**
	 * To search a newly created draft quote with Policy/Quote ID
	 */
	public void searchQuotePolicy()
	{
		findQuotesOrPolicy = new FindQuotesOrPolicyPage();
		findQuotesOrPolicy.searchQuotePolicy();	
	}
	/**
	 * To search an quote with Policy for Copy Quote
	 *   The Quote number for committed quote to be searched
	 */
	public void searchCopiedPolicy()
	{
		findQuotesOrPolicy = new FindQuotesOrPolicyPage();
		findQuotesOrPolicy.searchCopiedPolicy();
	}
	/**
	 * To select the Copy Quote option for a policy
	 */
	public void copyQuote()
	{
		findQuotesOrPolicy = new FindQuotesOrPolicyPage();
		findQuotesOrPolicy.copyQuote();
	}
	/**
	 * To search and edit a policy
	 */
	public void searchAndEditAPolicy() 
	{
		editQuotesOrPolicy = new EditQuotesOrPolicyPage();
		editQuotesOrPolicy.searchAndEditAPolicy();
	}
	
	/**
	 * To retrieve the Quote/Policy number from a draft policy
	 * @return actualQuoteNumber[0] Quote Number
	 */
	public void retrieveQuoteNumber()
	{
		editQuotesOrPolicy = new EditQuotesOrPolicyPage();
		editQuotesOrPolicy.retrieveQuoteNumber();
	}
	/**
	 * To select the Commit Quote option for a policy
	 */
	public void commitQuote()
	{
		editQuotesOrPolicy = new EditQuotesOrPolicyPage();
		editQuotesOrPolicy.commitQuote();
	}
	/**
	 * To issue a committed policy
	 */
	public void issuePolicy()
	{
		editQuotesOrPolicy = new EditQuotesOrPolicyPage();
		editQuotesOrPolicy.issuePolicy();
	}	
	/**
	 * To navigate to Insured tab
	 */
	public void goToInsuredsTab()
	{
		insuredsTab = new InsuredsTabPage();
		insuredsTab.insuredTab();
	}
	/**
	 * To add a new insured user under a policy
	 */
	public void addInsuredsTab()
	{
		insuredsTab = new InsuredsTabPage();
		insuredsTab.addInsured();
	}
	/**
	 * To edit an insured user of a policy
	 */
	public void editInsuredsTab()
	{
		insuredsTab = new InsuredsTabPage();
		insuredsTab.editInsured();
	}

	/**
	 * To navigate to Asset tab
	 */
	public void assetTab() 
	{
		assets = new AssetsTabPage();
		assets.assetTab();
	}
	/**
	 * Add a new home asset
	 */
	public void addAssets()
	{
		assets = new AssetsTabPage();
		assets.addAsset();
	}
	/**
	 * Edit a home asset
	 */
	public void editAssets()
	{
		assets = new AssetsTabPage();
		assets.editAsset();
	}
	/**
	 * To fill all the required fields of Risk Details Tab
	 */
	public void addRiskDetails()
	{
		riskDetailTab = new RiskDetailsTabPage();
		riskDetailTab.addRiskDetails();
	}
	/**
	 * Add a new Home evaluation 
	 */
	public void addHomeEvaluation()
	{
		homeEvaluationTab = new HomeEvaluationTabPage();
		homeEvaluationTab.addHomeEvaluation();
	}
	/**
	 * Edit a Home evaluation 
	 */
	public void editHomeEvaluation()
	{
		homeEvaluationTab = new HomeEvaluationTabPage();
		homeEvaluationTab.editHomeEvaluation();
	}
	/**
	 * To navigate to Option tab
	 */
	public void navigateToOptionsTab()
	{	optionTab = new OptionsTabPage();
		optionTab.navigateToOptionsTab();
	}
	
	/**
	 * To verify options for a policy
	 * 
	 */
	public void verifyOptions()
	{
		optionTab = new OptionsTabPage();
		optionTab.verifyOptions();
	}
	/**
	 * To verify options for a policy
	 * 
	 */
	public void verifyPremiums()
	{
		optionTab = new OptionsTabPage();
		optionTab.verifyPremiums();
	}
	/**
	 * To add remarks to a policy
	 */
	public void addRemarks() {
		remarksTab = new RemarksTabPage();
		remarksTab.addRemarks();
	}
	/**
	 * clicking on add note tab
	 */
	public void clickOnNoteTab()
	{
		notesTab = new NotesTabPage();
		notesTab.clickOnNoteTab();
	}
	/**
	 * To add a new note to a policy 
	 */
	public void addNotes()
	{
		notesTab = new NotesTabPage();
		notesTab.addNotes();
	}
	/**
	 * To view a new note to a policy
	 */
	public void ViewNote()
	{
		notesTab = new NotesTabPage();
		notesTab.ViewNote();
	}
	/**
	 * To navigate to claim Tab
	 * 
	 */
	public void claimsTab()
	{
		claimsTab = new ClaimsTabPage();
		claimsTab.claimsTab();
	}
	/**
	 * To create external claim
	 */
	public void createExternalClaim()
	{
		claimsTab = new ClaimsTabPage();
		claimsTab.createExternalClaim();
	}
	/**
	 * To delete external claim
	 */
	public void deleteExternalClaim()
	{
		claimsTab = new ClaimsTabPage();
		claimsTab.deleteExternalClaim();
	}
	
	/**
	 * To select create receipt
	 */
	public void selectCreateReceipt()
	{
		createReceipt = new CreateReceiptPage();
		createReceipt.selectCreateReceipt();
	}
	/**
	 * To select open payment plan in create Receipt Page
	 */
	public void selectOpenPaymentPlan()
	{
		createReceipt = new CreateReceiptPage();
		createReceipt.selectOpenPaymentPlan();
	}
	/**
	 * To select open payment plan in Open Payment Plan Page
	 */
	public void openPaymentPlan()
	{
		openPaymentPlan =new OpenPaymentPlanPage();
		openPaymentPlan.openPaymentPlan();
	}
	/**
	 * To create Receipt POS Receipt Page
	 */
	public void createReceipt()
	{
		posReceipt =new PosReceiptPage();
		posReceipt.createReceipt();
	}
	
	
}
