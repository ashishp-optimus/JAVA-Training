package com.BCAA.neat.baseInsurance;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.pageObjects.POS.PosReceiptPage;
import com.BCAA.neat.pageObjects.epp.OpenPaymentPlanPage;
import com.BCAA.neat.pageObjects.insurance.AddEditDeletePolicyOptionsPage;
import com.BCAA.neat.pageObjects.insurance.AddInsuredPage;
import com.BCAA.neat.pageObjects.insurance.AddNotesPage;
import com.BCAA.neat.pageObjects.insurance.AddOrEditAssetPage;
import com.BCAA.neat.pageObjects.insurance.AssetsTabPage;
import com.BCAA.neat.pageObjects.insurance.BusinessTabPage;
import com.BCAA.neat.pageObjects.insurance.CreateReceiptPage;
import com.BCAA.neat.pageObjects.insurance.EditHomeEvaluationPage;
import com.BCAA.neat.pageObjects.insurance.EditInsuredPage;
import com.BCAA.neat.pageObjects.insurance.EditQuotesOrPolicyPage;
import com.BCAA.neat.pageObjects.insurance.FindQuotesOrPolicyPage;
import com.BCAA.neat.pageObjects.insurance.HomeEvaluationTabPage;
import com.BCAA.neat.pageObjects.insurance.InsuranceQuotePolicy;
import com.BCAA.neat.pageObjects.insurance.InsuredsTabPage;
import com.BCAA.neat.pageObjects.insurance.NotesTabPage;
import com.BCAA.neat.pageObjects.insurance.OptionsTabPage;
import com.BCAA.neat.pageObjects.insurance.PreviewDeclarationPages;
import com.BCAA.neat.pageObjects.insurance.RemarksTabPage;
import com.BCAA.neat.pageObjects.insurance.RiskDetailsTabPage;
import com.BCAA.neat.pageObjects.insurance.SafeHomeTabPage;
import com.BCAA.neat.pageObjects.insurance.SelectInsurancePlanPage;
import com.BCAA.neat.pageObjects.insurance.ViewNotePage;
import com.BCAA.neat.pageObjects.navigation.HomePage;
import com.BCAA.neat.pageObjects.navigation.InsurancePage;
import com.BCAA.neat.utils.JdbcDAO;

/**
 * This class covers all the flows as per Testlink
 * 
 * @author Optimus
 */

public class InsuranceLibrary {

	//private JdbcDAO database;

	private final static String H5_ADVANTAGE_HOME = "H5 ADVANTAGE HOME";
	private final static String C6_ADVANTAGE_HOME = "C6 Advantage Home";
	private final static String T6_ADVANTAGE_HOME = "T6 Advantage Home";
	
	Logger logger;
	CreateReceiptPage createReceipt;
	PosReceiptPage posReceipt;
	FindQuotesOrPolicyPage findQuotesOrPolicy;
	SelectInsurancePlanPage selectInsurancePlan;
	EditQuotesOrPolicyPage editQuotesOrPolicy;
	AssetsTabPage assetPage;
	AddOrEditAssetPage addOrEditAssetPage;
	RiskDetailsTabPage riskDetailTab;
	HomeEvaluationTabPage homeEvaluationTab;
	HomePage homePage;
	InsurancePage insurancePage;
	OptionsTabPage optionsTab;
	AddEditDeletePolicyOptionsPage addEditDeletePolicyOptions;
	EditInsuredPage editInsured;
	InsuredsTabPage insuredsTab;
	AddInsuredPage addInsured;
	PreviewDeclarationPages previewDeclarationPage;
	NotesTabPage notesTab;
	AddNotesPage addNote;
	RemarksTabPage remarksTab;
	EditHomeEvaluationPage editHomeEvaluation;
	InsuranceQuotePolicy insuranceQuotePolicy;
	ViewNotePage viewNotePage;
	OpenPaymentPlanPage openPaymentPlan;
	SafeHomeTabPage safeHomePage;
	BusinessTabPage businessTab;
	Browser browser;
	DropDown planDropdown;

