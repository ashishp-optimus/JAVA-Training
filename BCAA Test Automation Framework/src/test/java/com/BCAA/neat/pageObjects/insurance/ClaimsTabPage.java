package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for Claims Tab Page
 * 
 * @author Optimus
 */

public class ClaimsTabPage {

	Logger logger;
	Browser browser;
	
	DataBaseConnection dataBaseConnection = new DataBaseConnection();
	private Map<String, String> claimTabPage = dataBaseConnection.getDatabase()
			.getPageCollectionsAsMap("CLAIMSTABPAGE");

	public ClaimsTabPage() {
		logger = Logger.getLogger(ClaimsTabPage.class);
		browser = new Browser();
	}

	private final static String CLAIM_DELETE_SUCCESS_KEY = "claimdeletesuccessmsg";
	private final static String DELETE_CLAIM_MSG = "Delete External Claims in ClaimsTabPage Class";
	private final static String SELECT_ADD_CLAIM_MSG = "Inside selectAddExternalClaimTab method in ClaimsTabPage Class";

	private By addExternalClaimBtnId = By.id("btnClaimsTabAddExternalClaimId");
	private By selectpolicyClaimId = By.id("policyClaim_1_1");
	private By deleteExternalClaimsBtnId = By.id("btnClaimsTabDeleteExternalClaimId");
	private By claimsMessageBoxId = By.id("msgbox");

	private Button addExternalClaimBtn = new Button(addExternalClaimBtnId);
	private Button selectPolicyClaim = new Button(selectpolicyClaimId);
	private Button deleteExternalClaims = new Button(deleteExternalClaimsBtnId);

	private TextBox verifyClaimDeleteMessage = new TextBox(claimsMessageBoxId,claimTabPage.get(CLAIM_DELETE_SUCCESS_KEY));

	/**
	 * To select Add External Claim
	 */

	public void selectAddExternalClaimTab() {
		logger.info(SELECT_ADD_CLAIM_MSG);
		
		addExternalClaimBtn.click();
	}

	/**
	 * To delete an external claim
	 */
	public void deleteExternalClaim() {
		logger.info(DELETE_CLAIM_MSG);

		selectPolicyClaim.clickAndWaitForVisibilityOf(deleteExternalClaims);

		deleteExternalClaims.clickAndAcceptAlertBtn();

		browser.waitForVisibilityOfElement(deleteExternalClaims);

		browser.waitForProcessingRequestBoxToDisappear();

		verifyClaimDeleteMessage.verifyText();
	}

}
