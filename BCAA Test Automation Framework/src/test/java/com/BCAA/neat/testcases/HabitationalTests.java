package com.BCAA.neat.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.pageObjects.logIn.LoginPage;
import com.BCAA.neat.pageObjects.navigation.HomePage;
import com.BCAA.neat.pageObjects.navigation.InsurancePage;
import com.BCAA.neat.pageObjects.insurance.NotesTabPage;
import com.BCAA.neat.pageObjects.insurance.OptionsTabPage;
import com.BCAA.neat.pageObjects.insurance.HomeEvaluationTabPage;
import com.BCAA.neat.pageObjects.insurance.FindQuotesOrPolicyPage;
import com.BCAA.neat.pageObjects.insurance.EditQuotesOrPolicyPage;
import com.BCAA.neat.pageObjects.insurance.InsuredsTabPage;
import com.BCAA.neat.pageObjects.insurance.RemarksTabPage;
import com.BCAA.neat.pageObjects.insurance.RiskDetailsTabPage;
import com.BCAA.neat.pageObjects.POS.PosReceiptPage;
import com.BCAA.neat.pageObjects.insurance.AssetsTabPage;
import com.BCAA.neat.pageObjects.insurance.CreateReceiptPage;
import com.BCAA.neat.pageObjects.insurance.SelectInsurancePlanPage;

/**
 * 
 * This class verify the login page
 * 
 * @author Optimus
 */
public class HabitationalTests {

	Logger logger = Logger.getLogger(HabitationalTests.class);

	Browser browser = new Browser();
	LoginPage loginPage = new LoginPage();
	HomePage homePage;
	InsurancePage insurancePage;
	SelectInsurancePlanPage selectInsurancePlan;
	AssetsTabPage assetPage;
	RiskDetailsTabPage riskDetail;
	EditQuotesOrPolicyPage editQuotesAndPolicies;
	FindQuotesOrPolicyPage findQuotesAndPolicies;
	InsuredsTabPage insuredPage;
	HomeEvaluationTabPage homeEvaluationPage;
	OptionsTabPage optionsPage;
	NotesTabPage noteTabPage;
	RemarksTabPage remarksTabPage;
	CreateReceiptPage createReceiptPage;
	PosReceiptPage posReceiptPage;

	@BeforeClass
	public void setLogger() {
		PropertyConfigurator.configure("log4j.properties");
		browser.startBrowser();
		browser.navigateTo();
		loginPage.signIn();
	}
	
	/**
	 * Habitational Regression Test Cases: These are the test scripts that should be in this file
	 */
	
	/**
	 * BCAA-3946:Commit Quote, Copy and Issue a Policy
	 */
	//@Test(priority = 1, description = "BCAA-3946:Commit Quote, Copy and Issue a Policy")
	public void BCAA_3946() {
		//1. Execute flow BCAA-3943:Commit Quote and make note of the quote number.
		//TODO Write function execute this flow
		
		//2. Execute flow BCAA-4016:Go to Find Quote/Policy and Find Quote/Policy using the quote number from step #1
		//TODO  Write function execute this flow
		
		//3. Execute module BCAA-3907:Copy Quote
		//TODO  Write function execute this module
		
		//4. Execute flow BCAA-3997:Go To Options and Verify Options
		//TODO  Write function execute this flow
		
		//5. Execute flow BCAA-4002:Add Remark, Add Note, Preview Dec, Issue Policy
		//TODO  Write function execute this flow
		
		//6. Execute module BCAA-3912:Create Receipt
		//TODO  Write function execute this module
	}
	
