package com.BCAA.neat.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.baseInsurance.InsuranceLibrary;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.pageObjects.epp.OpenPaymentPlanPage;
import com.BCAA.neat.pageObjects.insurance.AddExternalClaimPage;
import com.BCAA.neat.pageObjects.insurance.AddOrEditAssetPage;
import com.BCAA.neat.pageObjects.insurance.AssetsTabPage;
import com.BCAA.neat.pageObjects.insurance.AuthorizationsPage;
import com.BCAA.neat.pageObjects.insurance.BusinessTabPage;
import com.BCAA.neat.pageObjects.insurance.ClaimsTabPage;
import com.BCAA.neat.pageObjects.insurance.CreateReceiptPage;
import com.BCAA.neat.pageObjects.insurance.EditHomeEvaluationPage;
import com.BCAA.neat.pageObjects.insurance.EditQuotesOrPolicyPage;
import com.BCAA.neat.pageObjects.insurance.FindQuotesOrPolicyPage;
import com.BCAA.neat.pageObjects.insurance.InsuredsTabPage;
import com.BCAA.neat.pageObjects.insurance.OptionsTabPage;
import com.BCAA.neat.pageObjects.insurance.RiskDetailsTabPage;
import com.BCAA.neat.pageObjects.insurance.SelectInsurancePlanPage;
import com.BCAA.neat.pageObjects.logIn.LoginPage;
import com.BCAA.neat.pageObjects.navigation.HomePage;
import com.BCAA.neat.pageObjects.navigation.InsurancePage;
import com.BCAA.neat.utils.TestListener2;

/**
 * 
 * This class covers the Test cases as per Testlink
 * 
 * @author Optimus
 */

public class HabitationalTests {

	private final static String H5_ADVANTAGE_HOME = "H5 ADVANTAGE HOME";
	private final static String H1_ADVANTAGE_HOME = "H1 ADVANTAGE HOME";
	private final static String C6_ADVANTAGE_HOME = "C6 Advantage Home";
	private final static String T6_ADVANTAGE_HOME = "T6 Advantage Home";
	private final static String ACTIVE_RENEWED = "G7045057";
	private final static int TWO_DAY_AFTER_EXPIRY = 2;

	Logger logger;
	InsuredsTabPage insuredsTabPage;
	InsuranceLibrary insurance;
	CreateReceiptPage createReceipt;
	Browser browser;
	LoginPage loginPage;
	EditQuotesOrPolicyPage editQuotesOrPolicy;
	AddExternalClaimPage addExternalClaim;
	ClaimsTabPage claims;
	FindQuotesOrPolicyPage findQuotesOrPolicy;
	OptionsTabPage optionsTabPage;
	InsurancePage insurancePage;
	AuthorizationsPage authorizationsPage;
	AddOrEditAssetPage addOrEditAssetPage;
	AssetsTabPage assetsTabPage;
	EditHomeEvaluationPage editHomeEvaluation;
	BusinessTabPage businessTab;
	SelectInsurancePlanPage selectInsurancePlan;
	AssetsTabPage assetPage;
	RiskDetailsTabPage riskDetailTab;
	TextBox activeRenewedNum;
	OpenPaymentPlanPage openPaymentPlan;
	HomePage homePage;
	TextBox activePolicy;