	public InsuranceLibrary() {
		logger = Logger.getLogger(InsuranceLibrary.class);

		createReceipt = new CreateReceiptPage();
		posReceipt = new PosReceiptPage();
		findQuotesOrPolicy = new FindQuotesOrPolicyPage();
		selectInsurancePlan = new SelectInsurancePlanPage();
		editQuotesOrPolicy = new EditQuotesOrPolicyPage();
		createReceipt = new CreateReceiptPage();
		assetPage = new AssetsTabPage();
		addOrEditAssetPage = new AddOrEditAssetPage();
		riskDetailTab = new RiskDetailsTabPage();
		homeEvaluationTab = new HomeEvaluationTabPage();
		homePage = new HomePage();
		insurancePage = new InsurancePage();
		optionsTab = new OptionsTabPage();
		addEditDeletePolicyOptions = new AddEditDeletePolicyOptionsPage();
		editInsured = new EditInsuredPage();
		insuredsTab = new InsuredsTabPage();
		remarksTab = new RemarksTabPage();
		notesTab = new NotesTabPage();
		addNote = new AddNotesPage();
		previewDeclarationPage = new PreviewDeclarationPages();
		addInsured = new AddInsuredPage();
		editHomeEvaluation = new EditHomeEvaluationPage();
		insuranceQuotePolicy = new InsuranceQuotePolicy();
		viewNotePage = new ViewNotePage();
		openPaymentPlan = new OpenPaymentPlanPage();
		safeHomePage = new SafeHomeTabPage();
		businessTab = new BusinessTabPage();
		browser = new Browser();
	}

	/**
	 * Database connection
	 */

	/*public JdbcDAO getDatabase() {
		if (database == null) {
			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("Datasource.xml");
			return context.getBean(JdbcDAO.class);
		}
		return database;
	}*/

	/**
	 * TA-3904: Add Home Asset - Safe Home
	 */
	public void addHomeAsset() {
		logger.info("Add Home Asset - Safe Home");

		safeHomePage.addHomeAssetSafeHome();
	}

	/**
	 * TA-3907: Copy Quote
	 */
	public void copyQuote() {
		logger.info("Copying a quote");
		findQuotesOrPolicy.copyQuote();
		selectInsurancePlan.verifyCopySuccessMsg();
		selectInsurancePlan.clickOkBtn();
		editQuotesOrPolicy.verifyEditQuotePolicyHeader();
	}

	/**
	 * TA-3912: Create Receipt
	 */
	public void createReceipt() {
		logger.info("Creating receipt for a policy");

		createReceipt.selectCreateReceipt();
		posReceipt.createReceipt();
	}

	/**
	 * TA-3931: Find Quote
	 */
	public void searchByfirstandlastname() {
		goToFindQuotesAndPolicies();
		findQuotesOrPolicy.createQuote();
		selectInsurancePlan.selectInsurancePlan();
		TextBox quoteNumber = editQuotesOrPolicy.retrieveQuoteNumber();
		goToFindQuotesAndPolicies();
		findQuotesOrPolicy.searchQuotePolicywithQuoteNumber(quoteNumber);
		findQuotesOrPolicy.searchByFullName();
		findQuotesOrPolicy.policyMemberandAssociateNumber();
	}

	/**
	 * TA-3943: Commit Quote
	 * 
	 * @return
	 */
	public TextBox commitQuote(String selectPlan) {
		logger.info("Committing a quote");

		goToFindQuotesAndPolicies();
		findQuotesOrPolicy.createQuote();
		selectInsurancePlan.selectInsurancePlan();
		editQuotesOrPolicy.verifyDraftQuoteSuccessMessage();
		goToInsuredsTabAndEditInsured();
		createAsset(selectPlan);

		goToOptionsTabAndVerifyOptions();
		editQuotesOrPolicy.commitQuote();

		TextBox quoteNumber = editQuotesOrPolicy.retrieveQuoteNumber();

		return quoteNumber;

	}