	/**
	 * BCAA-3950:Issue an Endorsed Policy - Home 
	 */
	//@Test(priority = 1, description = "BCAA-3950:Issue an Endorsed Policy (Home)")
	public void BCAA_3950_Home() {
		//1. Execute flow BCAA-3947:Issue Policy for home asset and make a note of the policy number
		//TODO  Write function execute this flow

		//2. Execute flow BCAA-4012:Find Policy and Endorse It using the policy number in step #1
		//TODO  Write function execute this flow
		
		//3. Execute flow BCAA-4005:Go to Assets and Edit Home Evaluation
		//TODO  Write function execute this flow
	
		//4. Execute flow BCAA-4004:Go To Options and Edit Option
		//TODO  Write function execute this flow

		//5. Execute flow BCAA-4002:Add Remark, Add Note, Preview Dec, Issue Policy
		//TODO  Write function execute this flow

		//6. Execute module BCAA-3912:Create Receipt
		//TODO  Write function execute this module

		
		 
	}
	
	/**
	 * BCAA-3950:Issue an Endorsed Policy - Condo 
	 */
	//@Test(priority = 1, description = "BCAA-3950:Issue an Endorsed Policy (Condo)")
	public void BCAA_3950_Condo() {
		//1. Execute flow BCAA-3947:Issue Policy for Condo asset and make a note of the policy number
		//TODO  Write function execute this flow

		//2. Execute flow BCAA-4012:Find Policy and Endorse It using the policy number in step #1
		//TODO  Write function execute this flow
		
		//3. Execute flow BCAA-4005:Go to Assets and Edit Home Evaluation
		//TODO  Write function execute this flow
	
		//4. Execute flow BCAA-4004:Go To Options and Edit Option
		//TODO  Write function execute this flow

		//5. Execute flow BCAA-4002:Add Remark, Add Note, Preview Dec, Issue Policy
		//TODO  Write function execute this flow

		//6. Execute module BCAA-3912:Create Receipt
		//TODO  Write function execute this module

		
		 
	}
	
	/**
	 * BCAA-3950:Issue an Endorsed Policy - Tenant 
	 */
	//@Test(priority = 1, description = "BCAA-3950:Issue an Endorsed Policy (Tenant)")
	public void BCAA_3950_Tenant() {
		//1. Execute flow BCAA-3947:Issue Policy for Tenant asset and make a note of the policy number
		//TODO  Write function execute this flow

		//2. Execute flow BCAA-4012:Find Policy and Endorse It using the policy number in step #1
		//TODO  Write function execute this flow
		
		//3. Execute flow BCAA-4005:Go to Assets and Edit Home Evaluation
		//TODO  Write function execute this flow
	
		//4. Execute flow BCAA-4004:Go To Options and Edit Option
		//TODO  Write function execute this flow

		//5. Execute flow BCAA-4002:Add Remark, Add Note, Preview Dec, Issue Policy
		//TODO  Write function execute this flow

		//6. Execute module BCAA-3912:Create Receipt
		//TODO  Write function execute this module

		
		 
	}
	
	
	/**
	 * BCAA-3953: Create and Delete External Claim
	 */
	//@Test(priority = 1, description = "BCAA-3953: Create and Delete External Claim")
	public void BCAA_3953() {
		
		//1. Execute flow BCAA-3975:Log in and Go To Find Quote/policy
		
		//2. Execute flow BCAA-3986:Create Habitational Draft Quote
		
		//3. Execute module BCAA-3988:Go To Claims Tab
		
		//4. Execute module BCAA-3938:Create External Claim
		
		//5. Execute module BCAA-3900:Delete External Claim
		
	}
	
	/**
	 * BCAA-3955: Renew and Cancel a Policy (with EPP)
	 */
	//@Test(priority = 1, description = "BCAA-3955: Renew and Cancel a Policy (with EPP)")
	public void BCAA_3955_WithEPP() {
		
		//1. Execute module BCAA-3942:Renew Policy
		
		//2. Execute module BCAA-3916:Verify Options
		
		//3. Execute test case BCAA-3905:Commit Quote
		
		//4. Execute flow BCAA-4002:Add Remark, Add Note, Preview Dec, Issue Policy
		
		//5. Execute module BCAA-3956:Open Payment Plan

		//6. Execute flow BCAA-4016:Go to Find Quote/Policy and Find Quote/Policy using the policy number in step #5
		
		//7. Execute module BCAA-3957:Cancel Policy

	}
	