	public HabitationalTests() {
		logger = Logger.getLogger(HabitationalTests.class);

		insurance = new InsuranceLibrary();
		insuredsTabPage = new InsuredsTabPage();
		browser = new Browser();
		loginPage = new LoginPage();
		editQuotesOrPolicy = new EditQuotesOrPolicyPage();
		addExternalClaim = new AddExternalClaimPage();
		claims = new ClaimsTabPage();
		findQuotesOrPolicy = new FindQuotesOrPolicyPage();
		insurancePage = new InsurancePage();
		optionsTabPage = new OptionsTabPage();
		authorizationsPage = new AuthorizationsPage();
		addOrEditAssetPage = new AddOrEditAssetPage();
		assetsTabPage = new AssetsTabPage();
		editHomeEvaluation = new EditHomeEvaluationPage();
		businessTab = new BusinessTabPage();
		selectInsurancePlan = new SelectInsurancePlanPage();
		createReceipt = new CreateReceiptPage();
		editQuotesOrPolicy = new EditQuotesOrPolicyPage();
		assetPage = new AssetsTabPage();
		riskDetailTab = new RiskDetailsTabPage();
		openPaymentPlan = new OpenPaymentPlanPage();
		activeRenewedNum = new TextBox(ACTIVE_RENEWED);
		homePage = new HomePage();
	}

	@BeforeClass
	public void initialSetUp() {
		PropertyConfigurator.configure("log4j.properties");

		logger.info("Executing before class method");

		browser.startBrowser();
		browser.navigateTo();
		loginPage.signIn();
		homePage.waitTillHouseHoldInfoToAppear();
		homePage.verifyLogin();
		homePage.selectInsuranceTab();

	}

	/**
	 * Smoke Test
	 * 
	 */

	@Test(description = "Smoke Test",retryAnalyzer=TestListener2.class)
	public void SmokeTest() {
		logger.info("Executing Smoke Test");

		insurance.commitQuote(H5_ADVANTAGE_HOME);
		insurance.addRemarkaddNotePreviewDecIssuePolicy();
		insurance.createReceipt();

	}

	/**
	 * BCAA-3953: Create and Delete External Claim
	 */

	@Test(description = "BCAA-3953: Create and Delete External Claim",retryAnalyzer=TestListener2.class)
	public void createAndDeleteExternalClaimTest() {
		logger.info("Executing test case BCAA-3953");

		insurance.goToFindQuotesAndPolicies();
		insurance.createQuoteWithMemberID();

		editQuotesOrPolicy.goToClaimsTab();

		claims.selectAddExternalClaimTab();

		addExternalClaim.createExternalClaim();

		claims.deleteExternalClaim();
	}

	/**
	 * BCAA-3973:Set an additional insured as the primary policyholder
	 */

	@Test(description = "BCAA-3973:Set an additional insured as the primary policyholder",retryAnalyzer=TestListener2.class)
	public void additionalInsuredAsPrimaryPolicyholderTest() {
		logger.info("Executing test case BCAA-3973");

		insurance.goToFindQuotesAndPolicies();
		insurance.createQuoteWithMemberID();
		insurance.goToInsuredsTabAndEditPrimaryPolicyHolder();
	}

	/**
	 * BCAA-3962: Void a Policy
	 */

	@Test(description = "BCAA-3962: Void a Policy")
	public void voidPolicy() {
		logger.info("Executing test case BCAA-3962");

		TextBox activePolicyNumber = insurance.issuePolicy(H5_ADVANTAGE_HOME);

		insurance.searchQuotePolicy(activePolicyNumber);
		insurance.voidAPolicy();
	}

	/**
	 * BCAA-3960: Reinstate a Policy
	 */
	@Test(description = "BCAA-3960: Reinstate a Policy")
	public void reinstatePolicy() {
		logger.info("Executing test case BCAA-3960");

		TextBox activePolicyNumber = insurance.issuePolicy(H5_ADVANTAGE_HOME);

		insurance.searchQuotePolicy(activePolicyNumber);
		insurance.cancelPolicy();
		insurance.reinstatePolicy(activePolicyNumber);

	}

	/**
	 * TA-3946: Commit Quote, Copy and Issue a Policy
	 */

	@Test(description = "TA-3946:Commit Quote, Copy and Issue a Policy")
	public void commitQuoteCopyAndIssuePolicyTest() {
		logger.info("Executing test case BCAA-3946");

		TextBox quoteNumber = insurance.commitQuote(H5_ADVANTAGE_HOME);

		insurance.searchQuotePolicy(quoteNumber);
		insurance.copyQuote();
		insurance.goToOptionsTabAndVerifyOptions();
		insurance.addRemarkaddNotePreviewDecIssuePolicy();
		insurance.createReceipt();

	}