	/**
	 * TA-3947: Issue Policy
	 * 
	 * @return TextBox Object which contains active policy number
	 */
	public TextBox issuePolicy(String selectPlan) {
		logger.info("Issuing a policy");

		commitQuote(selectPlan);
		addRemarkaddNotePreviewDecIssuePolicy();

		TextBox activePolicyNumber = createReceipt.getActivePolicyNum();

		createReceipt();
		return activePolicyNumber;
	}

	/**
	 * 
	 * TA-3950: Find Policy and Endorse it
	 */
	public void issueAnEndorsedPolicy(String selectPlan) {
		logger.info("Searching an active policy and endorsing it");

		TextBox activePolicyNumber = issuePolicy(selectPlan);

		searchQuotePolicy(activePolicyNumber);
		findQuotesOrPolicy.selectActivePolicy();
		findQuotesOrPolicy.clickOnEndorsePolicyBtn();
		selectInsurancePlan.clickOkBtn();
		editQuotesOrPolicy.verifyEndorsePolicySuccessMessage();
	}

	/**
	 *TA-3956: Open Payment Plan
	 */
	public void openPaymentPlan(String selectPlan) {
		logger.info("Opening a payment plan on an Issued policy");

		commitQuote(selectPlan);
		goToRemarksAndAddRemark();
		
		editQuotesOrPolicy.issuePolicy();
		
		createReceipt.selectOpenPaymentPlan();
		
		openPaymentPlan.openPaymentPlan();
		
		editQuotesOrPolicy.verifyPolicyOpenSuccessMessage();
	}

	/**
	 * TA-3957: Cancel Policy
	 */
	public void cancelPolicy() {
		logger.info("Selecting a policy to be cancelled");

		findQuotesOrPolicy.selectActivePolicy();
		findQuotesOrPolicy.clickEditBtn();

		editQuotesOrPolicy.selectCancelPolicy();

		insuranceQuotePolicy.verifyCancelPolicyHeader();
		insuranceQuotePolicy.selectReasonDropDown();
		insuranceQuotePolicy.clickOnRecalcualteRefundBtn();
		insuranceQuotePolicy.clickOkButton();
		insuranceQuotePolicy.verifyPopUp();

		findQuotesOrPolicy.verifyCancelledMessage();
	}
	
	public void selectActivePolicyRenewalAndThenCancelPolicy() {
		logger.info("Selecting a policy to be cancelled");

		findQuotesOrPolicy.selectActiveRenewalPolicy();
		findQuotesOrPolicy.clickEditBtn();

		editQuotesOrPolicy.selectCancelPolicy();

		insuranceQuotePolicy.verifyCancelPolicyHeader();
		insuranceQuotePolicy.selectReasonDropDown();
		insuranceQuotePolicy.clickOnRecalcualteRefundBtn();
		insuranceQuotePolicy.clickOkButton();
		insuranceQuotePolicy.verifyPopUp();

		findQuotesOrPolicy.verifyCancelledMessage();
	}

	/**
	 * TA-3959: Reinstate a Policy
	 */

	public void reinstatePolicy(TextBox quoteNumber){
		logger.info("Selecting a policy to be Reinstate after it was cancelled");

		findQuotesOrPolicy.searchQuotePolicywithQuoteNumber(quoteNumber);
		findQuotesOrPolicy.selectCancelledPolicy();

		findQuotesOrPolicy.clickReinstatePolicyBtn();

		createReceipt.verifyCreateReceiptHeader();
		createReceipt.clickOnCancelButton();

		editQuotesOrPolicy.activePolicyReinstate();
		editQuotesOrPolicy.clickFindPolicyBtn();

		findQuotesOrPolicy.verifyActivePolicyEndorsementInStatus();

	}

	/**
	 * TA-3961: Void a Policy
	 */
	public void voidAPolicy() {
		logger.info("Void a policy");

		findQuotesOrPolicy.selectActivePolicy();

		findQuotesOrPolicy.clickEditBtn();

		editQuotesOrPolicy.verifyEditQuotePolicyHeader();
		editQuotesOrPolicy.clickOnVoidPolicyBtn();

		insuranceQuotePolicy.verifyVoidPolicyHeader();
		insuranceQuotePolicy.sendYesInPolicyVoidTextBox();
		insuranceQuotePolicy.clickOnVoidPolicyOkBtn();

		findQuotesOrPolicy.verifyVoidPolicyStatus();
	}