	/**
	 * BCAA-3955: Renew and Cancel a Policy (without EPP)
	 */
	//@Test(priority = 1, description = "BCAA-3955: Renew and Cancel a Policy (without EPP)")
	public void BCAA_3955_WithOutEPP() {
		
		//1. Execute module BCAA-3942:Renew Policy
		
		//2. Execute module BCAA-3916:Verify Options
		
		//3. Execute test case BCAA-3905:Commit Quote
		
		//4. Execute flow BCAA-4002:Add Remark, Add Note, Preview Dec, Issue Policy
		
		//5. Execute module BCAA-3912:Create Receipt
		
		//6. Execute flow BCAA-4016:Go to Find Quote/Policy and Find Quote/Policy using the policy number in step #5
		
		//7. Execute module BCAA-3957:Cancel Policy

	}
	
	/**
	 * BCAA-3960: Reinstate a Policy
	 */
	//@Test(priority = 1, description = "BCAA-3960: Reinstate a Policy")
	public void BCAA_3960() {
		
		//1. Execute flow BCAA-3958:Renew and Cancel a Policy (make note of the policy number)
		
		//2. Execute flow BCAA-4016:Go to Find Quote/Policy and Find Quote/Policy using the policy number in step #1
		
		
		//3. Execute module BCAA-3959:Reinstate a Policy
	}
	
	/**
	 * BCAA-3962: Void a Policy
	 */
	//@Test(priority = 1, description = "BCAA-3962: Void a Policy")
	public void BCAA_3962() {
		
		//1. Execute flow BCAA-3947:Issue Policy (make note of the policy number)
		
		
		//2. Execute flow BCAA-4016:Go to Find Quote/Policy and Find Quote/Policy using the policy number in step #1
		
		
		//3. Execute module BCAA-3961:Void a Policy
	}
	
	/**
	 * BCAA-3964: Commit Quote ,Copy and Issue a Policy with Multiple Assets
	 */
	//@Test(priority = 1, description = "BCAA-3964: Commit Quote ,Copy and Issue a Policy with Multiple Assets")
	public void BCAA_3964() {
		
		//1. Execute flow BCAA-3975:Log in and Go To Find Quote/policy



		//2. Execute module  BCAA-3986:Create Habitational Draft Quote



		//3. Execute flow BCAA-4000:Go To Insureds and Edit Insured



		//4. Execute flow BCAA-3983:Create Asset for a Home asset



		//5. Execute flow BCAA-3983:Create Asset for a Condo asset

		//6. Execute flow BCAA-3997:Go To Options and Verify Options


		//7. Execute module BCAA-3905:Commit Quote and make note of the quote number



		//8. Execute flow BCAA-4016:Go to Find Quote/Policy and Find Quote/Policy using the quote number from step #7

	

		//9. Execute module BCAA-3907:Copy Quote


		//10. Execute flow BCAA-4002:Add Remark, Add Note, Preview Dec, Issue Policy



		//11. Execute module BCAA-3912:Create Receipt
		
	}
	

	
	
	/**
	 * BCAA-3965: Endorse a Policy (Multiple Times) with Home Business Added
	 */
	//@Test(priority = 1, description = "BCAA-3965: Endorse a Policy (Multiple Times) with Home Business Added")
	public void BCAA_3965() {
		
		//1. Execute flow BCAA-3950:Issue an Endorsed Policy and make a note of the policy number.


		//2. Execute flow BCAA-4012:Find Policy and Endorse It using the policy number in step #1

		

		//3. Execute module BCAA-3920:Edit Home Asset



		//4. Execute module BCAA-4008:Go To Business Tab

		//5. Execute module BCAA-3966:Add Home Asset - Business

		//6. Execute flow BCAA-3997:Go To Options and Verify Options

		//7. Execute module BCAA-3905:Commit Quote


		//8. Execute flow BCAA-4002:Add Remark, Add Note, Preview Dec, Issue Policy
	}
	
	
	/**
	 * BCAA-3968:Endorse a Policy (RCT to Appraisal)
	 */
	//@Test(priority = 1, description = "BCAA-3968:Endorse a Policy (RCT to Appraisal)")
	public void BCAA_3968() {
		
		//1. Execute flow BCAA-3947:Issue Policy and make a note of the policy number

		//2. Execute flow BCAA-4012:Find Policy and Endorse It using the policy number in step #1

		//3. Execute module BCAA-3990:Go To Assets Tab

		//4. Execute module BCAA-4006:Edit Home Asset

		//5. Execute module BCAA-3969:Edit Home Asset - Switch RCT to Appraisal

		//6. Execute flow BCAA-3997:Go To Options and Verify Options

		//7. Execute module  BCAA-3905:Commit Quote

		//8. Execute flow BCAA-4002:Add Remark, Add Note, Preview Dec, Issue Policy

		//9. Execute module BCAA-3912:Create Receipt
	}
	