	/**
	 * TA-3950: Issue an Endorsed Policy
	 * 
	 * @return Active Policy number
	 */
	//@Test(description = "Test Case TA-3950: Issue an Endorsed Policy")
	public void issueAnEndorsedPolicy() {
		logger.info("Executing test case TA-3950");

		insurance.endorsePolicy(H5_ADVANTAGE_HOME);
		insurance.assetsAndEditHomeEvaluation();
		insurance.goToOptionsAndEditOptions();
		insurance.addRemarkaddNotePreviewDecIssuePolicy();

		activePolicy = createReceipt.getActivePolicyNum();

		insurance.createReceipt();

	}

	/**
	 * BCAA-3965: Endorse a Policy (Multiple Times) with Home Business Added
	 */
	//@Test(description = "BCAA-3965: Endorse a Policy (Multiple Times) with Home Business Added")
	public void endorseAPolicyWithHomeBusiness() {
		logger.info("Executing BCAA-3965");

		issueAnEndorsedPolicy();

		insurance.searchQuotePolicy(activePolicy);
		insurance.endorsePolicy(H5_ADVANTAGE_HOME);

		editQuotesOrPolicy.goToAssetsTab();

		assetPage.selectEditHomeAssetTab();

		addOrEditAssetPage.goToHomeEvaluationTab();

		editHomeEvaluation.editHomeEvaluation();

		insurance.addHomeAssetBusiness();
		insurance.goToOptionsTabAndVerifyOptions();

		editQuotesOrPolicy.commitQuote();

		insurance.addRemarkaddNotePreviewDecIssuePolicy();
	}

	/**
	 * BCAA-4015:Trigger an authorization and have someone with authority to use
	 * the “Override Sign In” link
	 * 
	 */
	//@Test(description = "BCAA-4015:Trigger an authorization and have someone with authority to use the “Override Sign In” link")
	public void overrideSignInTest() {
		logger.info("Executing test case BCAA-4015");

		insurance.createQuoteWithMemberID();
		insurance.createAssetWithPetBinding();

		editQuotesOrPolicy.goToOptionsTab();

		optionsTabPage.clickAuthorizationsBtn();

		insurancePage.verifyOverrideUserSignOut();
		insurancePage.overrideSignIn();

		authorizationsPage.selectPetAsset();
		authorizationsPage.clickAuthorizationsBtn();
		authorizationsPage.verifyBindingStop();
		authorizationsPage.clickOkBtn();

		insurancePage.overrideSignOut();
		insurancePage.verifyOverrideUserSignOut();
	}

	/**
	 * BCAA-4026:Endorse Effective Date that falls between the original policy's
	 * Effective and Expiry dates
	 */

	//@Test(description = "BCAA-4026:Endorse Effective Date that falls between the original policy's Effective and Expiry dates")
	public void endorsemenEffectiveDatebetweenOriginalAndExpiryDates() {
		logger.info("Executing test case BCAA-4026");

		TextBox activePolicyNumber = insurance.issuePolicy(H5_ADVANTAGE_HOME);

		insurance.searchQuotePolicy(activePolicyNumber);

		findQuotesOrPolicy.selectActivePolicy();
		findQuotesOrPolicy.clickOnEndorsePolicyBtn();

		selectInsurancePlan.setBeforeAndAfterCurrentDate(5);
		selectInsurancePlan.clickOkBtn();

		editQuotesOrPolicy.verifyEndorsePolicySuccessMessage();

		insurance.goToRemarksAndAddRemark();
		insurance.goToInsuredsTabAndEditInsured();

		editQuotesOrPolicy.selectCommitQuoteButtonOnly();

		insuredsTabPage.selectEditButton();

		insurance.addRemarkaddNotePreviewDecIssuePolicy();

		activePolicy = createReceipt.getActivePolicyNum();

	}