	/**
	 * TA-3966: Add Home Asset - Business
	 */
	public void addHomeAssetBusiness() {
		logger.info("Add Home Asset Business");
		goToFindQuotesAndPolicies();
		findQuotesOrPolicy.createQuote();
		selectInsurancePlan.selectInsurancePlan();
		goToInsuredsTabAndEditInsured();
		createAsset(H5_ADVANTAGE_HOME);
		assetPage.selectEditHomeAssetTab();
		addOrEditAssetPage.goToBusinessTab();
		businessTab.addHomeAssetBusiness();
		editQuotesOrPolicy.verifyBusinessSucessMessage();

	}

	/**
	 * TA-3969: Edit Home Asset - Switch RCT to Appraisal
	 */
	public void switchRctToAppraisalEvaluation() {
		logger.info("Switching RCT evaluation to Appraisal");

		addOrEditAssetPage.goToHomeEvaluationTab();
		editHomeEvaluation.switchRctToAppraisal();
		addOrEditAssetPage.goToRiskDetailsTab();
		riskDetailTab.selectPrimaryHeating();
		editHomeEvaluation.selectOkBtn();
		editQuotesOrPolicy.verifyEditQuotePolicyHeader();
		assetPage.clickOnEditButton();
	}

	/**
	 * TA-3972: Insureds - Set Additional Insured as Primary Policyholder
	 */
	public void goToInsuredsTabAndEditPrimaryPolicyHolder() {
		logger.info("Editing primary holder of a policy");

		goToInsuredsTabAndEditInsured();
		insuredsTab.selectAddInsuredTab();
		addInsured.addInsured();
		insuredsTab.selectEditAdditionalInsured();
		
		editInsured.verifyEditInsuredText();
		editInsured.setInsuredAsPrimaryHolder();
		editInsured.editInsuredDetails();
		editInsured.verifyPrimaryNonPrimaryHolders();
		
		editQuotesOrPolicy.verifyEditInsuredSuccessMessage();
		
		insuredsTab.selectDeleteBtn(); // to reload the page internally,
										// since the code was
		// unable to click on any other tab
	}
	
	public void goToInsuredsTabAndAddInsured() {
		logger.info("Editing primary holder of a policy");

		editQuotesOrPolicy.goToInsuredsTab();
		insuredsTab.selectAddInsuredTab();
		addInsured.addInsured();
		editQuotesOrPolicy.verifyInsuredSucessMessage();
		insuredsTab.selectDeleteBtn(); // to reload the page internally,
		// since the code was
        // unable to click on any other tab
	}
		
	/**
	 * TA-3979: Delete Insured
	 */
	public void deleteInsured() {
		logger.info("Deleting an insured policy member");

		insuredsTab.deleteInsuredBtn();
		editQuotesOrPolicy.verifyInsuredDeletedSucessMessage();
	}

	/**
	 * TA-3983: Create Asset
	 */
	public void createAsset(String selectPlan) {
		logger.info("Creating an asset - Home");
		
		editQuotesOrPolicy.goToAssetsTab();
		assetPage.selectAddAsset();
		addOrEditAssetPage.addHomeAsset(selectPlan);
		addOrEditAssetPage.goToRiskDetailsTab();
		riskDetailTab.addRiskDetails();
		addOrEditAssetPage.goToHomeEvaluationTab();
		homeEvaluationTab.addHomeEvaluation();
	}

	/**
	 * TA-3986: Create Habitational Draft Quote
	 */
	public void createQuoteWithMemberID() {
		logger.info("Creating a quote with a member ID");

		goToFindQuotesAndPolicies();
		findQuotesOrPolicy.createQuote();
		selectInsurancePlan.verifySelectInsurancePlanHeader();
		selectInsurancePlan.selectInsurancePlan();
		editQuotesOrPolicy.verifyDraftQuoteSuccessMessage();
	}
	
