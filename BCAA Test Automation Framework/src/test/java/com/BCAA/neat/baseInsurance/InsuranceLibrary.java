package com.BCAA.neat.baseInsurance;

import com.BCAA.neat.pageObjects.POS.PosReceiptPage;
import com.BCAA.neat.pageObjects.epp.OpenPaymentPlanPage;
import com.BCAA.neat.pageObjects.insurance.AddInsuredPage;
import com.BCAA.neat.pageObjects.insurance.AddOrDeleteExternalClaimPage;
import com.BCAA.neat.pageObjects.insurance.AddOrEditAssetPage;
import com.BCAA.neat.pageObjects.insurance.AssetsTabPage;
import com.BCAA.neat.pageObjects.insurance.ClaimsTabPage;
import com.BCAA.neat.pageObjects.insurance.CreateReceiptPage;
import com.BCAA.neat.pageObjects.insurance.EditInsuredPage;
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
import com.BCAA.neat.pageObjects.navigation.InsurancePage;

/**
 * @author Optimus
 */
public class InsuranceLibrary {

	// Logger logger = Logger.getLogger(InsuranceLibrary.class);
	HomePage homePage;
	SelectInsurancePlanPage selectInsurancePlan;
	InsurancePage insurancePage;
	FindQuotesOrPolicyPage findQuotesOrPolicy;
	EditQuotesOrPolicyPage editQuotesOrPolicy;
	InsuredsTabPage insuredsTab;
	AddInsuredPage addInsured;
	EditInsuredPage editInsured;
	AssetsTabPage assetPage;
	AddOrEditAssetPage addOrEditAssetPage;
	RiskDetailsTabPage riskDetailTab;
	HomeEvaluationTabPage homeEvaluationTab;
	OptionsTabPage optionTab;
	RemarksTabPage remarksTab;
	NotesTabPage notesTab;
	ClaimsTabPage claimsTab;
	AddOrDeleteExternalClaimPage addOrDeleteExternalClaim;
	CreateReceiptPage createReceipt;
	OpenPaymentPlanPage openPaymentPlan;
	PosReceiptPage posReceipt;

	public void logInToNEAT() {
		homePage = new HomePage();
		homePage.verifyLogin();
	}

	/**
	 * TA-3987: Go To Find Insurance Quote/Policy
	 */
	public void navigateToFindQuotesAndPolicies() {

		homePage = new HomePage();
		insurancePage = new InsurancePage();

		homePage.selectInsuranceTab();
		insurancePage.navigateToQuotesAndPoliciesTab();

	}

	/**
	 * TA-3986: Create Habitational Draft Quote
	 */
	public void createQuoteWithMemberID() {
		selectInsurancePlan = new SelectInsurancePlanPage();
		findQuotesOrPolicy = new FindQuotesOrPolicyPage();
		navigateToFindQuotesAndPolicies();
		findQuotesOrPolicy.createQuote();
		selectInsurancePlan.selectInsurancePlan();

	}

	/**
	 * TA-3983: Create Asset
	 */

	public void createAsset() {
		editQuotesOrPolicy = new EditQuotesOrPolicyPage();
		assetPage = new AssetsTabPage();
		addOrEditAssetPage = new AddOrEditAssetPage();
		riskDetailTab = new RiskDetailsTabPage();
		homeEvaluationTab = new HomeEvaluationTabPage();
		editQuotesOrPolicy.navigateToAssetsTab();
		assetPage.selectAddAsset();
		addOrEditAssetPage.addAsset();
		addOrEditAssetPage.navigateToRiskDetailsTab();
		riskDetailTab.addRiskDetails();
		addOrEditAssetPage.navigateToHomeEvaluationTab();
		homeEvaluationTab.addHomeEvaluation();

	}

	/**
	 * TA-4000: Go To Insureds and Edit Insured
	 */
	public void editInsureds() {
		editQuotesOrPolicy = new EditQuotesOrPolicyPage();
		editInsured = new EditInsuredPage();
		editQuotesOrPolicy.navigateToInsuredsTab();
		editInsured.editInsured();
	}

	/**
	 * TA-4005: Go to Assets and Edit Home Evaluation
	 */
	public void editHomeAsset() {
		editQuotesOrPolicy = new EditQuotesOrPolicyPage();
		addOrEditAssetPage = new AddOrEditAssetPage();
		homeEvaluationTab = new HomeEvaluationTabPage();
		editQuotesOrPolicy.navigateToAssetsTab();
		assetPage = new AssetsTabPage();
		assetPage.selectEditAssetTab();
		addOrEditAssetPage.navigateToHomeEvaluationTab();
		homeEvaluationTab.addHomeEvaluation();
	}

}