	/**
	 * BCAA-3971:Endorse a Policy (Upgrade from H1 to H5)
	 */
	//@Test(priority = 1, description = "BCAA-3971:Endorse a Policy (Upgrade from H1 to H5)")
	public void BCAA_3971() {
		
		//1. Execute flow BCAA-3947:Issue Policy and make a note of the policy number


		//2. Execute flow BCAA-4012:Find Policy and Endorse It using the policy number in step #1

		

		//3. Execute module BCAA-3990:Go To Assets Tab

		//4. Execute module BCAA-4006:Edit Home Asset


		//5. Execute module BCAA-3970:Edit Home Asset - Upgrade from H1 to H5

		//6. Execute flow BCAA-3997:Go To Options and Verify Options


		//7. Execute module  BCAA-3905:Commit Quote


		//8. Execute flow BCAA-4002:Add Remark, Add Note, Preview Dec, Issue Policy
	}
	

	/**
	 * BCAA-3973:Set an additional insured as the primary policyholder
	 */
	//@Test(priority = 1, description = "BCAA-3973:Set an additional insured as the primary policyholder")
	public void BCAA_3973() {
		
		//1. Execute flow  BCAA-3975:Log in and Go To Find Quote/policy

		

		//2. Execute flow  BCAA-3986:Create Habitational Draft Quote



		//3. Execute flow BCAA-4000:Go To Insureds and Edit Insured



		//4. Execute module BCAA-3972:Insureds - Set Additional Insured as Primary Policyholder

		 
		
	}
	
	
	/**
	 * BCAA-3976:Member related discounts should be removed when member is removed
	 */
	//@Test(priority = 1, description = "BCAA-3976:Member related discounts should be removed when member is removed")
	public void BCAA_3976() {
		
		//1. Execute flow  BCAA-3975:Log in and Go To Find Quote/policy

		

		//2. Execute flow  BCAA-3986:Create Habitational Draft Quote for a non-Member (9416789-03)

		

		//3. Execute flow BCAA-3983:Create Asset

		//4. Execute flow BCAA-3997:Go To Options and Verify Options

	

		//5. Execute module BCAA-3989:Go To Insureds Tab

		//6. Execute module BCAA-3935:Add Insured with member (9416789-01)

		//7. Execute flow BCAA-3997:Go To Options and Verify Options

		
		//8. Execute module BCAA-3989:Go To Insureds Tab

		//9. Execute test case BCAA-3979:Delete Insured on member (9416789-01)


		//10. Execute flow BCAA-3997:Go To Options and Verify Options
	}
	
	/**
	 * BCAA-3981:Safe Home points is adjusted accordingly when Safe Home points are earned or lost
	 */
	//@Test(priority = 1, description = "BCAA-3981:Safe Home points is adjusted accordingly when Safe Home points are earned or lost")
	public void BCAA_3981() {
		
		//1.Execute flow  BCAA-3975:Log in and Go To Find Quote/policy



		//2. Execute flow  BCAA-3986:Create Habitational Draft Quote

	

		//3. Execute flow BCAA-4000:Go To Insureds and Edit Insured

		

		//4. Execute flow BCAA-3983:Create Asset

		
		//5. Execute flow BCAA-3997:Go To Options and Verify Options

		

		//6. Execute flow BCAA-4019:Go to Assets and Edit Safe Home - select one or more Safe Home items

		

		//7. Execute flow BCAA-3997:Go To Options and Verify Options

		

		//8. Execute flow BCAA-4019:Go to Assets and Edit Safe Home - select/deselect Safe Home items


		//9. Execute flow BCAA-3997:Go To Options and Verify Options
		
	}
	