	/**
	 * TA-3986: Create Habitational Draft Quote
	 */
	public void createQuoteWithNonMemberID() {
		logger.info("Creating a quote with a member ID");

		goToFindQuotesAndPolicies();
		findQuotesOrPolicy.nonAssociateNumberCreateQuote();
		selectInsurancePlan.verifySelectInsurancePlanHeader();
		selectInsurancePlan.selectInsurancePlan();
		editQuotesOrPolicy.verifyDraftQuoteSuccessMessage();
	}
	
	

	/**
	 * TA-3987: Go To Find Insurance Quote/Policy
	 */
	public void goToFindQuotesAndPolicies() {
		logger.info("Navigating to Quotes and Policies tab");

		homePage.selectInsuranceTab();
		insurancePage.goToQuotesAndPoliciesTab();
	}


	/**
	 * TA-3997: Go To Options and Verify Options
	 */
	public void goToOptionsTabAndVerifyOptions() {
		logger.info("Verifying options for a policy");

		editQuotesOrPolicy.goToOptionsTab();
		optionsTab.selectAPolicyAndClickVerifyOptions();
		optionsTab.clickAddEditDeleteOptionsButton();
		addEditDeletePolicyOptions.removePolicyWithNoPremium();
		optionsTab.clickShowAllBtn();
	}
	
	/**
	 * TA-3997: Go To Options Tab and Verify Condo Options 
	 */
	public void goToOptionsTabAndVerifyCondoOptions(){
		logger.info("Verifying Condo options for a policy");
		editQuotesOrPolicy.goToOptionsTab();
		optionsTab.selectCondoAdvantageHomeInsurance();
		optionsTab.clickAddEditDeleteOptionsButton();
		addEditDeletePolicyOptions.condoVerifyOptions();
		addEditDeletePolicyOptions.removePolicyWithNoPremium();
		optionsTab.clickShowAllBtn();
		optionsTab.selectAPolicyAndClickVerifyOptions();		
	}
	
	/**
	 * TA-4000: Go To Insureds and Edit Insured
	 */
	public void goToInsuredsTabAndEditInsured() {
		logger.info("Editing an insured member of a policy");

		editQuotesOrPolicy.goToInsuredsTab();
		insuredsTab.selectEditInsuredBtn();
		editInsured.verifyEditInsuredText();
		editInsured.editInsuredDetails();
		editQuotesOrPolicy.verifyEditInsuredSuccessMessage();
		insuredsTab.selectDeleteBtn();
	}

	/**
	 * TA-4001: Go To Notes and Add Note
	 */
	public void goToNotesAndAddNote() {
		logger.info("Adding Notes in Notes Page");

		editQuotesOrPolicy.goToNotesTab();
		notesTab.selectAddBtn();
		addNote.addANewNote();
		editQuotesOrPolicy.verifyEditQuotePolicyHeader();
		notesTab.verifyMessageAfterAddingNote();
		notesTab.selectEditBtn();
	}

	/**
	 * TA-4002: Add Remark, Add Note, Preview Dec, Issue Policy
	 */
	public void addRemarkaddNotePreviewDecIssuePolicy() {
		logger.info("Adding Remarks, Notes, Previewing Declaration and selecting Issue Policy");

		goToNotesAndAddNote();
		goToRemarksAndAddRemark();
		previewDeclarationPage.verifyPdfThroughPreviewBtn();
		editQuotesOrPolicy.issuePolicy();
	}

	/**
	 * TA-4003: Go To Remarks and Add Remark
	 */
	public void goToRemarksAndAddRemark() {
		logger.info("Adding Remarks in Remarks tab");

		editQuotesOrPolicy.goToRemarksTab();
		remarksTab.addRemarks();
	}

	/**
	 * TA-4004: Go To Options and Edit Option
	 */
	public void goToOptionsAndEditOptions() {
		logger.info("Options and Edit Options");
		editQuotesOrPolicy.goToOptionsTab();
		optionsTab.selectAPolicyAndClickVerifyOptions();
		optionsTab.selectingOptionOnOptionTab();
		optionsTab.clickAddEditDeleteOptionsButton();
		addEditDeletePolicyOptions.addingLiabilityIncreaseLimit();
		editQuotesOrPolicy.verifyEditQuotePolicyHeader();
		optionsTab.selectAPolicyAndClickVerifyOptions();
	}