	/**
	 * BCAA-4025:Endorsement Effective Date later the original Expiry Date
	 */
	//@Test(description = "BCAA-4025:Endorsement Effective Date later the original Expiry Date")
	public void endorsementEffectiveDateEarlierThanOriginalEffectiveDate() {
		logger.info("Executing test case BCAA-4025");

		TextBox activePolicyNumber = insurance.issuePolicy(H5_ADVANTAGE_HOME);

		insurance.searchQuotePolicy(activePolicyNumber);

		findQuotesOrPolicy.selectActivePolicy();
		findQuotesOrPolicy.clickOnEndorsePolicyBtn();

		selectInsurancePlan.setAfterExpiryDate(TWO_DAY_AFTER_EXPIRY);
		selectInsurancePlan.clickOkBtn();
		selectInsurancePlan.verifyErrorAfterExpiryDate();
		selectInsurancePlan.verifyErrorAfterExpiryDate();
	}

	/**
	 * TA-3964: Commit Quote ,Copy and Issue a Policy with Multiple Assets
	 */

	//@Test(description = "BCAA-3964: Commit Quote ,Copy and Issue a Policy with Multiple Assets")
	public void commitCopyAndIssuePolicyWithMultipleAssets() {
		logger.info("Executing test case BCAA-3964");

		insurance.createQuoteWithMemberID();
		insurance.goToInsuredsTabAndEditInsured();
		insurance.createHomeAsset();
		insurance.createCondoAsset();
		insurance.goToOptionsTabAndVerifyCondoOptions();

		TextBox quoteNumber = editQuotesOrPolicy.commitQuote();

		insurance.searchQuotePolicy(quoteNumber);
		insurance.copyQuote();
		insurance.goToOptionsTabAndVerifyOptions();
		insurance.addRemarkaddNotePreviewDecIssuePolicy();
		insurance.createReceipt();
	}

	/**
	 * BCAA-3971: Endorse a Policy (Upgrade from H1 to H5)
	 */
	//@Test(description = "BCAA-3971: Endorse a Policy (Upgrade from H1 to H5)")
	public void endorseAPolicy() {
		logger.info("Executing test case BCAA-3971");

		insurance.endorsePolicy(H1_ADVANTAGE_HOME);

		editQuotesOrPolicy.goToAssetsTab();
		editQuotesOrPolicy.selectExistingAssets();
		editQuotesOrPolicy.clickOnEditButton();

		addOrEditAssetPage.editAssetPlan(H5_ADVANTAGE_HOME);
		addOrEditAssetPage.clickOnOkButton();

		assetsTabPage.clickOnEditButton();

		insurance.goToOptionsTabAndVerifyOptions();

		editQuotesOrPolicy.selectCommitQuoteButtonOnly();
		editQuotesOrPolicy.selectShowAllBtn();

		insurance.addRemarkaddNotePreviewDecIssuePolicy();
	}

	/**
	 * TA-3968: Endorse a Policy (RCT to Appraisal)
	 */
	//@Test(description = "TA-3968: Endorse a Policy (RCT to Appraisal)")
	public void endorsePolicyRctToAppraisal() {
		logger.info("Executing test case TA-3968");

		insurance.endorsePolicy(H1_ADVANTAGE_HOME);

		editQuotesOrPolicy.goToAssetsTab();

		assetsTabPage.selectEditHomeAssetTab();

		insurance.switchRctToAppraisalEvaluation();
		insurance.goToOptionsTabAndVerifyOptions();

		editQuotesOrPolicy.selectCommitQuoteButtonOnly();
		editQuotesOrPolicy.selectShowAllBtn();

		insurance.addRemarkaddNotePreviewDecIssuePolicy();
		insurance.createReceipt();
	}

