package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * This class is for Claims Tab Page
 * 
 * @author Optimus
 */

public class ClaimsTabPage {

	Logger logger = Logger.getLogger(ClaimsTabPage.class);

	private final static String CLAIM_DELETE_SUCCESS_MSG = "Claim has been deleted successfully.";
	
	private By addExternalClaimBtnId = By.id("btnClaimsTabAddExternalClaimId");
	private By selectpolicyClaimId = By.id("policyClaim_1_1");
	private By deleteExternalClaimsBtnId = By.id("btnClaimsTabDeleteExternalClaimId");
	private By claimsMessageBoxId = By.id("msgbox");
	
	Button addExternalClaimBtn = new Button(addExternalClaimBtnId);
	Button selectpolicyClaim = new Button(selectpolicyClaimId);
	Button deleteExternalClaims = new Button(deleteExternalClaimsBtnId);

	private By claimsTabId = By.id("ClaimsTab_lnk");
	Button claimsTab = new Button(claimsTabId);
	PageElement verifyClaimDeleteMessage = new PageElement(claimsMessageBoxId, CLAIM_DELETE_SUCCESS_MSG);

	/**
	 * To select Add External Claim
	 */

	public void selectAddExternalClaimTab()
	{
		addExternalClaimBtn.click();
	}
	
	/**
	 * To delete an external claim
	 */
	public void deleteExternalClaim() {
		logger.info("Delete External Claims in ClaimsTabPage Class");
		Browser browser = new Browser();
		selectpolicyClaim.click();
		deleteExternalClaims.click();
		browser.acceptAlertButton();
		browser.verifyText(verifyClaimDeleteMessage);
	}

}