	/**
	 * TA-4005: Go to Assets and Edit Home Evaluation
	 */
	public void assetsAndEditHomeEvaluation() {
		logger.info("Assets And Edit Home Evaluation");

		editQuotesOrPolicy.goToAssetsTab();
		assetPage.selectEditHomeAssetTab();
		addOrEditAssetPage.goToHomeEvaluationTab();
		editHomeEvaluation.editHomeEvaluation();
		editQuotesOrPolicy.verifyEditQuotePolicyHeader();
		assetPage.clickOnEditButton();
	}

	/**
	 * TA-4011: Add Remark, Edit Insured, Commit Quote, Issue Policy
	 */
	public void addRemarkEditInsuredCommitQuoteIssuePolicy() {
		logger.info("Adding remarks, editing an insured member, Commiting and issuing a policy");

		goToRemarksAndAddRemark();
		goToInsuredsTabAndEditInsured();
		editQuotesOrPolicy.commitQuote();
		editQuotesOrPolicy.issuePolicy();
	}

	/**
	 * TA-4012: Find Policy and Endorse it
	 * 
	 * @param selectPlan
	 *            H1_ADVANTAGE_HOME or H5_ADVANTAGE_HOME
	 */
	public void endorsePolicy(String selectPlan) {
		logger.info("Searching an active policy and endorsing it");

		TextBox activePolicyNumber = issuePolicy(selectPlan);

		searchQuotePolicy(activePolicyNumber);
		findQuotesOrPolicy.selectActivePolicy();
		findQuotesOrPolicy.clickOnEndorsePolicyBtn();
		selectInsurancePlan.clickOkBtn();
		editQuotesOrPolicy.verifyEndorsePolicySuccessMessage();
	}

	/**
	 * TA-4016: Go to Find Quote/Policy and Find Quote/Policy
	 */
	public void searchQuotePolicy(TextBox quoteNo) {
		logger.info("Navigating to Find Quotes Policy page and searching for a quote/policy");

		goToFindQuotesAndPolicies();
		findQuotesOrPolicy.searchQuotePolicywithQuoteNumber(quoteNo);
	}

	/**
	 * TA-4019: Go to Assets and Edit Safe Home
	 */
	public void goToAssetsAndEditSafeHome() {
		logger.info("Navigating to Safe Home Page and add safe options ");
		
		editQuotesOrPolicy.goToAssetsTab();
		assetPage.selectEditHomeAssetTab();
		addOrEditAssetPage.goToSafeHomeTab();
		safeHomePage.addHomeAssetSafeHome();
	}
	
	/**
	 * TA-4019: Go to Assets and Edit Safe Home
	 */
	public void goToAssetsAndRemoveSafeHomeOptions() {
		logger.info("Navigating to Safe Home Page and remove home options ");

		editQuotesOrPolicy.goToAssetsTab();
		assetPage.selectEditHomeAssetTab();
		addOrEditAssetPage.goToSafeHomeTab();
		safeHomePage.removeHomeAssetSafeHome();
	}

	

	/**
	 * TA-4024: View Notes
	 */
	public void viewNotes() {
		logger.info("Viewing an existing note");

		notesTab.selectViewNoteBtn();
		viewNotePage.viewNote();
		editQuotesOrPolicy.verifyEditQuotePolicyHeader();
	}

	/**
	 * Redmine Ticket - https://portal.optimusinfo.com/redmine/issues/62070
	 */
	public void editAQuote() {
		logger.info("Selecting a quote to be edited");

		createQuoteWithMemberID();

		TextBox quoteNumber = editQuotesOrPolicy.retrieveQuoteNumber();

		goToFindQuotesAndPolicies();
		findQuotesOrPolicy.selectQuoteOrPolicyToEdit(quoteNumber);
		editQuotesOrPolicy.verifyEditQuotePolicyHeader();
	}