	/**
	 * TA-3976: Member related discounts should be removed when member is
	 * removed
	 */
	//@Test(description = "TA-3976: Member related discounts should be removed when member is removed")
	public void memberRelatedDiscounts() {
		logger.info("Executing test case TA-3976");

		insurance.createQuoteWithNonMemberID();
		insurance.createAsset(H5_ADVANTAGE_HOME);

		editQuotesOrPolicy.goToOptionsTab();

		optionsTabPage.selectAPolicyAndClickVerifyOptions();

		editQuotesOrPolicy.verifyNonBCAADiscountMessage();

		insurance.goToInsuredsTabAndAddInsured();

		editQuotesOrPolicy.goToOptionsTab();

		optionsTabPage.selectAPolicyAndClickVerifyOptions();

		editQuotesOrPolicy.verifyBCAADiscountMessage();
		editQuotesOrPolicy.goToInsuredsTab();

		insurance.deleteInsured();

		editQuotesOrPolicy.verifyInsuredDeletedSucessMessage();
		editQuotesOrPolicy.goToOptionsTab();

		optionsTabPage.selectAPolicyAndClickVerifyOptions();

		editQuotesOrPolicy.verifyRemovedBCAAMemberMessage();
	}

	/**
	 * BCAA-3981: Safe Home points is adjusted accordingly when Safe Home points
	 * are earned or lost
	 */

	//@Test(description = "BCAA-3981: Safe Home points is adjusted accordingly when Safe Home points are earned or lost")
	public void verifySafeHomePointsAdjusted() {
		logger.info("Executing test case BCAA-3981");

		insurance.goToFindQuotesAndPolicies();
		insurance.createQuoteWithMemberID();
		insurance.goToInsuredsTabAndEditInsured();
		insurance.createAsset(H1_ADVANTAGE_HOME);
		insurance.goToOptionsTabAndVerifyOptions();
		insurance.goToAssetsAndEditSafeHome();

		editQuotesOrPolicy.goToOptionsTab();

		optionsTabPage.selectAPolicyAndClickVerifyOptions();
		optionsTabPage.verifyDiscount();

		insurance.goToAssetsAndRemoveSafeHomeOptions();

		editQuotesOrPolicy.goToOptionsTab();

		optionsTabPage.selectAPolicyAndClickVerifyOptions();
		optionsTabPage.verifyRemoveDiscount();
	}

	/**
	 * BCAA-4018: Remove FUS Override on Edit Asset page
	 */

	//@Test(description = "BCAA-4018:  Remove FUS Override on Edit Asset page")
	public void verifyRemoveFUSOverride() {
		logger.info("Executing test case BCAA-4018");

		insurance.goToFindQuotesAndPolicies();
		insurance.createQuoteWithMemberID();
		insurance.goToInsuredsTabAndEditInsured();
		insurance.createAsset(H1_ADVANTAGE_HOME);

		editQuotesOrPolicy.goToAssetsTab();

		assetPage.selectEditHomeAssetTab();

		riskDetailTab.selectfirehallDistanceLookupCodeDropdown();
		riskDetailTab.clickRemoveFireProtectionButton();
		riskDetailTab.verifyFireProtectionMessage();
	}

	/**
	 * BCAA-4013: Adding a 2nd location asset with a different liability should
	 * result to error
	 */

	//@Test(description = "BCAA-4013: Adding a 2nd location asset with a different liability should result to error")
	public void verifyAdding2ndlocationasset() {
		logger.info("Executing test case BCAA-4013");

		insurance.endorsePolicy(H5_ADVANTAGE_HOME);
		insurance.goToInsuredsTabAndEditInsured();
		insurance.createSecondAsset(H5_ADVANTAGE_HOME);
		insurance.goToOptionsTabAndVerifyOptions();
		insurance.goToOptionsAndEditOptions();
		insurance.goToRemarksAndAddRemark();

		editQuotesOrPolicy.commitQuoteError();
	}

	@AfterClass
	public void closeBrowser() {
		logger.info("Closing the browser");

		browser.closeBrowser();
	}

}