	/**
	 * BCAA-4009:Endorse an issued policy and date in the future
	 */
	//@Test(priority = 1, description = "BCAA-4009:Endorse an issued policy and date in the future")
	public void BCAA_4009() {
		
		//1. Execute flow BCAA-3947:Issue Policy and a note of the policy number


		//2.Execute flow BCAA-4012:Find Policy and Endorse It using the policy number in step #1 with an Endorsement

		//Effective Date that is one of the following:

		//1) Earlier than the original Effective Date 

		//2) Later or right on the original Expiry Date

		//3) Falls between the original policy's Effective and Expiry dates


		//3. Execute module BCAA-4011:Add Remark, Edit Insured, Commit Quote, Issue Policy and make note fo the policy number

		
		//4.Execute flow BCAA-4012:Find Policy and Endorse It using the policy number in step #3 with an Endorsement

		//Effective Date that is one of the following:

		//1) Earlier than the Endorsement Effective Date

		 
		//5. Execute module BCAA-4011:Add Remark, Edit Insured, Commit Quote, Issue Policy and make note fo the policy number
		
	}
	
	/**
	 * BCAA-4013:Adding a 2nd location asset with a different liability should result to error
	 */
	//@Test(priority = 1, description = "BCAA-4013:Adding a 2nd location asset with a different liability should result to error")
	public void BCAA_4013() {
		
		//1. Execute flow BCAA-3947:Issue Policy and make a note of the policy number


		//2. Execute flow BCAA-4012:Find Policy and Endorse It using the policy number in step #1 with an Endorsement
		//Effective Date that is one of the following:
		//1) Falls between the original policy's Effective and Expiry date

		 

		//3.Execute flow BCAA-4000:Go To Insureds and Edit Insured

		
		//4. Execute flow BCAA-3983:Create Asset but 
		//- On the Risk Details tab, fill in all mandatory fields but do not flag new asset as "Location 1"
		//- On the Home Evaluation tab, click on the [Find Property] button
		// Click on the [Calculate Building Value] button and then click [Yes] on the confirmation message dialog


		//5.Execute flow BCAA-3997:Go To Options and Verify Options

		//6. Execute module BCAA-4014:Add Options - Liability Increase Limit


		//7. Execute flow BCAA-4003:Go To Remarks and Add Remark


		//8. Execute module BCAA-3905:Commit Quote 
	}
	
	/**
	 * BCAA-4015:Trigger an authorization and have someone with authority to use the “Override Sign In” link
	 */
	//@Test(priority = 1, description = "BCAA-4015:Trigger an authorization and have someone with authority to use the “Override Sign In” link")
	public void BCAA_4015() {
		
		//1. Execute flow  BCAA-3975:Log in and Go To Find Quote/policy

		

		//2.Execute flow  BCAA-3986:Create Habitational Draft Quote



		//3.	
		//Execute flow BCAA-3983:Create Asset but
		//On the Risk Details tab, enter the following information:
		//1) Do you have a pet? = "Yes"
		//2) What type of pet? = "Pit Bull or any "bull" breed


		//4. Execute module BCAA-3991:Go To Options Tab

		

		//5.Execute module BCAA-4017:Authorize Binding Stop
	}
	
	/**
	 *  BCAA-4018:Remove FUS Override on Edit Asset page
	 */
	//@Test(priority = 1, description = " BCAA-4018:Remove FUS Override on Edit Asset page")
	public void  BCAA_4018() {
		
		//1. Execute flow  BCAA-3975:Log in and Go To Find Quote/policy


		//2. Execute flow  BCAA-3986:Create Habitational Draft Quote


		//3. Execute flow BCAA-3983:Create Asset


		//4. Execute module BCAA-4006:Edit Home Asset


		//5.Modify the input value in one of the following fields:
		//1) Hydrant
		//2) Firehall

		 

		//6. Click on the [Save] button


		//7. Click on the [Remove Fire Protection Override] button
	}
	
	
	/**
	 * Habitational Regression Test Cases
	 */

	
	