	/**
	 * Redmine Ticket - https://portal.optimusinfo.com/redmine/issues/62070
	 */
	public void editAPolicy(String selectPlan) {
		logger.info("Selecting a policy to be edited");

		TextBox activePolicyNumber = issuePolicy(selectPlan);

		goToFindQuotesAndPolicies();
		findQuotesOrPolicy.selectQuoteOrPolicyToEdit(activePolicyNumber);
		editQuotesOrPolicy.verifyEditQuotePolicyHeader();
	}

	/**
	 * create Asset with a dangerous pet binding stop
	 */
	public void createAssetWithPetBinding() {
		logger.info("Create Asset With Pet Binding ");

		editQuotesOrPolicy.goToAssetsTab();
		assetPage.selectAddAsset();
		addOrEditAssetPage.addHomeAsset(H5_ADVANTAGE_HOME);
		addOrEditAssetPage.goToRiskDetailsTab();
		riskDetailTab.addRiskDetailsWithPetBinding();
		addOrEditAssetPage.goToHomeEvaluationTab();
		homeEvaluationTab.addHomeEvaluation();
	}

	/**
	 * create Asset for a Home
	 */
	public void createHomeAsset() {
		logger.info("Create Home Asset");
		editQuotesOrPolicy.goToAssetsTab();
		assetPage.selectAddAsset();
		addOrEditAssetPage.addHomeAsset(H5_ADVANTAGE_HOME);
		addOrEditAssetPage.goToRiskDetailsTab();
		riskDetailTab.addRiskDetails();
		addOrEditAssetPage.goToHomeEvaluationTab();
		homeEvaluationTab.addHomeEvaluation();
	}

	/**
	 * create Asset for a Condo
	 */
	public void createCondoAsset() {

		logger.info("Create Condo Asset");
		editQuotesOrPolicy.goToAssetsTab();
		assetPage.selectAddAsset();
		addOrEditAssetPage.addCondoAsset(C6_ADVANTAGE_HOME);
		addOrEditAssetPage.goToRiskDetailsTab();
		riskDetailTab.addRiskDetailsForCondoAssets();
		addOrEditAssetPage.goToHomeEvaluationTab();
		homeEvaluationTab.addCondoEvaluation();
	}

	/**
	 * create Asset for a Tenant
	 */
	public void createTenantAsset() {
		logger.info("Create Tenant Asset");
		editQuotesOrPolicy.goToAssetsTab();
		assetPage.selectAddAsset();
		addOrEditAssetPage.addTenantAsset(T6_ADVANTAGE_HOME);
		addOrEditAssetPage.goToRiskDetailsTab();
		riskDetailTab.addRiskDetailsForCondoAssets();
		addOrEditAssetPage.goToHomeEvaluationTab();
		homeEvaluationTab.addCondoEvaluation();
	}

	/**
	 * Module to renew a policy which is in Active Renew state
	 */
	public void renewPolicy(TextBox activeRenewalPolicyNum) {
		
		goToFindQuotesAndPolicies();
		
		findQuotesOrPolicy.clearMemberData();		
		findQuotesOrPolicy.searchQuotePolicywithQuoteNumber(activeRenewalPolicyNum);
		findQuotesOrPolicy.selectActiveRenewalPolicy();
		findQuotesOrPolicy.clickRenewPolicyButton();
		findQuotesOrPolicy.verifyAndSelectDraftQuoteRenewal();
		findQuotesOrPolicy.clickEditBtn();
		
		editQuotesOrPolicy.verifyEditQuotePolicyHeader();
		
		
	}
	
	/**
	 *  Create Second Asset
	 */
	public void createSecondAsset(String selectPlan) {
		logger.info("Creating an asset - Home");

		editQuotesOrPolicy.goToAssetsTab();
		assetPage.selectAddAsset();
		addOrEditAssetPage.addHomeAsset(selectPlan);
		addOrEditAssetPage.goToRiskDetailsTab();
		riskDetailTab.addRiskDetailsWithoutLocation();
		addOrEditAssetPage.goToHomeEvaluationTab();
		homeEvaluationTab.addHomeEvaluation();
	}
	
	
}