	/**
	 * BCAA-3934: Log Into NEAT
	 */
	//@Test(priority = 1, description = "BCAA-3934: Log Into NEAT")
	public void logInToNEAT() {
		homePage = new HomePage();
		homePage.verifyLogin();
	}

	/**
	 * BCAA-3986: Create Habitational Draft Quote
	 */
	//@Test(priority = 2, description = "BCAA-3986: Create Habitational Draft Quote")
	public void createDraftQuote() {
		logger.info("BCAA-3986: Create Habitational Draft Quote");

		insurancePage = new InsurancePage();
		selectInsurancePlan = new SelectInsurancePlanPage();
		findQuotesAndPolicies = new FindQuotesOrPolicyPage();
		homePage = new HomePage();

		homePage.selectInsurance();
		insurancePage = new InsurancePage();
		insurancePage.quotesAndPoliciesTab();
		findQuotesAndPolicies = new FindQuotesOrPolicyPage();
		findQuotesAndPolicies.createQuote();
		selectInsurancePlan = new SelectInsurancePlanPage();
		selectInsurancePlan.selectInsurancePlan();
	}

	/**
	 * BCAA-3931: Find Quote
	 */
	//@Test(priority = 3, description = "BCAA-3931: Find Quote")
	public void searchQuotePolicy() {
		logger.info("BCAA-3931: Find Quote");
		findQuotesAndPolicies = new FindQuotesOrPolicyPage();
		findQuotesAndPolicies = new FindQuotesOrPolicyPage();
		findQuotesAndPolicies.searchQuotePolicy();
	}

	/**
	 * BCAA-3990: Go To Assets Tab
	 */
	//@Test(priority = 4, description = "BCAA-3990: Go To Assets Tab")
	public void goToAssetsTab() {
		logger.info("BCAA-3990: Go To Assets Tab");
		createDraftQuote();
		assetPage = new AssetsTabPage();
		assetPage.addAsset();

	}

	/**
	 * 
	 * BCAA-3935: Add Insured
	 */
	//@Test(priority = 5, description = "BCAA-3935: Add Insured")
	public void addInsured() {
		logger.info("BCAA-3935: Add Insured");
		createDraftQuote();
		insuredPage = new InsuredsTabPage();
		insuredPage.insuredTab();
		insuredPage.addInsured();
	}

	/**
	 * 
	 * BCAA-3901: Edit Insured
	 * 
	 * @throws InterruptedException
	 */
	//@Test(priority = 6, description = "BCAA-3901: Edit Insured")
	public void editInsured() {
		logger.info("BCAA-3901: Edit Insured");
		createDraftQuote();
		insuredPage = new InsuredsTabPage();
		insuredPage.insuredTab();
		insuredPage.editInsured();
	}

	/**
	 * BCAA-3992: Go To Home Evaluation Tab
	 *
	 */
	//@Test(priority = 7, description = "BCAA-3992: Go To Home Evaluation Tab")
	public void goToHomeEvaluationTab() {
		logger.info("BCAA-3992: Go To Home Evaluation Tab");
		createDraftQuote();
		assetPage = new AssetsTabPage();
		assetPage.addAsset();
		riskDetail = new RiskDetailsTabPage();
		riskDetail.addRiskDetails();
		homeEvaluationPage = new HomeEvaluationTabPage();
		homeEvaluationPage.addHomeEvaluation();
	}

	/**
	 * BCAA-3930: Add Home Asset - Risk Details
	 * 
	 */
	//@Test(priority = 8, description = "BCAA-3930: Add Home Asset - Risk Details")
	public void riskDetails() {
		logger.info("BCAA-3930: Add Home Asset - Risk Details");
		goToAssetsTab();
		riskDetail = new RiskDetailsTabPage();
		riskDetail.addRiskDetails();
		assetPage = new AssetsTabPage();
		// Verify the address populated in asset page
		assetPage.verifyUpdatedAddress();

	}

	/**
	 * BCAA-3916: Verify Options
	 * 
	 * 
	 */
	//@Test(priority = 9, description = "BCAA-3916: Verify Options")
	public void verifyOptions() {
		logger.info("BCAA-3916: Verify Options");
		editQuotesAndPolicies = new EditQuotesOrPolicyPage();
		assetPage = new AssetsTabPage();
		riskDetail = new RiskDetailsTabPage();
		homeEvaluationPage = new HomeEvaluationTabPage();
		optionsPage = new OptionsTabPage();
		insuredPage = new InsuredsTabPage();

		editQuotesAndPolicies.searchAndEditAPolicy();
		insuredPage.insuredTab();
		insuredPage.editInsured();
		assetPage.addAsset();

		riskDetail.addRiskDetails();
		// Verify the address populated in asset page
		assetPage.verifyUpdatedAddress();
		homeEvaluationPage.addHomeEvaluation();

		optionsPage.verifyOptions();
	}

	/**
	 * BCAA-3905: Commit Quote
	 * 
	 */
	//@Test(priority = 10, description = "BCAA-3905: Commit Quote")
	public void commitQuote() {
		logger.info("BCAA-3905: Commit Quote");
		verifyOptions();
		editQuotesAndPolicies = new EditQuotesOrPolicyPage();
		editQuotesAndPolicies.commitQuote();
	}

	/**
	 * BCAA-3909: Add Notes
	 * 
	 */
	//@Test(priority = 11, description = "BCAA-3909: Add Notes")
	public void addNotes() {
		logger.info("BCAA-3909: Add Notes");
		commitQuote();
		noteTabPage = new NotesTabPage();
		noteTabPage.clickOnNoteTab();
		noteTabPage.addNotes();
		noteTabPage.ViewNote();
	}

	/**
	 * BCAA-3908: Add Remarks
	 * 
	 */
	//@Test(priority = 12, description = "BCAA-3908: Add Remarks")
	public void addRemarks() {
		logger.info("BCAA-3908: Add Remarks");
		commitQuote();
		remarksTabPage = new RemarksTabPage();
		remarksTabPage.clickOnRemarksTab();
		remarksTabPage.addRemarks();
	}
	
	//-----------------------------------SPRINT 2----------------------------------------------
	
	/**
	 * TA-3911: Issue Policy
	 * 
	 */
	@Test(priority = 1,description = "TA-3911: Issue Policy ")
	public void issuePolicy(){
		addRemarks();
		editQuotesAndPolicies = new EditQuotesOrPolicyPage();
		editQuotesAndPolicies.issuePolicy();
		
	}
	
	/**
	 * TA-3912:Create Receipt
	 * 
	 */
	@Test(priority = 2,description="TA-3912:Create Receipt")
	public void createReceipt(){
		posReceiptPage = new PosReceiptPage();
		createReceiptPage = new CreateReceiptPage();
		issuePolicy();
		createReceiptPage.selectCreateReceipt();
		posReceiptPage.createReceipt();
		
	}
	
	/**
	 * BCAA-4022: Verify Premiums
	 * 
	 */

	@Test(priority = 3, description = "BCAA-4022: Verify Premiums")
	public void verifyPremiums() {
		optionsPage = new OptionsTabPage();
		verifyOptions();		
		optionsPage.verifyPremiums();
		
	}
	
	/**
	 * BCAA-3914: EndorsePolicy
	 * 
	 */
	
	@Test(priority = 4, description = "BCAA-3914: EndorsePolicy")
	public void endorsePolicy() {
		SelectInsurancePlanPage selectInsurancePlanObj = new SelectInsurancePlanPage();
		selectInsurancePlanObj.selectEndorsePolicy();
		
	}

	@AfterClass
	public void closeBrowser() {
		loginPage.signOut();
		browser.closeBrowser();
	}
	
	
	
}
